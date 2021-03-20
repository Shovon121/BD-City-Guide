package com.example_bd_city_guide_app.cityguideapp.Traveling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example_bd_city_guide_app.cityguideapp.Place.MyMapsActivity;
import com.example_bd_city_guide_app.cityguideapp.R;

public class TravelingActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveling);
    }

    public void trainTour(View view) {
        startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.esheba.cnsbd.com/#/")));
    }

    public void planeTour(View view) {

        startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.biman-airlines.com/")));
    }

    public void boatTour(View view) {
         intent = new Intent(TravelingActivity.this, MyMapsActivity.class);
        intent.putExtra("tourCategories","boat");
        startActivity(intent);
    }


    public void busTour(View view) {
         intent = new Intent(TravelingActivity.this, MyMapsActivity.class);
        intent.putExtra("tourCategories","bus");
        startActivity(intent);
    }

    public void walking(View view) {
        startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.androidauthority.com/best-fitness-apps-android-567999/")));

    }

    public void cycleing(View view) {
        startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bicycling.com/bikes-gear/g20979462/the-best-phone-apps-for-cyclists/")));
    }
}