package com.example_bd_city_guide_app.cityguideapp.login_signin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example_bd_city_guide_app.cityguideapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUpRetailerActivity extends AppCompatActivity {

    private ImageView backBtn;
    private Button next, login;
    private TextView titleText;
    private TextInputLayout fullName, userName, phoneNumber;
    private CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_retailer);

        init();


    }

    private void init() {
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        fullName = findViewById(R.id.signup_fullname);
        userName = findViewById(R.id.signup_username);
        phoneNumber = findViewById(R.id.signup_phone_number);
        countryCodePicker = findViewById(R.id.country_code_picker);

    }

    public void callNextSigupScreen(View view) {


        if (!validateFullName() | !validateUsername() | !validatePhoneNumber()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), SignUpSecondActivity.class);

        //Pass all fields to the next activity
        //Get complete phone number
        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
//Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }
//Complete phone number
        final String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;
        intent.putExtra("fullName", fullName.getEditText().getText().toString().trim());
        intent.putExtra("username", userName.getEditText().getText().toString().trim());
        intent.putExtra("phoneNo", _phoneNo);


        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpRetailerActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
        finish();

    }

    public void callLoginFromSignUp(View view) {

    }

    private boolean validateFullName() {
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String val = userName.getEditText().getText().toString().trim();
        String checkspaces = "Aw{1,20}z";

        //String checkSpace = "\\A\\w{1,20}z\\";

        if (val.isEmpty()) {
            userName.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            userName.setError("Username is too large!");
            return false;
        } else {
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        String checkspaces = "Aw{1,20}z";
        if (val.length() > 0 && val.charAt(0) == 0) {
            val = val.substring(1);
        }
        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid phone number");
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }

    }

    public void Back(View view) {
        onBackPressed();
    }
}