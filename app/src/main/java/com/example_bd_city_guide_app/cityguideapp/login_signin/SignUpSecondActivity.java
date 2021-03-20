package com.example_bd_city_guide_app.cityguideapp.login_signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;

import java.util.Calendar;

public class SignUpSecondActivity extends AppCompatActivity {


    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_second);

        //Hooks
        init();



    }

    private void init() {

        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);
    }


    public void call3rdSigupScreen(View view) {

        if (!validateAge()|!validateGender()){
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String gender = selectedGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String date = day +"/"+month+"/"+year;


        Intent intent = new Intent(getApplicationContext(), SignUp3rdActivity.class);
        //Add Transition and call next activity
//        Pair[] pairs = new Pair[5];
//        pairs[0] = new Pair(backBtn, "transition_back_arrow_btn");
//        pairs[1] = new Pair(next, "transition_next_btn");
//        pairs[2] = new Pair(login, "transition_login_btn");
//        pairs[3] = new Pair(titleText, "transition_title_text");
//        pairs[4] = new Pair(slideText, "transition_slide_text");

        // Get data from SignUp Page..
        String fullName = getIntent().getStringExtra("fullName");
        String username = getIntent().getStringExtra("username");
        String  phoneNo = getIntent().getStringExtra("phoneNo");
        String whatToDO = getIntent().getStringExtra("whatToDO");


        intent.putExtra("fullName", fullName);
        intent.putExtra("username", username);
        intent.putExtra("phoneNo", phoneNo);
        intent.putExtra("date", date);
        intent.putExtra("gender", gender);

         startActivity(intent);
        finish();



    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }


    public void callLoginFromSignUp(View view) {
    }

    public void Back(View view) {
        onBackPressed();
    }
}