package com.example.catkingdom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catkingdom.R;
import com.example.catkingdom.model.Clinic;

import java.util.ArrayList;

public class ClinicsAdapter extends RecyclerView.Adapter<ClinicsAdapter.ViewHolder> {


    ArrayList<Clinic> clinics;
    Context context;

    public ClinicsAdapter(Context context, ArrayList<Clinic> clinics) {
        this.clinics = clinics;
        this.context = context;
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.clinic_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            Clinic clinic = clinics.get(position);

            holder.mName.setText(clinic.getName());
            holder.mAddress.setText(clinic.getAddress());

    }

    @Override
    public int getItemCount() {
        return clinics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mName;
        TextView mAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mAddress = itemView.findViewById(R.id.address);
        }
    }
}

