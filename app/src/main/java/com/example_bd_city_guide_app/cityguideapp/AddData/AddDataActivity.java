package com.example_bd_city_guide_app.cityguideapp.AddData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.UserDeshBoard;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDataActivity extends AppCompatActivity {

    EditText id, placeName, place, phoneNo, website, description;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        id = findViewById(R.id.idAdd);
        placeName = findViewById(R.id.placeNameAdd);
        place = findViewById(R.id.placeAdd);
        phoneNo = findViewById(R.id.phoneNoAdd);
        website = findViewById(R.id.websiteAdd);
        description = findViewById(R.id.descriptionAdd);
        save = findViewById(R.id.saveAdd);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });


    }

    private void saveData() {

        String _id = id.getText().toString().trim();
        String _placeName = placeName.getText().toString().trim();
        String _place = place.getText().toString().trim();
        String _website = website.getText().toString().trim();
        String _phoneNo = phoneNo.getText().toString().trim();
        String _description = description.getText().toString().trim();
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("All Descriptions");

        //Create helperclass reference and store data using firebase
        DataAddHelper addNewUser = new DataAddHelper(_id,_placeName,_place,_website,_phoneNo,_description);
        reference.child(_id).setValue(addNewUser);

        //We will also create a Session here in next videos to keep the user logged In

        startActivity(new Intent(getApplicationContext(), UserDeshBoard.class));
        Toast.makeText(this, "Data Add Successful", Toast.LENGTH_SHORT).show();
        finish();

    }
}