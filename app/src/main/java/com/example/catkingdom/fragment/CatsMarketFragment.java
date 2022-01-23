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
import com.example.catkingdom.adapters.MarketCatsAdapter;
import com.example.catkingdom.model.Cat;

import java.util.ArrayList;


public class CatsMarketFragment extends Fragment {


    public static final String TAG = "catsMarket";

    ArrayList<Cat> cats;
    MarketCatsAdapter mAdapter;
    RecyclerView mCatsListView;


    public CatsMarketFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cats = new ArrayList<Cat>()
        {{
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
            add(new Cat("tigerCat", "brown", "4", "300", null));
        }};

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cats_market, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCatsListView = view.findViewById(R.id.cats_list);

        mAdapter = new MarketCatsAdapter(cats, getContext());

        mCatsListView.setAdapter(mAdapter);
    }
}