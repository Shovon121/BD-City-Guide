package com.example_bd_city_guide_app.cityguideapp.Bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;

public class SelectedBankActivity extends AppCompatActivity {

    private Button bankHeadOffice;
    private Button bankBranc;
    private String msg;
    private String divisionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_bank);

        bankHeadOffice = findViewById(R.id.bankHeadOffice);
        bankBranc = findViewById(R.id.bankBranc);


        msg = getIntent().getStringExtra("msg");
        divisionName = getIntent().getStringExtra("divisionName");

        bankHeadOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectedBankActivity.this, BankHeadOfficeActivity.class));
            }
        });

        bankBranc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (divisionName == null) {
                    Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                } else if (msg.equals("sunalibank")) {
                    if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/sylhet.html")));

                    }


                } else if (msg.equals("rupalibank")) {
                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/rbl/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/rbl/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/rbl/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/rbl/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/rbl/branches/chittagong.html")));


                    } else if (divisionName.isEmpty()) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/rbl/branches/sylhet.html")));

                    }


                } else if (msg.equals("agranibank")) {
                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/agbk/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/agbk/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/agbk/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/agbk/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/agbk/branches/khulna.html")));


                    } else if (divisionName.isEmpty()) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/agbk/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/agbk/branches/sylhet.html")));

                    }

                } else if (msg.equals("islamiyabank")) {
                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ibbl/branches/sylhet.html")));

                    }

                } else if (msg.equals("brackbank")) {
                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/brac/branches/sylhet.html")));

                    }

                } else if (msg.equals("krisybank")) {

                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/bkb/branches/sylhet.html")));

                    }
                } else if (msg.equals("nationalbank")) {

                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nbl/branches/sylhet.html")));

                    }
                } else if (msg.equals("nccbank")) {
                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/nccl/branches/sylhet.html")));

                    }
                } else if (msg.equals("ucbbank")) {
                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/ucbl/branches/sylhet.html")));

                    }
                } else if (msg.equals("pubalibank")) {
                    if (divisionName == null) {
                        Toast.makeText(SelectedBankActivity.this, "Sorry! You are not selected any Divisions!", Toast.LENGTH_SHORT).show();
                    } else if (divisionName.equals("dhaka")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/sbl/branches/dhaka.html")));

                    } else if (divisionName.equals("mymensingh")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/pbl/branches/mymensingh.html")));


                    } else if (divisionName.equals("barishal")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/pbl/branches/barisal.html")));


                    } else if (divisionName.equals("rajshahi")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/pbl/branches/rajshahi.html")));

                    } else if (divisionName.equals("khulna")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/pbl/branches/khulna.html")));


                    } else if (divisionName.equals("chittagong")) {

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/pbl/branches/chittagong.html")));


                    } else if (divisionName.equals("rangpur")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/pbl/branches/rangpur.html")));


                    } else if (divisionName.equals("sylhet")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banksbd.org/pbl/branches/sylhet.html")));

                    }
                }

            }
        });


    }
}