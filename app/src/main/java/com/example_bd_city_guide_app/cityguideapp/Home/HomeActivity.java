package com.example_bd_city_guide_app.cityguideapp.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example_bd_city_guide_app.cityguideapp.Education.Education;
import com.example_bd_city_guide_app.cityguideapp.Hospital.Hospital;
import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.Restaurent.Restaurent;
import com.example_bd_city_guide_app.cityguideapp.Shop.Shops;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView home_recyclerView;
    public ArrayList<Object> objectArrayList = new ArrayList<>();
    HomeAdapter adapter;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_recyclerView = findViewById(R.id.home_recyclerView);

        msg = getIntent().getStringExtra("msg");

        setData();
        recyclerViewSetUp();
    }

    private void setData() {


        //========Educations=============

        objectArrayList = new ArrayList<>();
        if (msg == null) {

            sentShopData();
            educations();
            restaurent();
        } else if (msg.equals("shop")) {
            sentShopData();
        } else if (msg.equals("varsity")) {
            educations();

        }else if (msg.equals("hospital")) {
            hospital();

        } else if (msg.equals("restaurent")) {

            restaurent();

        } else if (msg.equals("top varsity")) {

            topUniversity();

        }
        adapter = new HomeAdapter(getApplicationContext(), objectArrayList, msg);
    }

    private void hospital() {

        objectArrayList.add(new Hospital("Apollo Hospitals Dhaka", R.drawable.apollo));
        objectArrayList.add(new Hospital("Square Hospitals Ltd", R.drawable.square));
        objectArrayList.add(new Hospital("LABAID Specialized Hospital", R.drawable.labid));
        objectArrayList.add(new Hospital("ইবনে সিনা স্পেশালাইজড হাসপাতাল", R.drawable.ibnsina));
        objectArrayList.add(new Hospital("Popular hospital", R.drawable.popular));
        objectArrayList.add(new Hospital("BIRDEM General Hospital", R.drawable.birdem));
        objectArrayList.add(new Hospital("Bangabandhu Sheikh Mujib Medical University Hospital", R.drawable.bsmmu));
        objectArrayList.add(new Hospital("Bangladesh Eye Hospital", R.drawable.eyehospital));
        objectArrayList.add(new Hospital("Dhaka Medical College", R.drawable.dmc));

        objectArrayList.add(new Hospital("Mymensingh  Government  Hospital & Medical College", R.drawable.hospital1));
        objectArrayList.add(new Hospital("Popular Diagnostic Centre Ltd. Mymensingh", R.drawable.popular));
        objectArrayList.add(new Hospital("Mymensingh Medical College", R.drawable.mmc));
        objectArrayList.add(new Hospital("Mymensingh BNSB Eye Hospital", R.drawable.hospital2));
        objectArrayList.add(new Hospital("Police Government  Hospital", R.drawable.hospital3));

        objectArrayList.add(new Hospital("Rajshahi Model Hospital", R.drawable.hospital3));
        objectArrayList.add(new Hospital("Rajshahi Medical College", R.drawable.rmc));
        objectArrayList.add(new Hospital("Rajshahi Royal Hospital", R.drawable.hospital1));
        objectArrayList.add(new Hospital("Islami bank hospital", R.drawable.hospital3));
        objectArrayList.add(new Hospital("Rajshahi Metropolitan Hospital Ltd.", R.drawable.hospital2));

        objectArrayList.add(new Hospital("Ambia Memorial Hospital", R.drawable.hospital1));
        objectArrayList.add(new Hospital("Sher-E-Bangla Medical College Hospital", R.drawable.hospital2));
        objectArrayList.add(new Hospital("Islami Bank Hospital", R.drawable.popular));
        objectArrayList.add(new Hospital("Grameen GC Eye Hospital, Barishal", R.drawable.hospital3));
        objectArrayList.add(new Hospital("South Bangla Appolo Hospital Main Building", R.drawable.hospital4));

        objectArrayList.add(new Hospital("Khulna Sadar Hospital", R.drawable.hospital1));
        objectArrayList.add(new Hospital("Khulna Medical College", R.drawable.kmc));
        objectArrayList.add(new Hospital("Khulna Shishu Hospital", R.drawable.hospital2));
        objectArrayList.add(new Hospital("Khulna BNSB Eye Hospital", R.drawable.hospital4));
        objectArrayList.add(new Hospital("Khulna General Hospital", R.drawable.hospital3));

        objectArrayList.add(new Hospital("Holly Health Hospital Pvt. Ltd", R.drawable.hospital1));
        objectArrayList.add(new Hospital("Royal Hospital (Pvt.) Limited", R.drawable.hospital2));
        objectArrayList.add(new Hospital("Chattogram Maa-O-Shishu Hospital", R.drawable.popular));
        objectArrayList.add(new Hospital("Red Crescent Maternity Hospital", R.drawable.hospital3));
        objectArrayList.add(new Hospital("Chittagong General Hospital", R.drawable.hospital4));

        objectArrayList.add(new Hospital("Rangpur Medical College", R.drawable.hospital1));
        objectArrayList.add(new Hospital("Bangladesh Hospital Rangpur", R.drawable.hospital2));
        objectArrayList.add(new Hospital("Popular Hospital", R.drawable.popular));
        objectArrayList.add(new Hospital("Rangpur General Hospital", R.drawable.hospital3));
        objectArrayList.add(new Hospital("Rangpur central Hospital", R.drawable.hospital4));

        objectArrayList.add(new Hospital("Ibn Sina Hospital Sylhet Ltd", R.drawable.ibnsina));
        objectArrayList.add(new Hospital("Al Haramain Hospital Private Limited", R.drawable.popular));
        objectArrayList.add(new Hospital("Emergency Department, Sylhet M A G Osmani Medical", R.drawable.square));
        objectArrayList.add(new Hospital("Sylhet MAG Osmani Medical College", R.drawable.smomc));
        objectArrayList.add(new Hospital("Oasis Hospital", R.drawable.bsmmu));


    }


    private void restaurent() {



        objectArrayList.add(new Restaurent("Baton Rouge", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("The Atrium Restauran", R.drawable.atrium));
        objectArrayList.add(new Restaurent("Mainland China", R.drawable.mainland));
        objectArrayList.add(new Restaurent("Spice And Rice", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("Bar-B-Q Tonight", R.drawable.barbq));
        objectArrayList.add(new Restaurent("Picasso Restaurant", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("Lake Terrace", R.drawable.laketrake));
        objectArrayList.add(new Restaurent("Pan Tao", R.drawable.pantau));


        objectArrayList.add(new Restaurent("Panshi Restaurant", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("Woondaal King Kebab", R.drawable.atrium));
        objectArrayList.add(new Restaurent("The Mad Grill", R.drawable.mainland));
        objectArrayList.add(new Restaurent("Eatopia", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("Platinum Lounge", R.drawable.barbq));
        objectArrayList.add(new Restaurent("Pach Bhai Restaurant", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("Curry Royal", R.drawable.laketrake));
        objectArrayList.add(new Restaurent("Hideout Cafe", R.drawable.pantau));


        objectArrayList.add(new Restaurent("Cicily Thai Chinese Restaurant", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("Twist & Taste", R.drawable.atrium));
        objectArrayList.add(new Restaurent("Mouban Resturentt", R.drawable.mainland));
        objectArrayList.add(new Restaurent("Colino's", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("Master Chef Bangla Restaurant", R.drawable.barbq));
        objectArrayList.add(new Restaurent("Wow Food's", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("Hotel Star International", R.drawable.laketrake));
        objectArrayList.add(new Restaurent("Caspia The Home", R.drawable.pantau));


        //========Home Data Send=============

        objectArrayList.add(new Restaurent("Ambrosia", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("Handi Restaurant", R.drawable.atrium));
        objectArrayList.add(new Restaurent("Pizza Hut", R.drawable.mainland));
        objectArrayList.add(new Restaurent("The Arrosto", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("Mezetto", R.drawable.barbq));
        objectArrayList.add(new Restaurent("The River View Restaurant", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("The Pavilion", R.drawable.laketrake));

        objectArrayList.add(new Restaurent("Citylight Cafe & Restaurant", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("Castle Salam", R.drawable.atrium));
        objectArrayList.add(new Restaurent("Deshi Kitchen", R.drawable.mainland));
        objectArrayList.add(new Restaurent("Shawarma House", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("New Azmiri Grill & Bar-B-Q", R.drawable.barbq));
        objectArrayList.add(new Restaurent("We Hungry", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("Safe'n'Save", R.drawable.laketrake));
        objectArrayList.add(new Restaurent("Aloka Restaurant", R.drawable.pantau));


        objectArrayList.add(new Restaurent("Zafran restaurant Barishal", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("Tawa", R.drawable.atrium));
        objectArrayList.add(new Restaurent("Handi Karai", R.drawable.mainland));
        objectArrayList.add(new Restaurent("Singara Point", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("Garden Inn Restaurant", R.drawable.barbq));
        objectArrayList.add(new Restaurent("The river cafe", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("Western Food Restaurant", R.drawable.laketrake));
        objectArrayList.add(new Restaurent("Amigos Restaurant & Juice Bar", R.drawable.pantau));


        objectArrayList.add(new Restaurent("Espresso", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("Twist & Taste", R.drawable.atrium));
        objectArrayList.add(new Restaurent("Chili's Fast Food", R.drawable.mainland));
        objectArrayList.add(new Restaurent("Colino's", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("Master Chef Bangla Restaurant", R.drawable.barbq));
        objectArrayList.add(new Restaurent("Aristocrat Coffee Shop and Restaurant", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("Hotel Star International", R.drawable.laketrake));
        objectArrayList.add(new Restaurent("Flavours", R.drawable.pantau));

        objectArrayList.add(new Restaurent("Sarinda Restaurant", R.drawable.baton_rouge));
        objectArrayList.add(new Restaurent("Avanti Restaurant", R.drawable.atrium));
        objectArrayList.add(new Restaurent("Chef Time Restaurant", R.drawable.mainland));
        objectArrayList.add(new Restaurent("নাওয়াবীয়ানা-The Legacy Remains", R.drawable.spiceandrice));
        objectArrayList.add(new Restaurent("Saffron Restaurant", R.drawable.barbq));
        objectArrayList.add(new Restaurent("Hunger's Garage", R.drawable.piccaso));
        objectArrayList.add(new Restaurent("The Food Company", R.drawable.laketrake));
        objectArrayList.add(new Restaurent("Chillox Mymensingh", R.drawable.pantau));



    }

    private void educations() {


        objectArrayList.add(new Education("", R.drawable.buet));
        objectArrayList.add(new Education("", R.drawable.dhakauniversity));
        objectArrayList.add(new Education("", R.drawable.jahangirnagar));
        objectArrayList.add(new Education("", R.drawable.northsout));
        objectArrayList.add(new Education("", R.drawable.brac));
        objectArrayList.add(new Education("", R.drawable.sust));
        objectArrayList.add(new Education("", R.drawable.cuet));
        objectArrayList.add(new Education("", R.drawable.bau));
        objectArrayList.add(new Education("", R.drawable.ru));
        objectArrayList.add(new Education("", R.drawable.iu));
        objectArrayList.add(new Education("", R.drawable.kuet));

        objectArrayList.add(new Education("", R.drawable.swmc));
        objectArrayList.add(new Education("", R.drawable.sau));
        objectArrayList.add(new Education("", R.drawable.smomc));
        objectArrayList.add(new Education("", R.drawable.mc));
        objectArrayList.add(new Education("", R.drawable.rmc));
        objectArrayList.add(new Education("", R.drawable.cc));
        objectArrayList.add(new Education("", R.drawable.rgc));
        objectArrayList.add(new Education("", R.drawable.bru));
        objectArrayList.add(new Education("", R.drawable.gcc));
        objectArrayList.add(new Education("", R.drawable.cu));
        objectArrayList.add(new Education("", R.drawable.cmc));

        objectArrayList.add(new Education("", R.drawable.awc));
        objectArrayList.add(new Education("", R.drawable.ku));
        objectArrayList.add(new Education("", R.drawable.kmc));

        objectArrayList.add(new Education("", R.drawable.kpi));
        objectArrayList.add(new Education("", R.drawable.kwc));
        objectArrayList.add(new Education("", R.drawable.bm));
        objectArrayList.add(new Education("", R.drawable.gc));
        objectArrayList.add(new Education("", R.drawable.smc));
        objectArrayList.add(new Education("", R.drawable.bpi));
        objectArrayList.add(new Education("", R.drawable.bwc));

        objectArrayList.add(new Education("", R.drawable.rmc));
        objectArrayList.add(new Education("", R.drawable.ruet));
        objectArrayList.add(new Education("", R.drawable.rwc));
        objectArrayList.add(new Education("", R.drawable.rpi));

        objectArrayList.add(new Education("", R.drawable.amc));
        objectArrayList.add(new Education("", R.drawable.mmc));
        objectArrayList.add(new Education("", R.drawable.mwc));
        objectArrayList.add(new Education("", R.drawable.knu));

    }

    private void sentShopData() {

        objectArrayList.add(new Shops("Bashundhara City Shopping Complex", R.drawable.bashundara));
        objectArrayList.add(new Shops("Jamuna Future Park", R.drawable.jamuna));
        objectArrayList.add(new Shops("New Market", R.drawable.newmarket));
        objectArrayList.add(new Shops("Police Plaza Concord", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Metro Shopping Mall", R.drawable.metro));
        objectArrayList.add(new Shops("Rapa Plaza", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Eastern Plaza", R.drawable.easternplaza));
        objectArrayList.add(new Shops("Shimanto Square", R.drawable.simanto));
        objectArrayList.add(new Shops("Pink City", R.drawable.pinkcity));
        objectArrayList.add(new Shops("Mascot Plaza", R.drawable.mascot));


        objectArrayList.add(new Shops("Sylhet City Centre", R.drawable.bashundara));
        objectArrayList.add(new Shops("Uposhohar Plaza", R.drawable.jamuna));
        objectArrayList.add(new Shops("Firoz Centre", R.drawable.newmarket));
        objectArrayList.add(new Shops("Shukria Market", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Elegant Shopping Mall", R.drawable.metro));
        objectArrayList.add(new Shops("Myth, Sylhet", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Arcadia", R.drawable.easternplaza));
        objectArrayList.add(new Shops("Kazi Mansion", R.drawable.simanto));

        objectArrayList.add(new Shops("RAMC COMPLEX RANGPUR", R.drawable.bashundara));
        objectArrayList.add(new Shops("RAMC Shopping Complex", R.drawable.jamuna));
        objectArrayList.add(new Shops("Zilla Parishad Super Market", R.drawable.newmarket));
        objectArrayList.add(new Shops("Golden Tower Shopping Complex", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Rangpur Zila Muktijoddha Complex Bhavan", R.drawable.metro));
        objectArrayList.add(new Shops("Saat Matha Jamee Mosque Complex", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Royalty Mega Mall", R.drawable.easternplaza));
        objectArrayList.add(new Shops("Lalbag Plaza", R.drawable.simanto));

        //========Home Data Send============

        objectArrayList.add(new Shops("Chittagong Shopping Complex", R.drawable.bashundara));
        objectArrayList.add(new Shops("Afmi Plaza", R.drawable.jamuna));
        objectArrayList.add(new Shops("Sanmar Ocean City", R.drawable.newmarket));
        objectArrayList.add(new Shops("Mimi Super Market", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Yunusco City Centre", R.drawable.metro));
        objectArrayList.add(new Shops("Ameen Center", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Akhtaruzzaman Center", R.drawable.easternplaza));
        objectArrayList.add(new Shops("CONCORD KHULSHI TOWN CENTER", R.drawable.simanto));


        objectArrayList.add(new Shops("এ্যারাবিয়ান (Khulna Shopping Complex)", R.drawable.bashundara));
        objectArrayList.add(new Shops("Blue Star Shopping Mall Khulna", R.drawable.jamuna));
        objectArrayList.add(new Shops("Jalil Tower Shopping Complex", R.drawable.newmarket));
        objectArrayList.add(new Shops("6 Plus Shopping Center", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Khulna jori house", R.drawable.metro));
        objectArrayList.add(new Shops("Khulna Shopping Center", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Khulna Trimmer House", R.drawable.easternplaza));
        objectArrayList.add(new Shops("Khulna Multi Shopping Mall", R.drawable.simanto));


        objectArrayList.add(new Shops("Chowdhury Market", R.drawable.bashundara));
        objectArrayList.add(new Shops("Fatema Center", R.drawable.jamuna));
        objectArrayList.add(new Shops("Walton Plaza", R.drawable.newmarket));
        objectArrayList.add(new Shops("LOTTO Showroom", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Janani Store", R.drawable.metro));
        objectArrayList.add(new Shops("Easy Fashion Ltd", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Jonaki Shopping Complex", R.drawable.easternplaza));
        objectArrayList.add(new Shops("Nusrat Shopping Complex", R.drawable.simanto));

        objectArrayList.add(new Shops("Theme Omor Plaza", R.drawable.bashundara));
        objectArrayList.add(new Shops("Rajshahi Engineering Complex রাজশাহী ইঞ্জিনিয়ারিং কমপ্লেক্স", R.drawable.jamuna));
        objectArrayList.add(new Shops("Best Online Shopping Store in Rajshahi", R.drawable.newmarket));
        objectArrayList.add(new Shops("Rajshahi City Center", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Horogram New Market", R.drawable.metro));
        objectArrayList.add(new Shops("Momtaz Shopping Center", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Realme authorized Brand Shop (Main),Rajshahi", R.drawable.easternplaza));
        objectArrayList.add(new Shops("Bata showroom", R.drawable.simanto));

        objectArrayList.add(new Shops("পালিকা শপিং সেণ্টার", R.drawable.newmarket));
        objectArrayList.add(new Shops("Noorjahan Complex", R.drawable.policeplazza));
        objectArrayList.add(new Shops("Doel Shopping Complex Ltd", R.drawable.metro));
        objectArrayList.add(new Shops("Bari Plaza", R.drawable.rapaplaza));
        objectArrayList.add(new Shops("Shuchona Shopping Complex", R.drawable.easternplaza));
        objectArrayList.add(new Shops("Imperial Super Market", R.drawable.simanto));


    }

    private void topUniversity() {

        objectArrayList.add(new Education("", R.drawable.buet));
        objectArrayList.add(new Education("", R.drawable.dhakauniversity));
        objectArrayList.add(new Education("", R.drawable.jahangirnagar));
        objectArrayList.add(new Education("", R.drawable.knu));
        objectArrayList.add(new Education("", R.drawable.mmc));
        objectArrayList.add(new Education("", R.drawable.sust));
        objectArrayList.add(new Education("", R.drawable.kuet));
        objectArrayList.add(new Education("", R.drawable.cuet));
        objectArrayList.add(new Education("", R.drawable.bau));
        objectArrayList.add(new Education("", R.drawable.smc));
    }

    private void recyclerViewSetUp() {
        home_recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        home_recyclerView.setAdapter(adapter);
    }
}