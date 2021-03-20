package com.example_bd_city_guide_app.cityguideapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.AddData.AddDataActivity;
import com.example_bd_city_guide_app.cityguideapp.Bank.BankActivity;
import com.example_bd_city_guide_app.cityguideapp.Categories.CategoriesActivity;
import com.example_bd_city_guide_app.cityguideapp.Division.DivisionWiseDivideActivity;
import com.example_bd_city_guide_app.cityguideapp.HelperClasses.CategoriesAdapter.CategoriesAdapter;
import com.example_bd_city_guide_app.cityguideapp.HelperClasses.CategoriesAdapter.CategoriesHelperClass;
import com.example_bd_city_guide_app.cityguideapp.HelperClasses.HomeAdapder.FeaturedAdapter;
import com.example_bd_city_guide_app.cityguideapp.HelperClasses.HomeAdapder.FeaturedHelperClass;
import com.example_bd_city_guide_app.cityguideapp.HelperClasses.MostViewAdapter.MostViewedAdpater;
import com.example_bd_city_guide_app.cityguideapp.HelperClasses.MostViewAdapter.MostViewedHelperClass;
import com.example_bd_city_guide_app.cityguideapp.Home.HomeActivity;
import com.example_bd_city_guide_app.cityguideapp.Hotel.HotelActivity;
import com.example_bd_city_guide_app.cityguideapp.Place.MyMapsActivity;
import com.example_bd_city_guide_app.cityguideapp.Profile.ProfileActivity;
import com.example_bd_city_guide_app.cityguideapp.Weather.WeatherActivity;
import com.example_bd_city_guide_app.cityguideapp.login_signin.LoginWelcomeActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserDeshBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    private RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    private DrawerLayout drawerLayout;
    private ImageView menu_icon;
    private NavigationView navigationView;
    static final float END_SCALE = 0.7f;
    private LinearLayout contentView;
    private ImageView addDesboardIV;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_desh_board);

        init();

        featureRecyclerView();
        mosViewRecyclerView();
        categoriesRecycler();
        navigationDrawer();
        addDesboardIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDataActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        // navigationView.setCheckedItem(R.id.nav_home);


        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }


            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.primary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.school_image, "Education", gradient1));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.hospital_image, "HOSPITAL", gradient2));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.restuarent_image, "Restaurant", gradient3));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.shoping_image, "Shopping", gradient4));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.trasport_image, "Transport", gradient1));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.weather_image, "Weather", gradient3));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses, getApplicationContext());
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }

    private void mosViewRecyclerView() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.weather_image, "Weather"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.ic_place, "Place"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.ic_plane, "Plane"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.train, "Train"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
    }

    private void featureRecyclerView() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.ic_plane, "Airlines", "Included all informations for Bangladesh airlines..."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.train, "Train'", "Included all informations for Bangladesh Railway and Others informations..."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.ic_place, "Maps'", "Using Google Maps for all the Tourist..."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.ic_boat, "Boat", "Top Boat Tour groups data added..."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.restuarent_image, "Restaurent", "Bangladeshi top Restaurent informations added.."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.weather_image, "Weather", "Real time Weather update are showes......"));


        adapter = new FeaturedAdapter(this, featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    private void init() {
        featuredRecycler = findViewById(R.id.userRecyclerView);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menu_icon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        addDesboardIV = findViewById(R.id.addDesboardIV);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        } else if (item.getItemId() == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Log out Successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(UserDeshBoard.this, LoginWelcomeActivity.class));
            finish();
        } else if (item.getItemId() == R.id.nav_profile) {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        } else if (item.getItemId() == R.id.nav_weather) {
            startActivity(new Intent(getApplicationContext(), WeatherActivity.class));
        } else if (item.getItemId() == R.id.nav_place) {
            startActivity(new Intent(getApplicationContext(), MyMapsActivity.class));
        } else if (item.getItemId() == R.id.nav_categories) {
            startActivity(new Intent(getApplicationContext(), CategoriesActivity.class));
        } else if (item.getItemId() == R.id.nav_restaurent) {
            intent = new Intent(UserDeshBoard.this, HomeActivity.class);
            intent.putExtra("msg", "restaurent");
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_bank) {
            startActivity(new Intent(getApplicationContext(), BankActivity.class));
        } else if (item.getItemId() == R.id.nav_collageAndUnivarsity) {
            intent = new Intent(UserDeshBoard.this, HomeActivity.class);
            intent.putExtra("msg", "varsity");
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_shops) {
            intent = new Intent(UserDeshBoard.this, HomeActivity.class);
            intent.putExtra("msg", "shop");
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_hospital) {
            intent = new Intent(UserDeshBoard.this, HomeActivity.class);
            intent.putExtra("msg", "hospital");
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_division) {
            startActivity(new Intent(getApplicationContext(), DivisionWiseDivideActivity.class));
        } else if (item.getItemId() == R.id.nav_share) {
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "share demo");
                String link = "https://play.google.com/store/apps/details?id=com.example_bd_city_guide_app.cityguideapp";
                intent.putExtra(Intent.EXTRA_TEXT, link);
                startActivity(Intent.createChooser(intent, "share by"));

            } catch (Exception e) {
                Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show();
            }

        }


        return false;
    }

    public void restaurent(View view) {
        intent = new Intent(UserDeshBoard.this, HomeActivity.class);
        intent.putExtra("msg", "restaurent");
        startActivity(intent);
    }

    public void shoping(View view) {
        intent = new Intent(UserDeshBoard.this, HomeActivity.class);
        intent.putExtra("msg", "shop");
        startActivity(intent);
    }

    public void planeTour(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.biman-airlines.com/")));
    }

    public void hotel(View view) {
        startActivity(new Intent(getApplicationContext(), HotelActivity.class));
    }

    public void division_Wise_Search(View view) {
        startActivity(new Intent(getApplicationContext(), DivisionWiseDivideActivity.class));
    }
}