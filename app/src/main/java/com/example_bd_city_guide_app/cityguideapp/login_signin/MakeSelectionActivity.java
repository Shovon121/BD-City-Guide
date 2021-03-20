package com.example_bd_city_guide_app.cityguideapp.login_signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example_bd_city_guide_app.cityguideapp.R;

public class MakeSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
    }

    public void callBackScreenFromMakeSelection(View view) {

    }


    public void viaPhone(View view) {

    }

    public void viaEmail(View view) {

        startActivity(new Intent(MakeSelectionActivity.this,SetNewPasswordActivity.class));
    }
}