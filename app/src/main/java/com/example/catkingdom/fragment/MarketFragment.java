package com.example.catkingdom.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.catkingdom.R;

import org.w3c.dom.Text;


public class MarketFragment extends Fragment {

    public static final String TAG = "market";

    TextView mShopForCatsBtn;
    TextView mShopForAccessories;

    OpenSecondLevelFragment listener;



    public MarketFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_market, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mShopForCatsBtn = view.findViewById(R.id.shop_for_cats_btn);
        mShopForAccessories = view.findViewById(R.id.shop_for_accessories_btn);

        mShopForCatsBtn.setOnClickListener(v -> listener.openSecondLevelFragment(CatsMarketFragment.TAG));
        mShopForAccessories.setOnClickListener(v -> listener.openSecondLevelFragment(AccessoriesMarketFragment.TAG));
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OpenSecondLevelFragment) {
            listener = (OpenSecondLevelFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onSecondLevelClickListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    public interface OpenSecondLevelFragment {
        void openSecondLevelFragment(String tag);
    }

}