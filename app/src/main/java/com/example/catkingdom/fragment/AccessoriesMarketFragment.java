package com.example.catkingdom.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catkingdom.R;
import com.example.catkingdom.adapters.AccessoriesAdapter;
import com.example.catkingdom.adapters.MarketCatsAdapter;
import com.example.catkingdom.model.Accessory;
import com.example.catkingdom.model.Cat;

import java.util.ArrayList;

public class AccessoriesMarketFragment extends Fragment {

    public static final String TAG = "accessories";

    ArrayList<Accessory> accessories;
    AccessoriesAdapter mAdapter;
    RecyclerView mAccessoriesListView;


    public AccessoriesMarketFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accessories = new ArrayList<Accessory>()
        {{
            add(new Accessory(null, "accessory", "cats bells"));
            add(new Accessory(null, "food", "cats food"));
            add(new Accessory(null, "container", "cats container"));
            add(new Accessory(null, "accessory", "cats bells"));
            add(new Accessory(null, "food", "cats food"));
            add(new Accessory(null, "container", "cats container"));
            add(new Accessory(null, "accessory", "cats bells"));
            add(new Accessory(null, "food", "cats food"));
            add(new Accessory(null, "container", "cats container"));
        }};

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accessories_market, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAccessoriesListView = view.findViewById(R.id.acc_list);

        mAdapter = new AccessoriesAdapter(accessories, getContext());

        mAccessoriesListView.setAdapter(mAdapter);
    }
}