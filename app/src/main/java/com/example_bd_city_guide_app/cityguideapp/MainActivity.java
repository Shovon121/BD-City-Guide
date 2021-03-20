package com.example_bd_city_guide_app.cityguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example_bd_city_guide_app.cityguideapp.login_signin.LoginWelcomeActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private final int SPLASH_TIMER=5000;
    private ImageView backgroundImage;
    private TextView poweredBy;

    Animation sideAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);


        mAuth = FirebaseAuth.getInstance();

        checkUser();

    }

    private void checkUser() {

        if (mAuth.getCurrentUser() != null) {
            // User is signed in (getCurrentUser() will be null if not signed in)
            startActivity(new Intent(MainActivity.this, UserDeshBoard.class));
            finish();

        }else {
            backgroundImage.setAnimation(sideAnim);
            poweredBy.setAnimation(bottomAnim);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, LoginWelcomeActivity.class);
                    startActivity(intent);
                    finish();

                }
            },SPLASH_TIMER);

        }
    }

    private void init() {
        backgroundImage = findViewById(R.id.backgroundImage);
        poweredBy = findViewById(R.id.poweredBy);
    }
}