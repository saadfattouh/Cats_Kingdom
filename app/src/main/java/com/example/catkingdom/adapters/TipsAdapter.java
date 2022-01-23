package com.example.catkingdom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catkingdom.R;
import com.example.catkingdom.model.Tip;

import java.util.ArrayList;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {


    ArrayList<Tip> tips;
    Context context;

    public TipsAdapter(Context context, ArrayList<Tip> tips) {
        this.tips = tips;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.tip_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Tip tip = tips.get(position);

        holder.mTitle.setText(tip.getTitle());
        holder.mPublishDate.setText(tip.getPublishDate());

    }

    @Override
    public int getItemCount() {
        return tips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mPublishDate;
        TextView mTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPublishDate = itemView.findViewById(R.id.publish_date);
            mTitle = itemView.findViewById(R.id.title);
        }
    }
}
