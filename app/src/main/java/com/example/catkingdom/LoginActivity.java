package com.example.catkingdom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catkingdom.api.Constant;
import com.example.catkingdom.constants.IntentKeys;

public class LoginActivity extends AppCompatActivity {

    EditText mPasswordET;
    EditText mPhoneET;

    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPasswordET = findViewById(R.id.password);
        mPhoneET = findViewById(R.id.phone);

        mLogin = findViewById(R.id.log_in_btn);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int message = checkUser();
                if(message == Constant.USER_IS_NOT_EXISTED){
                    Toast.makeText(LoginActivity.this, "you're not registered yet, please register a new account and the try again", Toast.LENGTH_SHORT).show();
                }else if(message == Constant.WRONG_NAME_OR_PASSWORD){
                    Toast.makeText(LoginActivity.this, "Wrong phone number or password!", Toast.LENGTH_SHORT).show();
                }else if(message == Constant.USER_IS_EXISTED_AND_VERIFIED){
                    int id = getUserId();
                    goToMainActivity(id);
                }
            }
        });



    }

    private void goToMainActivity(int id) {

        Intent main = new Intent(this, MainActivity.class);
        main.putExtra(IntentKeys.KEY_USER_ID, id);
        startActivity(main);

    }

    private int getUserId() {
        return 1;
    }

    private int checkUser() {
        return Constant.USER_IS_EXISTED_AND_VERIFIED;
    }
}