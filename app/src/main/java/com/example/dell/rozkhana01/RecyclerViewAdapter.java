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

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Food> mData ;

    public RecyclerViewAdapter(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;
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
                intent.putExtra("Title",mData.get(position).getTitle());
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
