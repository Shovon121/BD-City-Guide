package com.example_bd_city_guide_app.cityguideapp.Restaurent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example_bd_city_guide_app.cityguideapp.Home.HomeActivity;
import com.example_bd_city_guide_app.cityguideapp.Home.HomeAdapter;
import com.example_bd_city_guide_app.cityguideapp.R;

import java.util.ArrayList;

public class RestaurentActivity extends AppCompatActivity {
    private String msg;
    private RecyclerView recyclerView;
    private RestaurentAdapter adapter;
    private ArrayList<Restaurent> educations;
    private HomeActivity homeActivity = new HomeActivity();
    private HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent);

        recyclerView = findViewById(R.id.recycler_view);

        msg = getIntent().getStringExtra("msg");


        if (msg == null) {



        }else if (msg.equals("dhaka")) {

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
        educations.add(new Restaurent("Panshi Restaurant", R.drawable.baton_rouge));
        educations.add(new Restaurent("Woondaal King Kebab", R.drawable.atrium));
        educations.add(new Restaurent("The Mad Grill", R.drawable.mainland));
        educations.add(new Restaurent("Eatopia", R.drawable.spiceandrice));
        educations.add(new Restaurent("Platinum Lounge", R.drawable.barbq));
        educations.add(new Restaurent("Pach Bhai Restaurant ", R.drawable.piccaso));
        educations.add(new Restaurent("Curry Royal", R.drawable.laketrake));
        educations.add(new Restaurent("Hideout Cafe", R.drawable.pantau));
        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();



    }

    private void showRangpurAll() {

        educations = new ArrayList<>();
        educations.add(new Restaurent("Cicily Thai Chinese Restaurant", R.drawable.baton_rouge));
        educations.add(new Restaurent("Twist & Taste", R.drawable.atrium));
        educations.add(new Restaurent("Mouban Resturentt", R.drawable.mainland));
        educations.add(new Restaurent("Colino's", R.drawable.spiceandrice));
        educations.add(new Restaurent("Master Chef Bangla Restaurant", R.drawable.barbq));
        educations.add(new Restaurent("Wow Food's ", R.drawable.piccaso));
        educations.add(new Restaurent("Hotel Star International", R.drawable.laketrake));
        educations.add(new Restaurent("Caspia The Home", R.drawable.pantau));
        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();



    }

    private void showChittagoAngAll() {
        educations = new ArrayList<>();
        educations.add(new Restaurent("Ambrosia", R.drawable.baton_rouge));
        educations.add(new Restaurent("Handi Restaurant", R.drawable.atrium));
        educations.add(new Restaurent("Pizza Hut", R.drawable.mainland));
        educations.add(new Restaurent("The Arrosto", R.drawable.spiceandrice));
        educations.add(new Restaurent("Mezetto", R.drawable.barbq));
        educations.add(new Restaurent("The River View Restaurant", R.drawable.piccaso));
        educations.add(new Restaurent("The Pavilion", R.drawable.laketrake));
        educations.add(new Restaurent("Cube", R.drawable.pantau));
        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();




    }

    private void showKhulnaAll() {
        educations = new ArrayList<>();
        educations.add(new Restaurent("Citylight Cafe & Restaurant", R.drawable.baton_rouge));
        educations.add(new Restaurent("castle Salam", R.drawable.atrium));
        educations.add(new Restaurent("Deshi Kitchen", R.drawable.mainland));
        educations.add(new Restaurent("Shawarma House", R.drawable.spiceandrice));
        educations.add(new Restaurent("New Azmiri Grill & Bar-B-Q", R.drawable.barbq));
        educations.add(new Restaurent("We Hungry", R.drawable.piccaso));
        educations.add(new Restaurent("Safe'n'Save", R.drawable.laketrake));
        educations.add(new Restaurent("Aloka Restaurant", R.drawable.pantau));
        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();



    }

    private void showBarishalAll() {
        educations = new ArrayList<>();
        educations.add(new Restaurent("Zafran restaurant Barishal", R.drawable.baton_rouge));
        educations.add(new Restaurent("Tawa", R.drawable.atrium));
        educations.add(new Restaurent("Handi Karai", R.drawable.mainland));
        educations.add(new Restaurent("Singara Point", R.drawable.spiceandrice));
        educations.add(new Restaurent("Garden Inn Restaurant", R.drawable.barbq));
        educations.add(new Restaurent("The river cafe", R.drawable.piccaso));
        educations.add(new Restaurent("Western Food Restaurant", R.drawable.laketrake));
        educations.add(new Restaurent("Amigos Restaurant & Juice Bar", R.drawable.pantau));
        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();


    }

    private void showRajshahiAll() {
        educations = new ArrayList<>();
        educations.add(new Restaurent("Espresso", R.drawable.baton_rouge));
        educations.add(new Restaurent("Twist & Taste", R.drawable.atrium));
        educations.add(new Restaurent("Chili's Fast Food", R.drawable.mainland));
        educations.add(new Restaurent("Colino's", R.drawable.spiceandrice));
        educations.add(new Restaurent("Master Chef Bangla Restaurant", R.drawable.barbq));
        educations.add(new Restaurent("Aristocrat Coffee Shop and Restaurant", R.drawable.piccaso));
        educations.add(new Restaurent("Hotel Star International", R.drawable.laketrake));
        educations.add(new Restaurent("Flavours", R.drawable.pantau));
        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();


    }

    private void showMymensinghAll() {
        educations = new ArrayList<>();
        educations.add(new Restaurent("Sarinda Restaurant", R.drawable.baton_rouge));
        educations.add(new Restaurent("Avanti Restaurant", R.drawable.atrium));
        educations.add(new Restaurent("Chef Time Restaurant", R.drawable.mainland));
        educations.add(new Restaurent("নাওয়াবীয়ানা-The Legacy Remains", R.drawable.spiceandrice));
        educations.add(new Restaurent("Saffron Restaurant", R.drawable.barbq));
        educations.add(new Restaurent("Hunger's Garage", R.drawable.piccaso));
        educations.add(new Restaurent("The Food Company", R.drawable.laketrake));
        educations.add(new Restaurent("Chillox Mymensingh", R.drawable.pantau));
        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();



    }

    private void showDhakaAll() {


        educations = new ArrayList<>();

        educations.add(new Restaurent("Baton Rouge", R.drawable.baton_rouge));
        educations.add(new Restaurent("The Atrium Restauran", R.drawable.atrium));
        educations.add(new Restaurent("Mainland China", R.drawable.mainland));
        educations.add(new Restaurent("Spice And Rice", R.drawable.spiceandrice));
        educations.add(new Restaurent("Bar-B-Q Tonight", R.drawable.barbq));
        educations.add(new Restaurent("Picasso Restaurant", R.drawable.piccaso));
        educations.add(new Restaurent("Lake Terrace", R.drawable.laketrake));
        educations.add(new Restaurent("Pan Tao", R.drawable.pantau));




        adapter = new RestaurentAdapter(this,educations);
        setRecyclerView();


    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
    }


}