package com.example_bd_city_guide_app.cityguideapp.login_signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.UserDeshBoard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp3rdActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ScrollView scrollView;
    private TextInputLayout email, password;
    private String _email, _password, _fullName, _username, _phoneNo, _date, _gender, whatToDO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd);
        scrollView = findViewById(R.id.signUp3rdScroolView);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);

        mAuth = FirebaseAuth.getInstance();


    }


    public void callVerifyOTPScreen(View view) {


        if (!validateEmail() | !validatePassword()) {
            return;
        }


        //Get all the data from Intent
        _email = email.getEditText().getText().toString().trim();
        _email = _email.toLowerCase();
        _password = password.getEditText().getText().toString().trim();
        _fullName = getIntent().getStringExtra("fullName");
        _username = getIntent().getStringExtra("username");
        _phoneNo = getIntent().getStringExtra("phoneNo");
        _date = getIntent().getStringExtra("date");
        _gender = getIntent().getStringExtra("gender");
        whatToDO = getIntent().getStringExtra("whatToDO");


        CreateAccount(_email, _password);


    }

    private void CreateAccount(String email, String password) {


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            startActivity(new Intent(getApplicationContext(), UserDeshBoard.class));
                            Toast.makeText(SignUp3rdActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();

                            storeNewUsersData();


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(SignUp3rdActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });


    }

    private void storeNewUsersData() {

        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");

        //Create helperclass reference and store data using firebase
        UserHelperClass addNewUser = new UserHelperClass(_fullName, _username, _email, _phoneNo, _password, _date, _gender);

        //======== .com remove this  email and data save this email============
        String getQueryEmail =getQueryEmail(_email);

        if (!getQueryEmail.isEmpty()){
            reference.child(getQueryEmail).setValue(addNewUser);
        }


        //We will also create a Session here in next videos to keep the user logged In

        startActivity(new Intent(getApplicationContext(), UserDeshBoard.class));
        finish();

    }


    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
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
            password.setError("Field can not be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    //=======Important Method============
    private String getQueryEmail(String email) {
        String data = email.replace(".com","");

        return data;
    }

    public void Back(View view) {
        onBackPressed();
    }
}