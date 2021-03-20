package com.example_bd_city_guide_app.cityguideapp.Division;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example_bd_city_guide_app.cityguideapp.Categories.CategoriesActivity;
import com.example_bd_city_guide_app.cityguideapp.R;

public class DivisionWiseDivideActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout dhaka_division,mymensing_division,barishal_division,rajshahi_division,khulna_division,chittagong_division,rangpur_division,sylhet_division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_wise_divide);

        dhaka_division = findViewById(R.id.dhaka_division);
        mymensing_division = findViewById(R.id.mymensing_division);
        barishal_division = findViewById(R.id.barishal_division);
        rajshahi_division = findViewById(R.id.rajshahi_division);
        khulna_division = findViewById(R.id.khulna_division);
        chittagong_division = findViewById(R.id.chittagong_division);
        rangpur_division = findViewById(R.id.rangpur_division);
        sylhet_division = findViewById(R.id.sylhet_division);

        dhaka_division.setOnClickListener(this);
        mymensing_division.setOnClickListener(this);
        barishal_division.setOnClickListener(this);
        rajshahi_division.setOnClickListener(this);
        khulna_division.setOnClickListener(this);
        chittagong_division.setOnClickListener(this);
        rangpur_division.setOnClickListener(this);
        sylhet_division.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {
        Intent intent = new Intent(DivisionWiseDivideActivity.this, CategoriesActivity.class);
        switch (v.getId()){
            case R.id.dhaka_division:

                intent.putExtra("msg","dhaka");
                startActivity(intent);
                break;
            case R.id.mymensing_division:
                intent.putExtra("msg","mymensingh");
                startActivity(intent);
                break;
            case R.id.barishal_division:
                intent.putExtra("msg","barishal");
                startActivity(intent);
                break;
            case R.id.rajshahi_division:
                intent.putExtra("msg","rajshahi");
                startActivity(intent);
                break;
            case R.id.khulna_division:
                intent.putExtra("msg","khulna");
                startActivity(intent);
                break;
            case R.id.chittagong_division:
                intent.putExtra("msg","chittagong");
                startActivity(intent);
                break;
            case R.id.rangpur_division:
                intent.putExtra("msg","rangpur");
                startActivity(intent);
                break;
            case R.id.sylhet_division:
                intent.putExtra("msg","sylhet");
                startActivity(intent);
                break;

        }
    }
}