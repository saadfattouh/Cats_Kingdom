package com.example.catkingdom.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.catkingdom.R;


public class MyAccountFragment extends Fragment {


    public static final String TAG = "myAccount";

    Button mMyAccountInfoBtn;
    Button mMyCatsBtn;
    Button mMakeSuggestionBtn;
    Button mLogoutBtn;


    public MyAccountFragment() {
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
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMyAccountInfoBtn = view.findViewById(R.id.account_btn);
        mMyCatsBtn = view.findViewById(R.id.my_cats_btn);
        mMakeSuggestionBtn = view.findViewById(R.id.suggestion_btn);
        mLogoutBtn = view.findViewById(R.id.logout_btn);

        mMyAccountInfoBtn.setOnClickListener(v -> goToMyAccountInfo());
        mMyCatsBtn.setOnClickListener(v -> goToMyCats());
        mMakeSuggestionBtn.setOnClickListener(v -> goToMakeSuggestion());
        mLogoutBtn.setOnClickListener(v -> logout());

    }

    private void logout() {

    }

    private void goToMakeSuggestion() {

    }

    private void goToMyCats() {

    }

    private void goToMyAccountInfo() {

    }
}