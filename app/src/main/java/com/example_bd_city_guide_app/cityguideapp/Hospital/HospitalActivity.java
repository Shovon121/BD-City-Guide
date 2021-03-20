package com.example_bd_city_guide_app.cityguideapp.Hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example_bd_city_guide_app.cityguideapp.Home.HomeActivity;
import com.example_bd_city_guide_app.cityguideapp.Home.HomeAdapter;
import com.example_bd_city_guide_app.cityguideapp.R;

import java.util.ArrayList;

public class HospitalActivity extends AppCompatActivity {
    private String msg;
    private RecyclerView recyclerView;
    private HospitalAdapter adapter;
    private ArrayList<Hospital> educations;
    private HomeActivity homeActivity = new HomeActivity();
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        recyclerView = findViewById(R.id.recycler_view);

        msg = getIntent().getStringExtra("msg");


        if (msg == null) {



        } else if (msg.equals("dhaka")) {

            showDhakaAll();

        } else if (msg.equals("mymensingh")) {
            showMymensinghAll();

        } else if (msg.equals("barishal")) {

            showBarishalAll();

        } else if (msg.equals("rajshahi")) {
            showRajshahiAll();

        } else if (msg.equals("khulna")) {
            showKhulnaAll();

        } else if (msg.equals("chittagong")) {
            showChittagoAngAll();


        } else if (msg.equals("rangpur")) {
            showRangpurAll();

        } else if (msg.equals("sylhet")) {
            showSylhetAll();
        }


    }

    private void showSylhetAll() {
        educations = new ArrayList<>();
        educations.add(new Hospital("Ibn Sina Hospital Sylhet Ltd", R.drawable.ibnsina));
        educations.add(new Hospital("Al Haramain Hospital Private Limited", R.drawable.popular));
        educations.add(new Hospital("Emergency Department, Sylhet M A G Osmani Medical", R.drawable.square));
        educations.add(new Hospital("Sylhet MAG Osmani Medical College", R.drawable.smomc));
        educations.add(new Hospital("Oasis Hospital", R.drawable.bsmmu));
        adapter = new HospitalAdapter(this, educations);

        setRecyclerView();

        //==============Home Data send=================

    }

    private void showRangpurAll() {

        educations = new ArrayList<>();
        educations.add(new Hospital("Rangpur Medical College", R.drawable.hospital1));
        educations.add(new Hospital("Bangladesh Hospital Rangpur", R.drawable.hospital2));
        educations.add(new Hospital("Rangpur Popular Hospital", R.drawable.popular));
        educations.add(new Hospital("Rangpur General Hospital", R.drawable.hospital3));
        educations.add(new Hospital("Rangpur central Hospital", R.drawable.hospital4));
        adapter = new HospitalAdapter(this, educations);
        setRecyclerView();


        //==============Home Data send===========

    }

    private void showChittagoAngAll() {
        educations = new ArrayList<>();
        educations.add(new Hospital("Holly Health Hospital Pvt. Ltd", R.drawable.hospital1));
        educations.add(new Hospital("Royal Hospital (Pvt.) Limited", R.drawable.hospital2));
        educations.add(new Hospital("Chattogram Maa-O-Shishu Hospital", R.drawable.popular));
        educations.add(new Hospital("Red Crescent Maternity Hospital", R.drawable.hospital3));
        educations.add(new Hospital("Chittagong General Hospital", R.drawable.hospital4));
        adapter = new HospitalAdapter(this, educations);
        setRecyclerView();


    }

    private void showKhulnaAll() {
        educations = new ArrayList<>();
        educations.add(new Hospital("Khulna Sadar Hospital", R.drawable.hospital1));
        educations.add(new Hospital("Khulna Medical College", R.drawable.kmc));
        educations.add(new Hospital("Khulna Shishu Hospital", R.drawable.hospital2));
        educations.add(new Hospital("Khulna BNSB Eye Hospital", R.drawable.hospital4));
        educations.add(new Hospital("Khulna General Hospital", R.drawable.hospital3));
        adapter = new HospitalAdapter(this, educations);
        setRecyclerView();


    }

    private void showBarishalAll() {
        educations = new ArrayList<>();
        educations.add(new Hospital("Ambia Memorial Hospital", R.drawable.hospital1));
        educations.add(new Hospital("Sher-E-Bangla Medical College Hospital", R.drawable.hospital2));
        educations.add(new Hospital("Islami Bank Hospital(Barishal)", R.drawable.popular));
        educations.add(new Hospital("Grameen GC Eye Hospital, Barishal", R.drawable.hospital3));
        educations.add(new Hospital("South Bangla Appolo Hospital Main Building", R.drawable.hospital4));
        adapter = new HospitalAdapter(this, educations);
        setRecyclerView();



    }

    private void showRajshahiAll() {
        educations = new ArrayList<>();
        educations.add(new Hospital("Rajshahi Model Hospital", R.drawable.hospital3));
        educations.add(new Hospital("Rajshahi Medical College", R.drawable.rmc));
        educations.add(new Hospital("Rajshahi Royal Hospital", R.drawable.hospital1));
        educations.add(new Hospital("Islami bank hospital", R.drawable.hospital3));
        educations.add(new Hospital("Rajshahi Metropolitan Hospital Ltd.", R.drawable.hospital2));
        adapter = new HospitalAdapter(this, educations);
        setRecyclerView();


    }

    private void showMymensinghAll() {
        educations = new ArrayList<>();
        educations.add(new Hospital("Mymensingh  Government  Hospital & Medical College", R.drawable.hospital1));
        educations.add(new Hospital("Popular Diagnostic Centre Ltd. Mymensingh", R.drawable.popular));
        educations.add(new Hospital("Mymensingh Medical College", R.drawable.mmc));
        educations.add(new Hospital("Mymensingh BNSB Eye Hospital", R.drawable.hospital2));
        educations.add(new Hospital("Police Government  Hospital", R.drawable.hospital3));
        adapter = new HospitalAdapter(this, educations);
        setRecyclerView();



    }

    private void showDhakaAll() {


        educations = new ArrayList<>();

        educations.add(new Hospital("Apollo Hospitals Dhaka", R.drawable.apollo));
        educations.add(new Hospital("Square Hospitals Ltd", R.drawable.square));
        educations.add(new Hospital("LABAID Specialized Hospital", R.drawable.labid));
        educations.add(new Hospital("ইবনে সিনা স্পেশালাইজড হাসপাতাল", R.drawable.ibnsina));
        educations.add(new Hospital("Popular hospital", R.drawable.popular));
        educations.add(new Hospital("BIRDEM General Hospital", R.drawable.birdem));
        educations.add(new Hospital("Bangabandhu Sheikh Mujib Medical University Hospital", R.drawable.bsmmu));
        educations.add(new Hospital("Bangladesh Eye Hospital", R.drawable.eyehospital));


        adapter = new HospitalAdapter(this, educations);
        setRecyclerView();



    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

}