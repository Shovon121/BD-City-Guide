package com.example_bd_city_guide_app.cityguideapp.login_signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example_bd_city_guide_app.cityguideapp.R;

public class SetNewPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }

    public void goToHomeFromSetNewPassword(View view) {
    }

    public void setNewPasswordBtn(View view) {
        startActivity(new Intent(SetNewPasswordActivity.this,SuccessMessageActivity.class));
    }
}