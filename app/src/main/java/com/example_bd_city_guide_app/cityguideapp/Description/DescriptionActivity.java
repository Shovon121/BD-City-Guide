package com.example_bd_city_guide_app.cityguideapp.Description;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.Place.MyMapsActivity;
import com.example_bd_city_guide_app.cityguideapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DescriptionActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ImageView placeImage;
    private TextView placeNameDN, placeDN, websiteDN, phoneDN, descriptionDN;

    private String websiteLink;
    private String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        init();
        setData();



    }


    private void init() {

        progressBar = findViewById(R.id.descriptionProgressbar);
        placeImage = findViewById(R.id.placeImage);
        placeNameDN = findViewById(R.id.placeName);
        placeDN = findViewById(R.id.place);
        websiteDN = findViewById(R.id.website);
        phoneDN = findViewById(R.id.phoneNo);
        descriptionDN = findViewById(R.id.description);
    }

    private void setData() {

        String data = getIntent().getStringExtra("msg");
        if (data.equals("baton")) {
            placeImage.setImageResource(R.drawable.baton_rouge);
            queryData("R1");
        } else if (data.equals("atrium")) {
            placeImage.setImageResource(R.drawable.atrium);
            queryData("R2");
        } else if (data.equals("mainland")) {
            placeImage.setImageResource(R.drawable.mainland);
            queryData("R3");
        } else if (data.equals("spice")) {
            placeImage.setImageResource(R.drawable.spiceandrice);
            queryData("R4");
        } else if (data.equals("bar_B_Q")) {
            placeImage.setImageResource(R.drawable.barbq);
            queryData("R5");
        } else if (data.equals("picasso restaurent")) {
            placeImage.setImageResource(R.drawable.piccaso);
            queryData("R6");
        } else if (data.equals("lake restaurent")) {
            placeImage.setImageResource(R.drawable.laketrake);
            queryData("R7");
        } else if (data.equals("cafe")) {
            placeImage.setImageResource(R.drawable.cafedroom);
            queryData("R8");
        } else if (data.equals("pantau restaurent")) {
            placeImage.setImageResource(R.drawable.pantau);
            queryData("R9");
        } else if (data.equals("star")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R10");
        } else if (data.equals("pr")) {
            placeImage.setImageResource(R.drawable.baton_rouge);
            queryData("R11");
        } else if (data.equals("wkk")) {
            placeImage.setImageResource(R.drawable.atrium);
            queryData("R12");
        } else if (data.equals("tmg")) {
            placeImage.setImageResource(R.drawable.mainland);
            queryData("R13");
        } else if (data.equals("eatopia")) {
            placeImage.setImageResource(R.drawable.spiceandrice);
            queryData("R14");
        } else if (data.equals("pl")) {
            placeImage.setImageResource(R.drawable.barbq);
            queryData("R15");
        } else if (data.equals("pbr")) {
            placeImage.setImageResource(R.drawable.piccaso);
            queryData("R16");
        } else if (data.equals("cr")) {
            placeImage.setImageResource(R.drawable.laketrake);
            queryData("R17");
        } else if (data.equals("hc")) {
            placeImage.setImageResource(R.drawable.cafedroom);
            queryData("R18");
        } else if (data.equals("ctcr")) {
            placeImage.setImageResource(R.drawable.pantau);
            queryData("R19");
        } else if (data.equals("tt")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R20");
        } else if (data.equals("mr")) {
            placeImage.setImageResource(R.drawable.baton_rouge);
            queryData("R21");
        } else if (data.equals("colino")) {
            placeImage.setImageResource(R.drawable.atrium);
            queryData("R22");
        } else if (data.equals("mcbr")) {
            placeImage.setImageResource(R.drawable.mainland);
            queryData("R22");
        } else if (data.equals("wf")) {
            placeImage.setImageResource(R.drawable.spiceandrice);
            queryData("R23");
        } else if (data.equals("hti")) {
            placeImage.setImageResource(R.drawable.barbq);
            queryData("R25");
        } else if (data.equals("cth")) {
            placeImage.setImageResource(R.drawable.piccaso);
            queryData("R26");
        } else if (data.equals("ambrosia")) {
            placeImage.setImageResource(R.drawable.laketrake);
            queryData("R27");
        } else if (data.equals("hr")) {
            placeImage.setImageResource(R.drawable.cafedroom);
            queryData("R28");
        } else if (data.equals("pizza hut")) {
            placeImage.setImageResource(R.drawable.pantau);
            queryData("R29");
        } else if (data.equals("arrosto")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R30");
        } else if (data.equals("mezetto")) {
            placeImage.setImageResource(R.drawable.baton_rouge);
            queryData("R31");
        } else if (data.equals("river view restaurant")) {
            placeImage.setImageResource(R.drawable.atrium);
            queryData("R32");
        } else if (data.equals("pavilion")) {
            placeImage.setImageResource(R.drawable.mainland);
            queryData("R33");
        } else if (data.equals("citylight cafe Rrstaurant")) {
            placeImage.setImageResource(R.drawable.spiceandrice);
            queryData("R34");
        } else if (data.equals("castle calam")) {
            placeImage.setImageResource(R.drawable.barbq);
            queryData("R35");
        } else if (data.equals("keshi kitchen")) {
            placeImage.setImageResource(R.drawable.piccaso);
            queryData("R36");
        } else if (data.equals("shawarma house")) {
            placeImage.setImageResource(R.drawable.laketrake);
            queryData("R37");
        } else if (data.equals("new azmiri")) {
            placeImage.setImageResource(R.drawable.cafedroom);
            queryData("R38");
        } else if (data.equals("we hungry")) {
            placeImage.setImageResource(R.drawable.pantau);
            queryData("R39");
        } else if (data.equals("safe")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R40");
        } else if (data.equals("aloka restaurant")) {
            placeImage.setImageResource(R.drawable.baton_rouge);
            queryData("R41");
        } else if (data.equals("zafran")) {
            placeImage.setImageResource(R.drawable.atrium);
            queryData("R42");
        } else if (data.equals("tawa")) {
            placeImage.setImageResource(R.drawable.mainland);
            queryData("R43");
        } else if (data.equals("kandi karai")) {
            placeImage.setImageResource(R.drawable.spiceandrice);
            queryData("R44");
        } else if (data.equals("Singara Point")) {
            placeImage.setImageResource(R.drawable.barbq);
            queryData("R45");
        } else if (data.equals("Garden Inn Restauran")) {
            placeImage.setImageResource(R.drawable.piccaso);
            queryData("R46");
        } else if (data.equals("The river cafe")) {
            placeImage.setImageResource(R.drawable.laketrake);
            queryData("R47");
        } else if (data.equals("Western Food Restaurant")) {
            placeImage.setImageResource(R.drawable.cafedroom);
            queryData("R48");
        } else if (data.equals("Amigos Restaurant & Juice Bar")) {
            placeImage.setImageResource(R.drawable.pantau);
            queryData("R49");
        } else if (data.equals("Espresso")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R50");
        } else if (data.equals("Twist & Taste")) {
            placeImage.setImageResource(R.drawable.baton_rouge);
            queryData("R51");
        } else if (data.equals("Chili's Fast Food")) {
            placeImage.setImageResource(R.drawable.atrium);
            queryData("R52");
        } else if (data.equals("Colino's")) {
            placeImage.setImageResource(R.drawable.mainland);
            queryData("R53");
        } else if (data.equals("Master Chef Bangla Restaurant")) {
            placeImage.setImageResource(R.drawable.spiceandrice);
            queryData("R54");
        } else if (data.equals("Aristocrat Coffee Shop and Restaurant")) {
            placeImage.setImageResource(R.drawable.barbq);
            queryData("R55");
        } else if (data.equals("Hotel Star International")) {
            placeImage.setImageResource(R.drawable.piccaso);
            queryData("R56");
        } else if (data.equals("Flavours")) {
            placeImage.setImageResource(R.drawable.laketrake);
            queryData("R57");
        } else if (data.equals("Chillox Mymensingh")) {
            placeImage.setImageResource(R.drawable.cafedroom);
            queryData("R58");
        } else if (data.equals("Sarinda Restaurant")) {
            placeImage.setImageResource(R.drawable.pantau);
            queryData("R59");
        } else if (data.equals("Avanti Restaurant")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R60");
        } else if (data.equals("Chef Time Restaurant")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R61");
        } else if (data.equals("নাওয়াবীয়ানা-The Legacy Remains")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R62");
        } else if (data.equals("Saffron Restaurant")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R63");
        } else if (data.equals("Hunger's Garage")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R64");
        } else if (data.equals("The Food Company")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R65");
        }
        else if (data.equals("Garden Inn Restaurant")) {
            placeImage.setImageResource(R.drawable.star);
            queryData("R66");
        }
        //==========Starting Hospital Data Adding=============

        else if (data.equals("sh")) {
            placeImage.setImageResource(R.drawable.square);
            queryData("H1");
        } else if (data.equals("ah")) {
            placeImage.setImageResource(R.drawable.apollo);
            queryData("H2");
        } else if (data.equals("lh")) {
            placeImage.setImageResource(R.drawable.labid);
            queryData("H3");
        } else if (data.equals("ish")) {
            placeImage.setImageResource(R.drawable.ibnsina);
            queryData("H4");
        } else if (data.equals("ph")) {
            placeImage.setImageResource(R.drawable.popular);
            queryData("H5");
        } else if (data.equals("bh")) {
            placeImage.setImageResource(R.drawable.birdem);
            queryData("H7");
        } else if (data.equals("bsmmuh")) {
            placeImage.setImageResource(R.drawable.bsmmu);
            queryData("H6");
        } else if (data.equals("beh")) {
            placeImage.setImageResource(R.drawable.eyehospital);
            queryData("H8");
        } else if (data.equals("dmc")) {
            placeImage.setImageResource(R.drawable.dmc);
            queryData("H9");
        } else if (data.equals("mmc")) {
            placeImage.setImageResource(R.drawable.mmc);
            queryData("H10");
        } else if (data.equals("cmh")) {
            placeImage.setImageResource(R.drawable.hospital1);
            queryData("H11");
        } else if (data.equals("mghmc")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H12");
        } else if (data.equals("pdcm")) {
            placeImage.setImageResource(R.drawable.hospital3);
            queryData("H13");
        } else if (data.equals("mbeh")) {
            placeImage.setImageResource(R.drawable.hospital4);
            queryData("H14");
        } else if (data.equals("mpgh")) {
            placeImage.setImageResource(R.drawable.mmc);
            queryData("H15");
        } else if (data.equals("rdh")) {
            placeImage.setImageResource(R.drawable.hospital1);
            queryData("H16");
        } else if (data.equals("rmc")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H17");
        } else if (data.equals("rrh")) {
            placeImage.setImageResource(R.drawable.hospital3);
            queryData("H18");
        } else if (data.equals("ibh")) {
            placeImage.setImageResource(R.drawable.hospital4);
            queryData("H19");
        } else if (data.equals("rmh")) {
            placeImage.setImageResource(R.drawable.hospital_image);
            queryData("H20");
        } else if (data.equals("amh")) {
            placeImage.setImageResource(R.drawable.dmc);
            queryData("H21");
        } else if (data.equals("smch")) {
            placeImage.setImageResource(R.drawable.hospital1);
            queryData("H22");
        } else if (data.equals("ggeh")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H23");
        } else if (data.equals("sbah")) {
            placeImage.setImageResource(R.drawable.hospital4);
            queryData("H24");
        } else if (data.equals("ksh")) {
            placeImage.setImageResource(R.drawable.hospital_image);
            queryData("H25");
        } else if (data.equals("kmc")) {
            placeImage.setImageResource(R.drawable.ibnsina);
            queryData("H26");
        } else if (data.equals("kbeh")) {
            placeImage.setImageResource(R.drawable.hospital1);
            queryData("H27");
        } else if (data.equals("kgh")) {
            placeImage.setImageResource(R.drawable.hospital3);
            queryData("H28");
        } else if (data.equals("hhh")) {
            placeImage.setImageResource(R.drawable.hospital4);
            queryData("H29");
        } else if (data.equals("rh")) {
            placeImage.setImageResource(R.drawable.kmc);
            queryData("H30");
        } else if (data.equals("cmh")) {
            placeImage.setImageResource(R.drawable.cmc);
            queryData("H11");
        } else if (data.equals("rcmh")) {
            placeImage.setImageResource(R.drawable.dmc);
            queryData("H32");
        } else if (data.equals("rrmc")) {
            placeImage.setImageResource(R.drawable.hospital1);
            queryData("H33");
        } else if (data.equals("bhr")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H34");
        } else if (data.equals("rgh")) {
            placeImage.setImageResource(R.drawable.hospital3);
            queryData("H35");
        } else if (data.equals("rch")) {
            placeImage.setImageResource(R.drawable.hospital4);
            queryData("H36");
        } else if (data.equals("ishs")) {
            placeImage.setImageResource(R.drawable.hospital_image);
            queryData("H37");
        } else if (data.equals("ahh")) {
            placeImage.setImageResource(R.drawable.mmc);
            queryData("H38");
        } else if (data.equals("eds")) {
            placeImage.setImageResource(R.drawable.dmc);
            queryData("H39");
        } else if (data.equals("smo")) {
            placeImage.setImageResource(R.drawable.hospital1);
            queryData("H39");
        } else if (data.equals("oh")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H41");
        } else if (data.equals("ibhb")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H42");
        } else if (data.equals("ggehb")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H43");
        } else if (data.equals("ksh")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H44");
        } else if (data.equals("kgh")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H28");
        } else if (data.equals("cgh")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H46");
        } else if (data.equals("rgh")) {
            placeImage.setImageResource(R.drawable.hospital2);
            queryData("H47");
        }


        //=========Bank data adding====================

        else if (data.equals("sunalibank")) {
            placeImage.setImageResource(R.drawable.sunalibank);
            queryData("B1");
        } else if (data.equals("rupalibank")) {
            placeImage.setImageResource(R.drawable.rupalibank);
            queryData("B2");
        } else if (data.equals("agranibank")) {
            placeImage.setImageResource(R.drawable.agranibank);
            queryData("B3");
        } else if (data.equals("islamiyabank")) {
            placeImage.setImageResource(R.drawable.islamiyabank);
            queryData("B4");
        } else if (data.equals("krisybank")) {
            placeImage.setImageResource(R.drawable.krisybank);
            queryData("B5");
        } else if (data.equals("brackbank")) {
            placeImage.setImageResource(R.drawable.brackbank);
            queryData("B6");
        } else if (data.equals("nationalbank")) {
            placeImage.setImageResource(R.drawable.nationalbank);
            queryData("B7");
        } else if (data.equals("nccbank")) {
            placeImage.setImageResource(R.drawable.nccbank);
            queryData("B8");
        } else if (data.equals("ucbbank")) {
            placeImage.setImageResource(R.drawable.ucbbank);
            queryData("B9");
        } else if (data.equals("pubalibank")) {
            placeImage.setImageResource(R.drawable.pubalibank);
            queryData("B10");
        }

        //=============Shoping Data Adding==============

        else if (data.equals("bashundara")) {
            placeImage.setImageResource(R.drawable.bashundara);
            queryData("S1");
        } else if (data.equals("jamuna")) {
            placeImage.setImageResource(R.drawable.jamuna);
            queryData("S2");
        } else if (data.equals("newmarket")) {
            placeImage.setImageResource(R.drawable.newmarket);
            queryData("S3");
        } else if (data.equals("policeplazza")) {
            placeImage.setImageResource(R.drawable.policeplazza);
            queryData("S4");
        } else if (data.equals("metro")) {
            placeImage.setImageResource(R.drawable.metro);
            queryData("S5");
        } else if (data.equals("rapaplaza")) {
            placeImage.setImageResource(R.drawable.rapaplaza);
            queryData("S6");
        } else if (data.equals("easternplaza")) {
            placeImage.setImageResource(R.drawable.easternplaza);
            queryData("S7");
        } else if (data.equals("simanto")) {
            placeImage.setImageResource(R.drawable.simanto);
            queryData("S8");
        } else if (data.equals("pinkcity")) {
            placeImage.setImageResource(R.drawable.pinkcity);
            queryData("S9");
        } else if (data.equals("mascot")) {
            placeImage.setImageResource(R.drawable.mascot);
            queryData("S10");
        } else if (data.equals("Sylhet City Centre")) {
            placeImage.setImageResource(R.drawable.bashundara);
            queryData("S11");
        } else if (data.equals("Uposhohar Plaza")) {
            placeImage.setImageResource(R.drawable.jamuna);
            queryData("S12");
        } else if (data.equals("Firoz Centre")) {
            placeImage.setImageResource(R.drawable.newmarket);
            queryData("S13");
        } else if (data.equals("Shukria Market")) {
            placeImage.setImageResource(R.drawable.policeplazza);
            queryData("S14");
        } else if (data.equals("Elegant Shopping Mall")) {
            placeImage.setImageResource(R.drawable.metro);
            queryData("S15");
        } else if (data.equals("Myth, Sylhet")) {
            placeImage.setImageResource(R.drawable.rapaplaza);
            queryData("S16");
        } else if (data.equals("Arcadia")) {
            placeImage.setImageResource(R.drawable.easternplaza);
            queryData("S17");
        } else if (data.equals("Kazi Mansion")) {
            placeImage.setImageResource(R.drawable.simanto);
            queryData("S18");
        } else if (data.equals("RAMC COMPLEX RANGPUR")) {
            placeImage.setImageResource(R.drawable.pinkcity);
            queryData("S19");
        } else if (data.equals("RAMC Shopping Complex")) {
            placeImage.setImageResource(R.drawable.mascot);
            queryData("S19");
        } else if (data.equals("Zilla Parishad Super Market")) {
            placeImage.setImageResource(R.drawable.bashundara);
            queryData("S20");
        } else if (data.equals("Golden Tower Shopping Complex")) {
            placeImage.setImageResource(R.drawable.jamuna);
            queryData("S22");
        } else if (data.equals("Rangpur Zila Muktijoddha Complex Bhavan")) {
            placeImage.setImageResource(R.drawable.newmarket);
            queryData("S23");
        } else if (data.equals("Saat Matha Jamee Mosque Complex")) {
            placeImage.setImageResource(R.drawable.policeplazza);
            queryData("S24");
        } else if (data.equals("Royalty Mega Mall")) {
            placeImage.setImageResource(R.drawable.metro);
            queryData("S25");
        } else if (data.equals("Lalbag Plaza")) {
            placeImage.setImageResource(R.drawable.rapaplaza);
            queryData("S26");
        } else if (data.equals("Chittagong Shopping Complex")) {
            placeImage.setImageResource(R.drawable.easternplaza);
            queryData("S27");
        } else if (data.equals("Afmi Plaza")) {
            placeImage.setImageResource(R.drawable.simanto);
            queryData("S28");
        } else if (data.equals("Sanmar Ocean City")) {
            placeImage.setImageResource(R.drawable.pinkcity);
            queryData("S29");
        } else if (data.equals("Mimi Super Market")) {
            placeImage.setImageResource(R.drawable.mascot);
            queryData("S30");
        } else if (data.equals("Yunusco City Centre")) {
            placeImage.setImageResource(R.drawable.bashundara);
            queryData("S31");
        } else if (data.equals("Ameen Center")) {
            placeImage.setImageResource(R.drawable.jamuna);
            queryData("S32");
        } else if (data.equals("Akhtaruzzaman Center")) {
            placeImage.setImageResource(R.drawable.newmarket);
            queryData("S33");
        } else if (data.equals("CONCORD KHULSHI TOWN CENTER")) {
            placeImage.setImageResource(R.drawable.policeplazza);
            queryData("S34");
        } else if (data.equals("এ্যারাবিয়ান (Khulna Shopping Complex)")) {
            placeImage.setImageResource(R.drawable.metro);
            queryData("S35");
        } else if (data.equals("Blue Star Shopping Mall Khulna")) {
            placeImage.setImageResource(R.drawable.rapaplaza);
            queryData("S36");
        } else if (data.equals("Jalil Tower Shopping Complex")) {
            placeImage.setImageResource(R.drawable.easternplaza);
            queryData("S37");
        } else if (data.equals("6 Plus Shopping Center")) {
            placeImage.setImageResource(R.drawable.simanto);
            queryData("S38");
        } else if (data.equals("Khulna jori house")) {
            placeImage.setImageResource(R.drawable.pinkcity);
            queryData("S39");
        } else if (data.equals("Khulna Shopping Center")) {
            placeImage.setImageResource(R.drawable.mascot);
            queryData("S40");
        } else if (data.equals("Khulna Trimmer House")) {
            placeImage.setImageResource(R.drawable.bashundara);
            queryData("S41");
        } else if (data.equals("Khulna Multi Shopping Mall")) {
            placeImage.setImageResource(R.drawable.jamuna);
            queryData("S42");
        } else if (data.equals("Chowdhury Market")) {
            placeImage.setImageResource(R.drawable.newmarket);
            queryData("S43");
        } else if (data.equals("Fatema Center")) {
            placeImage.setImageResource(R.drawable.policeplazza);
            queryData("S44");
        } else if (data.equals("Walton Plaza")) {
            placeImage.setImageResource(R.drawable.metro);
            queryData("S45");
        } else if (data.equals("LOTTO Showroom")) {
            placeImage.setImageResource(R.drawable.rapaplaza);
            queryData("S46");
        } else if (data.equals("Janani Store")) {
            placeImage.setImageResource(R.drawable.easternplaza);
            queryData("S47");
        } else if (data.equals("Easy Fashion Ltd")) {
            placeImage.setImageResource(R.drawable.simanto);
            queryData("S48");
        } else if (data.equals("Jonaki Shopping Complex")) {
            placeImage.setImageResource(R.drawable.pinkcity);
            queryData("S49");
        } else if (data.equals("Nusrat Shopping Complex")) {
            placeImage.setImageResource(R.drawable.mascot);
            queryData("S50");
        } else if (data.equals("Theme Omor Plaza")) {
            placeImage.setImageResource(R.drawable.bashundara);
            queryData("S51");
        } else if (data.equals("Rajshahi Engineering Complex রাজশাহী ইঞ্জিনিয়ারিং কমপ্লেক্স")) {
            placeImage.setImageResource(R.drawable.jamuna);
            queryData("S52");
        } else if (data.equals("Best Online Shopping Store in Rajshahi")) {
            placeImage.setImageResource(R.drawable.newmarket);
            queryData("S53");
        } else if (data.equals("Rajshahi City Center")) {
            placeImage.setImageResource(R.drawable.policeplazza);
            queryData("S54");
        } else if (data.equals("Horogram New Market")) {
            placeImage.setImageResource(R.drawable.metro);
            queryData("S55");
        } else if (data.equals("Momtaz Shopping Center")) {
            placeImage.setImageResource(R.drawable.rapaplaza);
            queryData("S56");
        } else if (data.equals("Realme authorized Brand Shop (Main),Rajshahi")) {
            placeImage.setImageResource(R.drawable.easternplaza);
            queryData("S57");
        } else if (data.equals("Bata showroom")) {
            placeImage.setImageResource(R.drawable.simanto);
            queryData("S58");
        } else if (data.equals("পালিকা শপিং সেণ্টার")) {
            placeImage.setImageResource(R.drawable.pinkcity);
            queryData("S59");
        } else if (data.equals("Noorjahan Complex")) {
            placeImage.setImageResource(R.drawable.mascot);
            queryData("S60");
        } else if (data.equals("Doel Shopping Complex Ltd")) {
            placeImage.setImageResource(R.drawable.bashundara);
            queryData("S61");
        } else if (data.equals("Bari Plaza")) {
            placeImage.setImageResource(R.drawable.jamuna);
            queryData("S62");
        } else if (data.equals("Shuchona Shopping Complex")) {
            placeImage.setImageResource(R.drawable.newmarket);
            queryData("S63");
        } else if (data.equals("Imperial Super Market")) {
            placeImage.setImageResource(R.drawable.policeplazza);
            queryData("S64");
        }


        //==============Educations Data Adding================
        else if (data.equals("buet")) {
            placeImage.setImageResource(R.drawable.buet);
            queryData("E1");
        } else if (data.equals("du")) {
            placeImage.setImageResource(R.drawable.dhakauniversity);
            queryData("E2");
        } else if (data.equals("bau")) {
            placeImage.setImageResource(R.drawable.bau);
            queryData("E3");
        } else if (data.equals("ju")) {
            placeImage.setImageResource(R.drawable.jahangirnagar);
            queryData("E4");
        } else if (data.equals("nsu")) {
            placeImage.setImageResource(R.drawable.northsout);
            queryData("E5");
        } else if (data.equals("brac")) {
            placeImage.setImageResource(R.drawable.brac);
            queryData("E6");
        } else if (data.equals("ru")) {
            placeImage.setImageResource(R.drawable.ru);
            queryData("E7");
        } else if (data.equals("cuet")) {
            placeImage.setImageResource(R.drawable.cuet);
            queryData("E8");
        } else if (data.equals("iu")) {
            placeImage.setImageResource(R.drawable.iu);
            queryData("E9");
        } else if (data.equals("kuet")) {
            placeImage.setImageResource(R.drawable.kuet);
            queryData("E10");
        } else if (data.equals("sust")) {
            placeImage.setImageResource(R.drawable.sust);
            queryData("E11");
        } else if (data.equals("swmc")) {
            placeImage.setImageResource(R.drawable.swmc);
            queryData("E41");
        } else if (data.equals("sau")) {
            placeImage.setImageResource(R.drawable.sau);
            queryData("E12");
        } else if (data.equals("smomc")) {
            placeImage.setImageResource(R.drawable.smomc);
            queryData("E13");
        } else if (data.equals("mc")) {
            placeImage.setImageResource(R.drawable.mc);
            queryData("E15");
        } else if (data.equals("rmc")) {
            placeImage.setImageResource(R.drawable.rmc);
            queryData("E16");
        } else if (data.equals("cc")) {
            placeImage.setImageResource(R.drawable.cc);
            queryData("E17");
        } else if (data.equals("rgc")) {
            placeImage.setImageResource(R.drawable.rgc);
            queryData("E18");
        } else if (data.equals("bru")) {
            placeImage.setImageResource(R.drawable.bru);
            queryData("E19");
        } else if (data.equals("gcc")) {
            placeImage.setImageResource(R.drawable.gcc);
            queryData("E20");
        } else if (data.equals("cu")) {
            placeImage.setImageResource(R.drawable.cu);
            queryData("E21");
        } else if (data.equals("cmc")) {
            placeImage.setImageResource(R.drawable.cmc);
            queryData("E22");
        } else if (data.equals("bsc")) {
            placeImage.setImageResource(R.drawable.bsc);
            queryData("E23");
        } else if (data.equals("awc")) {
            placeImage.setImageResource(R.drawable.awc);
            queryData("E14");
        } else if (data.equals("ku")) {
            placeImage.setImageResource(R.drawable.ku);
            queryData("E24");
        } else if (data.equals("kmc")) {
            placeImage.setImageResource(R.drawable.kmc);
            queryData("E25");
        } else if (data.equals("kpi")) {
            placeImage.setImageResource(R.drawable.kpi);
            queryData("E26");
        } else if (data.equals("kwc")) {
            placeImage.setImageResource(R.drawable.kwc);
            queryData("E27");
        } else if (data.equals("bm")) {
            placeImage.setImageResource(R.drawable.bm);
            queryData("E28");
        } else if (data.equals("gc")) {
            placeImage.setImageResource(R.drawable.gc);
            queryData("E29");
        } else if (data.equals("smc")) {
            placeImage.setImageResource(R.drawable.smc);
            queryData("E30");
        } else if (data.equals("bpi")) {
            placeImage.setImageResource(R.drawable.bpi);
            queryData("E31");
        } else if (data.equals("bwc")) {
            placeImage.setImageResource(R.drawable.bwc);
            queryData("E32");
        } else if (data.equals("rmc")) {
            placeImage.setImageResource(R.drawable.rmc);
            queryData("E33");
        } else if (data.equals("ruet")) {
            placeImage.setImageResource(R.drawable.ruet);
            queryData("E34");
        } else if (data.equals("rwc")) {
            placeImage.setImageResource(R.drawable.rwc);
            queryData("E35");
        } else if (data.equals("rpi")) {
            placeImage.setImageResource(R.drawable.rpi);
            queryData("E36");
        } else if (data.equals("amc")) {
            placeImage.setImageResource(R.drawable.amc);
            queryData("E37");
        } else if (data.equals("mmc")) {
            placeImage.setImageResource(R.drawable.mmc);
            queryData("E38");
        } else if (data.equals("mwc")) {
            placeImage.setImageResource(R.drawable.mwc);
            queryData("E39");
        } else if (data.equals("knu")) {
            placeImage.setImageResource(R.drawable.knu);
            queryData("E40");
        }


        //=============Hotel============


        else if (data.equals("intercontinental")) {
            placeImage.setImageResource(R.drawable.intercontinental);
            queryData("Hotel1");
        } else if (data.equals("radisson")) {
            placeImage.setImageResource(R.drawable.radisson);
            queryData("Hotel 2");
        } else if (data.equals("westin")) {
            placeImage.setImageResource(R.drawable.westin);
            queryData("Hotel 3");
        } else if (data.equals("lemeridien")) {
            placeImage.setImageResource(R.drawable.lemeridien);
            queryData("Hotel4");
        } else if (data.equals("sixseasons")) {
            placeImage.setImageResource(R.drawable.sixseasons);
            queryData("Hotel5");
        } else if (data.equals("roseview")) {
            placeImage.setImageResource(R.drawable.roseview);
            queryData("Hotel6");
        } else if (data.equals("amari")) {
            placeImage.setImageResource(R.drawable.amari);
            queryData("Hotel7");
        } else if (data.equals("dhakaregency")) {
            placeImage.setImageResource(R.drawable.dhakaregency);
            queryData("Hotel8");
        } else if (data.equals("dusai")) {
            placeImage.setImageResource(R.drawable.dusai);
            queryData("Hotel9");
        } else if (data.equals("coxtoday")) {
            placeImage.setImageResource(R.drawable.coxtoday);
            queryData("Hotel10");
        }


    }

    private void queryData(String id) {

        progressBar.setVisibility(View.VISIBLE);
        Query checkUser = FirebaseDatabase.getInstance().getReference("All Descriptions").orderByChild("id").equalTo(id);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    String _placeName = snapshot.child(id).child("placeName").getValue(String.class);
                    String _place = snapshot.child(id).child("place").getValue(String.class);
                    String _website = snapshot.child(id).child("website").getValue(String.class);
                    String _phone = snapshot.child(id).child("phone").getValue(String.class);
                    String _descriptions = snapshot.child(id).child("description").getValue(String.class);


                    placeNameDN.setText(_placeName);
                    placeDN.setText(_place);
                    websiteDN.setText(_website);
                    phoneDN.setText(_phone);
                    descriptionDN.setText(_descriptions);
                    progressBar.setVisibility(View.GONE);

                    data = _place;


                    //=====================address set in google map===========
                    if (_place == null) {
                        Toast.makeText(DescriptionActivity.this, "No address found!", Toast.LENGTH_SHORT).show();
                    } else {

                        placeDN.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), MyMapsActivity.class);
                                intent.putExtra("address", _place);
                                startActivity(intent);
                            }
                        });
                    }

                    //============Website visit=================
                    if (_website == null) {

                    } else {

                        websiteLink = _website;
                        websiteDN.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                websiteLink = websiteLink.replaceAll("\\s", "");
                                Uri uri = Uri.parse(websiteLink);

                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            }
                        });

                    }


                    //===============Phone number to dailer=====================

                    if (_phone==null){

                    }else {

                        phoneDN.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String phone = "tel:"+_phone;
                                Uri uri = Uri.parse(phone);
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(uri);
                                startActivity(intent);
                            }
                        });

                    }

                } else if (!snapshot.exists()) {
                    Toast.makeText(DescriptionActivity.this, "Sorry! No Data found!  " + "\n" + "The developer is updating  data!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


                Toast.makeText(DescriptionActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }

}