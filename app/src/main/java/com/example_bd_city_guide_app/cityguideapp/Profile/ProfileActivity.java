package com.example_bd_city_guide_app.cityguideapp.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private ImageView backIV, profileImage, editProfileImage;
    private TextView name, email, phoneNo, gender, dateOfBirth;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private ProgressBar profileProgressBar;
    String setDataProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();

        setDataProfile = mAuth.getCurrentUser().getEmail();
        String _gueryEmail = getQueryEmail(setDataProfile);

        if (!_gueryEmail.isEmpty()) {
            profileProgressBar.setVisibility(View.VISIBLE);
            Query databaseReference = FirebaseDatabase.getInstance().getReference("Users");
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    String _fullName = snapshot.child(_gueryEmail).child("fullName").getValue(String.class);
                    String _email = snapshot.child(_gueryEmail).child("email").getValue(String.class);
                    String _phone = snapshot.child(_gueryEmail).child("phoneNo").getValue(String.class);
                    String _age = snapshot.child(_gueryEmail).child("date").getValue(String.class);
                    String _gender = snapshot.child(_gueryEmail).child("gender").getValue(String.class);


                    name.setText(_fullName);
                    email.setText(_email);
                    phoneNo.setText(_phone);
                    gender.setText(_gender);
                    dateOfBirth.setText(_age);
                    profileProgressBar.setVisibility(View.GONE);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }else {
            Toast.makeText(this, "No data found!", Toast.LENGTH_SHORT).show();
        }


    }

    private void init() {

        backIV = findViewById(R.id.profile_back_button);
        profileImage = findViewById(R.id.profileIV);
        editProfileImage = findViewById(R.id.editProfileImage);
        name = findViewById(R.id.profileName);
        email = findViewById(R.id.profileEmail);
        phoneNo = findViewById(R.id.profilePhone);
        gender = findViewById(R.id.profileGender);
        dateOfBirth = findViewById(R.id.profileDateOfBirth);
        profileProgressBar = findViewById(R.id.profileProgressBar);
        mAuth = FirebaseAuth.getInstance();

    }
    //=======Important Method============
    private String getQueryEmail(String email) {
        String data = email.replace(".com","");

        return data;
    }
}