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
import com.example.catkingdom.adapters.ClinicsAdapter;
import com.example.catkingdom.model.Clinic;

import java.util.ArrayList;

public class ClinicsBrowseFragment extends Fragment {

    public static final String TAG = "clinics";

    ArrayList<Clinic> clinics;
    ClinicsAdapter mAdapter;
    RecyclerView mClinicsListView;


    public ClinicsBrowseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clinics = new ArrayList<Clinic>()
        {{
            add(new Clinic("first clinic", "al Reyadh, alrawda st"));
            add(new Clinic("second clinic", "al Reyadh, alrawda st"));
            add(new Clinic("third clinic", "al Reyadh, alrawda st"));
            add(new Clinic("4rth clinic", "al Reyadh, alrawda st"));
            add(new Clinic("5th clinic", "al Reyadh, alrawda st"));

        }};

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clinics_browse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mClinicsListView = view.findViewById(R.id.clinics_list);

        mAdapter = new ClinicsAdapter(getContext(), clinics);
        mClinicsListView.setAdapter(mAdapter);
    }
}