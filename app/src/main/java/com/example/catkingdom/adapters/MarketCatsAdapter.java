package com.example.catkingdom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catkingdom.R;
import com.example.catkingdom.model.Cat;

import java.util.ArrayList;

public class MarketCatsAdapter extends RecyclerView.Adapter<MarketCatsAdapter.ViewHolder> {


    ArrayList<Cat> cats;
    Context context;

    public MarketCatsAdapter(ArrayList<Cat> cats, Context context) {
        this.cats = cats;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.cat_in_market_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Cat cat = cats.get(position);

        holder.mType.setText(cat.getType());
        holder.mPrice.setText(cat.getPrice());
        holder.mColor.setText(cat.getColor());
        holder.mAge.setText(cat.getAge());

        if(cat.getImageUrl() == null){
            Glide.with(context)
                    .load(context.getResources().getDrawable(R.drawable.ic_image_icon))
                    .into(holder.mImage);
        }else{
            Glide.with(context)
                    .load(cat.getImageUrl())
                    .into(holder.mImage);
        }


    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mType;
        TextView mAge;
        TextView mColor;
        TextView mPrice;
        ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mType = itemView.findViewById(R.id.cat_type);
            mAge = itemView.findViewById(R.id.cat_age);
            mColor = itemView.findViewById(R.id.cat_color);
            mPrice = itemView.findViewById(R.id.cat_price);
            mImage = itemView.findViewById(R.id.cat_image);
        }
    }
}

