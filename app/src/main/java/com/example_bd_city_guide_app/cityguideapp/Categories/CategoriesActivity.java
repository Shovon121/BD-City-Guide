package com.example_bd_city_guide_app.cityguideapp.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example_bd_city_guide_app.cityguideapp.Bank.BankActivity;
import com.example_bd_city_guide_app.cityguideapp.Education.CollageAndUnivarsityActivity;
import com.example_bd_city_guide_app.cityguideapp.Home.HomeActivity;
import com.example_bd_city_guide_app.cityguideapp.Hospital.HospitalActivity;
import com.example_bd_city_guide_app.cityguideapp.Hotel.HotelActivity;
import com.example_bd_city_guide_app.cityguideapp.Place.MyMapsActivity;
import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.Restaurent.RestaurentActivity;
import com.example_bd_city_guide_app.cityguideapp.Shop.ShopsActivity;
import com.example_bd_city_guide_app.cityguideapp.Traveling.TravelingActivity;
import com.example_bd_city_guide_app.cityguideapp.Weather.WeatherActivity;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout schoolLL,hospitalLL,restaurentLL,weatherLL,transportLL,shoppingLL,bankLL,university,hotel,bestPlace;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        msg = getIntent().getStringExtra("msg");

        schoolLL=findViewById(R.id.schoolLL);
        hospitalLL=findViewById(R.id.hospitalLL);
        restaurentLL=findViewById(R.id.restaurentLL);
        weatherLL=findViewById(R.id.weatherLL);
        transportLL=findViewById(R.id.transportLL);
        shoppingLL=findViewById(R.id.shoppingLL);
        bankLL=findViewById(R.id.bankLL);
        hotel=findViewById(R.id.hotel);
        university=findViewById(R.id.university);
        bestPlace=findViewById(R.id.bestPlace);

        schoolLL.setOnClickListener(this);
        hospitalLL.setOnClickListener(this);
        restaurentLL.setOnClickListener(this);
        weatherLL.setOnClickListener(this);
        transportLL.setOnClickListener(this);
        shoppingLL.setOnClickListener(this);
        bankLL.setOnClickListener(this);
        hotel.setOnClickListener(this);
        university.setOnClickListener(this);
        bestPlace.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {



        switch (v.getId()){

            case R.id.schoolLL:
                Intent intent = new Intent(CategoriesActivity.this,CollageAndUnivarsityActivity.class);
                intent.putExtra("msg",msg);
                startActivity(intent);
                break;

            case R.id.hospitalLL:
                Intent hospitalIntent = new Intent(CategoriesActivity.this,HospitalActivity.class);
                hospitalIntent.putExtra("msg",msg);
                startActivity(hospitalIntent);
                break;




            case R.id.restaurentLL:
                Intent restaurentIntent = new Intent(CategoriesActivity.this,RestaurentActivity.class);
                restaurentIntent.putExtra("msg",msg);
                startActivity(restaurentIntent);
                break;


            case R.id.weatherLL:
                Intent weatherIntent = new Intent(CategoriesActivity.this,WeatherActivity.class);
                startActivity(weatherIntent);
                break;


            case R.id.transportLL:
                Intent transportIntent = new Intent(CategoriesActivity.this,TravelingActivity.class);
                transportIntent.putExtra("msg",msg);
                startActivity(transportIntent);
                break;

            case R.id.shoppingLL:
                Intent shoppingIntent = new Intent(CategoriesActivity.this,ShopsActivity.class);
                shoppingIntent.putExtra("msg",msg);
                startActivity(shoppingIntent);
                break;

            case R.id.bankLL:
                Intent bankIntent = new Intent(CategoriesActivity.this, BankActivity.class);
                bankIntent.putExtra("msg",msg);
                startActivity(bankIntent);
                break;

            case R.id.hotel:
                Intent hotelIntent = new Intent(CategoriesActivity.this,HotelActivity.class);
                hotelIntent.putExtra("msg",msg);
                startActivity(hotelIntent);
                break;
            case R.id.bestPlace:
                Intent BestPlaceIntent = new Intent(CategoriesActivity.this, MyMapsActivity.class);
                BestPlaceIntent.putExtra("msg",msg);
                startActivity(BestPlaceIntent);
                break;
            case R.id.university:
                Intent UniversityIntent = new Intent(CategoriesActivity.this, HomeActivity.class);
                UniversityIntent.putExtra("msg","top varsity");
                startActivity(UniversityIntent);
                break;




        }

    }
}