package com.example.catkingdom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class AddCatFroSaleActivity extends AppCompatActivity {

    EditText mTypeET;
    EditText mColorET;
    EditText mAgeET;
    EditText mExtraDetailsET;
    EditText mPriceET;
    ImageView mAddImageBtn;

    Button mSaveBtn;

    private static final int PICK_IMAGE_REQUEST = 1;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cat_fro_sale);

        bindViews();

        mAddImageBtn.setOnClickListener(v -> openFileChooser());
        mSaveBtn.setOnClickListener(v -> {
            if(validateUserInput()){
                saveNewCat();
                finish();
            }
        });


    }


    private boolean validateUserInput() {
        return true;
    }

    //todo api call
    private void saveNewCat() {
        Toast.makeText(this, "added new cat successfully!", Toast.LENGTH_SHORT).show();
    }

    private void bindViews() {
        mTypeET = findViewById(R.id.cat_type_edit_text);
        mColorET = findViewById(R.id.cat_color_edit_text);
        mAgeET = findViewById(R.id.age_edit_text);
        mExtraDetailsET = findViewById(R.id.accessories_edit_text);
        mPriceET = findViewById(R.id.price_edit_text);
        mAddImageBtn = findViewById(R.id.add_image_btn);
        mSaveBtn = findViewById(R.id.save_Btn);
    }


    //..................Methods for File Chooser.................
    public void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();

            mAddImageBtn.setBackgroundResource(R.color.white);

            Glide.with(this)
                    .load(imageUri)
                    .into(mAddImageBtn);
        }
    }
    //..............................................................................
}