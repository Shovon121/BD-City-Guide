package com.example_bd_city_guide_app.cityguideapp.login_signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextInputLayout forgotEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        forgotEmail =findViewById(R.id.forget_email);
        mAuth = FirebaseAuth.getInstance();

    }


    public void verifyEmail(View view) {

        String _email = forgotEmail.getEditText().getText().toString().trim();

        if (TextUtils.isEmpty(_email)){
            Toast.makeText(this, "Please! Enter Email Address!", Toast.LENGTH_SHORT).show();
        }else {
            mAuth.sendPasswordResetEmail(_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()){
                        Toast.makeText(ForgotPasswordActivity.this, "Please! visit your email and reset your password!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ForgotPasswordActivity.this,LoginRetailerActivity.class));
                    }else{
                        Toast.makeText(ForgotPasswordActivity.this, "Error, \n"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}