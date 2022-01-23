package com.example.catkingdom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class AccountDetailsActivity extends AppCompatActivity {

    ImageView mHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        mHomeBtn = findViewById(R.id.home_btn);

        mHomeBtn.setOnClickListener(v -> onBackPressed());

    }
}