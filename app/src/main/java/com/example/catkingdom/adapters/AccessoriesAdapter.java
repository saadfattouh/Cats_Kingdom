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
import com.example.catkingdom.model.Accessory;

import java.util.ArrayList;

public class AccessoriesAdapter extends RecyclerView.Adapter<AccessoriesAdapter.ViewHolder> {


    ArrayList<Accessory> accessories;
    Context context;

    public AccessoriesAdapter(ArrayList<Accessory> accessories, Context context) {
        this.accessories = accessories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.accessories_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Accessory accessory = accessories.get(position);

        holder.mType.setText(accessory.getType());
        holder.mDescription.setText(accessory.getDescription());

        if(accessory.getImageUrl() == null){
            Glide.with(context)
                    .load(context.getResources().getDrawable(R.drawable.ic_image_icon))
                    .into(holder.mImage);
        }else{
            Glide.with(context)
                    .load(accessory.getImageUrl())
                    .into(holder.mImage);
        }


    }

    @Override
    public int getItemCount() {
        return accessories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mType;
        TextView mDescription;
        ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mType = itemView.findViewById(R.id.acc_type);
            mDescription = itemView.findViewById(R.id.acc_description);
            mImage = itemView.findViewById(R.id.acc_image);
        }
    }
}