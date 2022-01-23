package com.example.catkingdom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catkingdom.constants.IntentKeys;


public class SignUpActivity extends AppCompatActivity {


    EditText mUserNameET;
    EditText mPasswordET;
    EditText mPhoneET;
    EditText mAddressET;
    EditText mBirthDateEt;
    Button mSignUpBtn;

    String verificationMessage = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUserNameET = findViewById(R.id.user_name);
        mPasswordET = findViewById(R.id.password);
        mPhoneET = findViewById(R.id.phone);
        mAddressET = findViewById(R.id.address);
        mBirthDateEt = findViewById(R.id.birth_date);

        mSignUpBtn = findViewById(R.id.sign_up_btn);



        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verifyInput()){
                    if(!userExisted()){
                        int id = createNewUser();
                        goToMainActivity(id);
                    }else{
                        Toast.makeText(SignUpActivity.this, "this phone number is already registered here, please login into your account", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignUpActivity.this, verificationMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void goToMainActivity(int id) {

        Intent main = new Intent(this, MainActivity.class);
        main.putExtra(IntentKeys.KEY_USER_ID, id);
        startActivity(main);
    }



    //api call
    private int createNewUser() {
        return 1;
    }

    //api call
    private boolean userExisted() {
        return true;
    }

    //offline working
    private boolean verifyInput() {
        return true;
    }
}