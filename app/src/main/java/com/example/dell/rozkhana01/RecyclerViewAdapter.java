package com.example.dell.rozkhana01;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.dell.rozkhana01.DishesActivity.API_URL;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Food> mData ;

    public static final String API_URL="http://192.168.56.1:8000/app/sendDishes/";
    RequestQueue rq;



    public RecyclerViewAdapter(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;
        rq=Volley.newRequestQueue(mContext);
        rq.start();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_food,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.tv_food_title.setText(mData.get(position).getTitle());
        holder.img_food_thumbnail.setImageResource(mData.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,DishesActivity.class);
                // passing data to the book activity
                intent.putExtra("Title", mData.get(position).getTitle());


                StringRequest putReq = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            Toast.makeText(mContext, "RESPONSE FROM SERVER", Toast.LENGTH_SHORT).show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }) {

                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("category", mData.get(position).getTitle());


                        return params;
                    }

                };
                rq.add(putReq);


                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);
            }
        });
    }


    public void UpdateList (List<Food> newList)
    {
        mData = new ArrayList<>();
        mData.addAll(newList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_food_title;
        ImageView img_food_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_food_title = (TextView) itemView.findViewById(R.id.food_id) ;
            img_food_thumbnail = (ImageView) itemView.findViewById(R.id.img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
