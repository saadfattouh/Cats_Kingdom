package com.example.catkingdom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Button mLoginBtn;
    Button mSignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mLoginBtn = findViewById(R.id.log_in_btn);
        mSignUpBtn = findViewById(R.id.sign_up_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUp();
            }
        });

    }

    public void goToLogin()
    {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
//        finish();
    }

    public void goToSignUp()
    {
        Intent signUp = new Intent(this, SignUpActivity.class);
        startActivity(signUp);
//        finish();
    }
}