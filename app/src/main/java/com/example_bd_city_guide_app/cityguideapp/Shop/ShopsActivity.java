package com.example_bd_city_guide_app.cityguideapp.Shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example_bd_city_guide_app.cityguideapp.Home.HomeActivity;
import com.example_bd_city_guide_app.cityguideapp.Home.HomeAdapter;
import com.example_bd_city_guide_app.cityguideapp.R;

import java.util.ArrayList;

public class ShopsActivity extends AppCompatActivity {
    private String msg;
    private RecyclerView recyclerView;
    private ShopsAdapter adapter;
    private ArrayList<Shops> educations;
    private HomeActivity homeActivity = new HomeActivity();
    private HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        recyclerView = findViewById(R.id.recycler_view);

        msg = getIntent().getStringExtra("msg");


        if (msg == null) {



        }else  if (msg.equals("dhaka")) {

            showDhakaAll();

        }
        else if (msg.equals("mymensingh")){
            showMymensinghAll();

        }
        else if (msg.equals("barishal")){

            showBarishalAll();

        }else if (msg.equals("rajshahi")){
            showRajshahiAll();

        }else if (msg.equals("khulna")){
            showKhulnaAll();

        }else if (msg.equals("chittagong")){
            showChittagoAngAll();


        }else if (msg.equals("rangpur")){
            showRangpurAll();

        }else if (msg.equals("sylhet")) {
            showSylhetAll();
        }


    }

    private void showSylhetAll() {
        educations = new ArrayList<>();
        educations.add(new Shops("Sylhet City Centre", R.drawable.bashundara));
        educations.add(new Shops("Uposhohar Plaza", R.drawable.jamuna));
        educations.add(new Shops("Firoz Centre", R.drawable.newmarket));
        educations.add(new Shops("Shukria Market", R.drawable.policeplazza));
        educations.add(new Shops("Elegant Shopping Mall", R.drawable.metro));
        educations.add(new Shops("Myth, Sylhet", R.drawable.rapaplaza));
        educations.add(new Shops("Arcadia", R.drawable.easternplaza));
        educations.add(new Shops("Kazi Mansion", R.drawable.simanto));
        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();


    }

    private void showRangpurAll() {

        educations = new ArrayList<>();
        educations.add(new Shops("RAMC COMPLEX RANGPUR", R.drawable.bashundara));
        educations.add(new Shops("RAMC Shopping Complex", R.drawable.jamuna));
        educations.add(new Shops("Zilla Parishad Super Market", R.drawable.newmarket));
        educations.add(new Shops("Golden Tower Shopping Complex", R.drawable.policeplazza));
        educations.add(new Shops("Rangpur Zila Muktijoddha Complex Bhavan", R.drawable.metro));
        educations.add(new Shops("Saat Matha Jamee Mosque Complex", R.drawable.rapaplaza));
        educations.add(new Shops("Royalty Mega Mall", R.drawable.easternplaza));
        educations.add(new Shops("Lalbag Plaza", R.drawable.simanto));
        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();

        //========Home Data Send============
        homeActivity.objectArrayList = new ArrayList<>();

    }

    private void showChittagoAngAll() {
        educations = new ArrayList<>();
        educations.add(new Shops("Chittagong Shopping Complex", R.drawable.bashundara));
        educations.add(new Shops("Afmi Plaza", R.drawable.jamuna));
        educations.add(new Shops("Sanmar Ocean City", R.drawable.newmarket));
        educations.add(new Shops("Mimi Super Market", R.drawable.policeplazza));
        educations.add(new Shops("Yunusco City Centre", R.drawable.metro));
        educations.add(new Shops("Ameen Center", R.drawable.rapaplaza));
        educations.add(new Shops("Akhtaruzzaman Center", R.drawable.easternplaza));
        educations.add(new Shops("CONCORD KHULSHI TOWN CENTER", R.drawable.simanto));
        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();



    }

    private void showKhulnaAll() {
        educations = new ArrayList<>();
        educations.add(new Shops( "এ্যারাবিয়ান (Khulna Shopping Complex)", R.drawable.bashundara));
        educations.add(new Shops("Blue Star Shopping Mall Khulna", R.drawable.jamuna));
        educations.add(new Shops("Jalil Tower Shopping Complex", R.drawable.newmarket));
        educations.add(new Shops("6 Plus Shopping Center", R.drawable.policeplazza));
        educations.add(new Shops("Khulna jori house", R.drawable.metro));
        educations.add(new Shops("Khulna Shopping Center", R.drawable.rapaplaza));
        educations.add(new Shops("Khulna Trimmer House", R.drawable.easternplaza));
        educations.add(new Shops("Khulna Multi Shopping Mall", R.drawable.simanto));
        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();

        //========Home Data Send============


    }

    private void showBarishalAll() {
        educations = new ArrayList<>();
        educations.add(new Shops("Chowdhury Market", R.drawable.bashundara));
        educations.add(new Shops("Fatema Center", R.drawable.jamuna));
        educations.add(new Shops("Walton Plaza", R.drawable.newmarket));
        educations.add(new Shops("LOTTO Showroom", R.drawable.policeplazza));
        educations.add(new Shops("Janani Store", R.drawable.metro));
        educations.add(new Shops("Easy Fashion Ltd", R.drawable.rapaplaza));
        educations.add(new Shops("Jonaki Shopping Complex", R.drawable.easternplaza));
        educations.add(new Shops("Nusrat Shopping Complex", R.drawable.simanto));
        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();


    }

    private void showRajshahiAll() {
        educations = new ArrayList<>();
        educations.add(new Shops("Theme Omor Plaza", R.drawable.bashundara));
        educations.add(new Shops("Rajshahi Engineering Complex রাজশাহী ইঞ্জিনিয়ারিং কমপ্লেক্স", R.drawable.jamuna));
        educations.add(new Shops("Best Online Shopping Store in Rajshahi", R.drawable.newmarket));
        educations.add(new Shops("Rajshahi City Center", R.drawable.policeplazza));
        educations.add(new Shops("Horogram New Market", R.drawable.metro));
        educations.add(new Shops("Momtaz Shopping Center", R.drawable.rapaplaza));
        educations.add(new Shops("Realme authorized Brand Shop (Main),Rajshahi", R.drawable.easternplaza));
        educations.add(new Shops("Bata showroom", R.drawable.simanto));
        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();


    }

    private void showMymensinghAll() {
        educations = new ArrayList<>();
        educations.add(new Shops("পালিকা শপিং সেণ্টার ", R.drawable.newmarket));
        educations.add(new Shops("Noorjahan Complex", R.drawable.policeplazza));
        educations.add(new Shops("Doel Shopping Complex Ltd", R.drawable.metro));
        educations.add(new Shops( "Bari Plaza", R.drawable.rapaplaza));
        educations.add(new Shops("Shuchona Shopping Complex", R.drawable.easternplaza));
        educations.add(new Shops("Imperial Super Market", R.drawable.simanto));
        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();


    }

    private void showDhakaAll() {


        educations = new ArrayList<>();

        educations.add(new Shops("Bashundhara City Shopping Complex", R.drawable.bashundara));
        educations.add(new Shops("Jamuna Future Park", R.drawable.jamuna));
        educations.add(new Shops("New Market", R.drawable.newmarket));
        educations.add(new Shops("Police Plaza Concord", R.drawable.policeplazza));
        educations.add(new Shops("Metro Shopping Mall", R.drawable.metro));
        educations.add(new Shops("Rapa Plaza", R.drawable.rapaplaza));
        educations.add(new Shops("Eastern Plaza", R.drawable.easternplaza));
        educations.add(new Shops("Shimanto Square", R.drawable.simanto));
        educations.add(new Shops("Pink City", R.drawable.pinkcity));
        educations.add(new Shops("Mascot Plaza", R.drawable.mascot));



        adapter = new ShopsAdapter(this,educations);
        setRecyclerView();



    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
    }



}