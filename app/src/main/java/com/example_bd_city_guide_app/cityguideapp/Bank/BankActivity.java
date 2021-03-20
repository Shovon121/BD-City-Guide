package com.example_bd_city_guide_app.cityguideapp.Bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example_bd_city_guide_app.cityguideapp.R;

public class BankActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout sunalibank,rupalibank,agranibank,islamiyabank,krisybank,brackbank,nationalbank,nccbank,ucbbank,pubalibank;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
         msg = getIntent().getStringExtra("msg");



        sunalibank = findViewById(R.id.sunalibank);
        rupalibank = findViewById(R.id.rupalibank);
        agranibank = findViewById(R.id.agranibank);
        islamiyabank = findViewById(R.id.islamiyabank);
        krisybank = findViewById(R.id.krisybank);
        brackbank = findViewById(R.id.brackbank);
        nationalbank = findViewById(R.id.nationalbank);
        nccbank = findViewById(R.id.nccbank);
        ucbbank = findViewById(R.id.ucbbank);
        pubalibank = findViewById(R.id.pubalibank);


        sunalibank.setOnClickListener(this);
        rupalibank.setOnClickListener(this);
        agranibank.setOnClickListener(this);
        islamiyabank.setOnClickListener(this);
        krisybank.setOnClickListener(this);
        brackbank.setOnClickListener(this);
        nationalbank.setOnClickListener(this);
        nccbank.setOnClickListener(this);
        ucbbank.setOnClickListener(this);
        pubalibank.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(BankActivity.this, SelectedBankActivity.class);
        switch (v.getId()){
            case R.id.sunalibank:

                intent.putExtra("msg","sunalibank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.rupalibank:
                intent.putExtra("msg","rupalibank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.agranibank:
                intent.putExtra("msg","agranibank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.islamiyabank:
                intent.putExtra("msg","islamiyabank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.krisybank:
                intent.putExtra("msg","krisybank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.brackbank:
                intent.putExtra("msg","brackbank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.nationalbank:
                intent.putExtra("msg","nationalbank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.nccbank:
                intent.putExtra("msg","nccbank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.ucbbank:
                intent.putExtra("msg","ucbbank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;
            case R.id.pubalibank:
                intent.putExtra("msg","pubalibank");
                intent.putExtra("divisionName",msg);
                startActivity(intent);
                break;

        }
    }
}