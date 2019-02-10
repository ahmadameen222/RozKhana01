package com.example.dell.rozkhana01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RecyclerViewAdapterDishes extends RecyclerView.Adapter<RecyclerViewAdapterDishes.MyViewHolder>{

    public interface ClickListener {

        void onPositionClicked(int position);

        void onLongClicked(int position);
    }

    private ClickListener listener;
    private Context mContext ;
    private List<Dishes> mData ;

    public ClickListener getListener() {
        return listener;
    }

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    int i=1;

    public RecyclerViewAdapterDishes(Context mContext, List<Dishes> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_dishes,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_dish_title.setText(mData.get(position).getDish_title());
        holder.dish_cat_tv.setText(mData.get(position).getDish_category());
        holder.img_dish_thumbnail.setImageResource(mData.get(position).getThumbnail());

        holder.dish_tu_count_tv.setText(/*mData.get(position).getDish_category()*/ Integer.toString(i));

        holder.items_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,FoodActivity.class);

                Bundle dataBundle = new Bundle();
                dataBundle.putString("Title",mData.get(position).getDish_title());
                dataBundle.putString("Ingredients",mData.get(position).getIngredients());
                dataBundle.putInt("Thumbnail",mData.get(position).getThumbnail());
                dataBundle.putString("Desc",mData.get(position).getDish_description());
                dataBundle.putString("ingNamesOnly",mData.get(position).getDish_ing_names());

                SharedPreferences.Editor editor = mContext.getSharedPreferences("FoodDetails", Context.MODE_PRIVATE).edit();
                editor.putString("Title",mData.get(position).getDish_title());
                editor.putString("Ingredients",mData.get(position).getIngredients());
                editor.putInt("Thumbnail",mData.get(position).getThumbnail());
                editor.putString("Desc",mData.get(position).getDish_description());
                editor.putString("ingNamesOnly",mData.get(position).getDish_ing_names());
                editor.apply();

                intent.putExtras(dataBundle);
                mContext.startActivity(intent);
            }
        });


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,FoodActivity.class);

                Bundle dataBundle = new Bundle();
                dataBundle.putString("Title",mData.get(position).getDish_title());
                dataBundle.putString("Ingredients",mData.get(position).getIngredients());
                dataBundle.putInt("Thumbnail",mData.get(position).getThumbnail());
                dataBundle.putString("Desc",mData.get(position).getDish_description());
                dataBundle.putString("ingNamesOnly",mData.get(position).getDish_ing_names());

                SharedPreferences.Editor editor = mContext.getSharedPreferences("FoodDetails", Context.MODE_PRIVATE).edit();
                editor.putString("Title",mData.get(position).getDish_title());
                editor.putString("Ingredients",mData.get(position).getIngredients());
                editor.putInt("Thumbnail",mData.get(position).getThumbnail());
                editor.putString("Desc",mData.get(position).getDish_description());
                editor.putString("ingNamesOnly",mData.get(position).getDish_ing_names());
                editor.apply();

                intent.putExtras(dataBundle);
                mContext.startActivity(intent);
            }
        });
    }

    public void UpdateList (List<Dishes> newList1)
    {
        mData = new ArrayList<>();
        mData.addAll(newList1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView tv_dish_title;
        TextView dish_cat_tv;
        ImageView img_dish_thumbnail;
        TextView thumbsUp_tv, dish_tu_count_tv;
        TextView items_tv;
        int i;
        private WeakReference<ClickListener> listenerRef;

        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            listenerRef = new WeakReference<>(listener);
            tv_dish_title = (TextView) itemView.findViewById(R.id.dish_id) ;
            img_dish_thumbnail = (ImageView) itemView.findViewById(R.id.img_dish_id);
            dish_cat_tv = (TextView)itemView.findViewById(R.id.dish_cat_tv);
            cardView = (CardView) itemView.findViewById(R.id.cardview_dishes_id);
            thumbsUp_tv = (TextView)itemView.findViewById(R.id.thumbsUp_tv);
            dish_tu_count_tv = (TextView)itemView.findViewById(R.id.dish_tu_count_tv);
            items_tv = (TextView)itemView.findViewById(R.id.items_tv);

            thumbsUp_tv.setOnClickListener(this);
            dish_tu_count_tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        /*    if (v.getId() == thumbsUp_tv.getId()) {
                Toast.makeText(v.getContext(), "ITEM PRESSED" + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                dish_tu_count_tv.setText(Integer.toString(i));
                i++;
            } else {
//
            }

            listenerRef.get().onPositionClicked(getAdapterPosition());
        */}

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
}
