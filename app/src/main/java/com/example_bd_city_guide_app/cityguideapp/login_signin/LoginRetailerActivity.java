package com.example_bd_city_guide_app.cityguideapp.login_signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.UserDeshBoard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

public class LoginRetailerActivity extends AppCompatActivity {

    private TextInputLayout loginEmail;
    private TextInputLayout loginPassword;
    private Button logInBtn;
    private FirebaseAuth mAuth;
    private String email;
    private String password;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_retailer);

        init();


    }

    private void init() {

        loginEmail = findViewById(R.id.logInTIL);
        loginPassword = findViewById(R.id.loginPassTIL);
        logInBtn = findViewById(R.id.loginBtn);
        progressBar = findViewById(R.id.logInprogressbar);
        mAuth = FirebaseAuth.getInstance();
    }

    public void forgotPassword(View view) {
        startActivity(new Intent(LoginRetailerActivity.this, ForgotPasswordActivity.class));
    }

    public void logIn(View view) {

        if (!validateEmail() | !validatePassword()) {
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        email = loginEmail.getEditText().getText().toString().trim();
        email = email.toLowerCase();
        password = loginPassword.getEditText().getText().toString().trim();
        //  queryData(email, password);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginRetailerActivity.this, "LogIn Successfull!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), UserDeshBoard.class));

                    finish();

                } else {
                    //====Valid Password=======
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginRetailerActivity.this, "Invalid  Password!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }


    private boolean validateEmail() {
        String val = loginEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            loginEmail.setError("Field can not be empty");
            return false;
        } else {
            loginEmail.setError(null);
            loginEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = loginPassword.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            loginPassword.setError("Field can not be empty");
            return false;
        } else {
            loginPassword.setError(null);
            loginPassword.setErrorEnabled(false);
            return true;
        }
    }

    public void Back(View view) {
        onBackPressed();
    }


}