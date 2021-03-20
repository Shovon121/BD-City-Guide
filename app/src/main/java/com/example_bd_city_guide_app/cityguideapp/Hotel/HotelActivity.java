package com.example_bd_city_guide_app.cityguideapp.Hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example_bd_city_guide_app.cityguideapp.Description.DescriptionActivity;
import com.example_bd_city_guide_app.cityguideapp.R;

public class HotelActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout intercontinental,radisson,westin,lemeridien,sixseasons,roseview,amari,dhakaregency,dusai,coxtoday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hotel);
        intercontinental = findViewById(R.id.intercontinental);
        radisson = findViewById(R.id.radisson);
        westin = findViewById(R.id.westin);
        lemeridien = findViewById(R.id.lemeridien);
        sixseasons = findViewById(R.id.sixseasons);
        roseview = findViewById(R.id.roseview);
        amari = findViewById(R.id.amari);
        dhakaregency = findViewById(R.id.dhakaregency);
        dusai = findViewById(R.id.dusai);
        coxtoday = findViewById(R.id.coxtoday);

        intercontinental.setOnClickListener(this);
        radisson.setOnClickListener(this);
        westin.setOnClickListener(this);
        lemeridien.setOnClickListener(this);
        sixseasons.setOnClickListener(this);
        roseview.setOnClickListener(this);
        amari.setOnClickListener(this);
        dhakaregency.setOnClickListener(this);
        dusai.setOnClickListener(this);
        coxtoday.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HotelActivity.this, DescriptionActivity.class);
        switch (v.getId()){
            case R.id.intercontinental:

                intent.putExtra("msg","intercontinental");
                startActivity(intent);
                break;
            case R.id.radisson:
                intent.putExtra("msg","radisson");
                startActivity(intent);
                break;
            case R.id.westin:
                intent.putExtra("msg","westin");
                startActivity(intent);
                break;
            case R.id.lemeridien:
                intent.putExtra("msg","lemeridien");
                startActivity(intent);
                break;
            case R.id.sixseasons:
                intent.putExtra("msg","sixseasons");
                startActivity(intent);
                break;
            case R.id.roseview:
                intent.putExtra("msg","roseview");
                startActivity(intent);
                break;
            case R.id.amari:
                intent.putExtra("msg","amari");
                startActivity(intent);
                break;
            case R.id.dhakaregency:
                intent.putExtra("msg","dhakaregency");
                startActivity(intent);
                break;
            case R.id.dusai:
                intent.putExtra("msg","dusai");
                startActivity(intent);
                break;
            case R.id.coxtoday:
                intent.putExtra("msg","coxtoday");
                startActivity(intent);
                break;

        }
    }
}