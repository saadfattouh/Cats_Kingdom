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
import com.example.catkingdom.adapters.TipsAdapter;
import com.example.catkingdom.model.Tip;

import java.util.ArrayList;


public class TipsFragment extends Fragment {

    ArrayList<Tip> tips;
    TipsAdapter mAdapter;
    RecyclerView mTipsListView;

    public static final String TAG = "dailyTips";


    public TipsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tips = new ArrayList<Tip>()
        {{
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));
            add(new Tip("here's a new thought about cats !", "02/22/2021"));

        }};

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTipsListView = view.findViewById(R.id.tips_list);


        mAdapter = new TipsAdapter(getContext(), tips);

        mTipsListView.setAdapter(mAdapter);

    }
}