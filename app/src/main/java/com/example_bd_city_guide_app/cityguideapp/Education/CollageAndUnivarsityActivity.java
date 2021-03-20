package com.example_bd_city_guide_app.cityguideapp.Education;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example_bd_city_guide_app.cityguideapp.R;

import java.util.ArrayList;

public class CollageAndUnivarsityActivity extends AppCompatActivity {

    private String msg;
    private RecyclerView recyclerView;
    private EducationAdapter adapter;
    private ArrayList<Education> educations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collage_and_univarsity);


        recyclerView = findViewById(R.id.recycler_view);

        msg = getIntent().getStringExtra("msg");

        if (msg == null) {



        } else if (msg.equals("dhaka")) {

            showDhakaAllEducations();

        } else if (msg.equals("mymensingh")) {
            showMymensinghAllEducations();

        } else if (msg.equals("barishal")) {

            showBarishalAllEducations();

        } else if (msg.equals("rajshahi")) {
            showRajshahiAllEducations();

        } else if (msg.equals("khulna")) {
            showKhulnaAllEducations();

        } else if (msg.equals("chittagong")) {
            showChittagoAngllEducations();


        } else if (msg.equals("rangpur")) {
            showRangpurAllEducations();

        } else if (msg.equals("sylhet")) {
            showSylhetAllEducations();
        }


    }

    private void showSylhetAllEducations() {
        educations = new ArrayList<>();
        educations.add(new Education("Shahjalal University of Science & Technology(SUST)", R.drawable.sust));
        educations.add(new Education("SWMC - Sylhet Women's Medical College", R.drawable.swmc));
        educations.add(new Education("Sylhet Agricultural University(SAU)", R.drawable.sau));
        educations.add(new Education("Sylhet MAG Osmani Medical College", R.drawable.smomc));
        educations.add(new Education("MC College", R.drawable.mc));
        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


    }

    private void showRangpurAllEducations() {

        educations = new ArrayList<>();
        educations.add(new Education("Rangpur Medical College", R.drawable.rmc));
        educations.add(new Education("Carmichael College Rangpur", R.drawable.cc));
        educations.add(new Education("Rangpur Government College", R.drawable.rgc));
        educations.add(new Education("Begum Rokeya University", R.drawable.bru));
        educations.add(new Education("Government City College", R.drawable.gcc));
        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


    }

    private void showChittagoAngllEducations() {
        educations = new ArrayList<>();
        educations.add(new Education("University of Chittagong", R.drawable.cu));
        educations.add(new Education("Chittagong Medical College", R.drawable.cmc));
        educations.add(new Education("BAF Shaheen College", R.drawable.bsc));
        educations.add(new Education(" Chittagong University of Engineering and Technology(CUET)", R.drawable.cuet));
        educations.add(new Education("Agrabad Mohila College", R.drawable.awc));
        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


    }

    private void showKhulnaAllEducations() {
        educations = new ArrayList<>();
        educations.add(new Education("Khulna University", R.drawable.ku));
        educations.add(new Education("Khulna Medical College", R.drawable.kmc));
        educations.add(new Education("Khulna University Of Engineering & Technology (KUET)", R.drawable.kuet));
        educations.add(new Education(" Khulna Polytechnic Institute", R.drawable.kpi));
        educations.add(new Education("Khulna Government Mahila College", R.drawable.kwc));
        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


        //========Home Data Send=============

    }

    private void showBarishalAllEducations() {
        educations = new ArrayList<>();
        educations.add(new Education("Government BM College", R.drawable.bm));
        educations.add(new Education("Govt. Barishal College", R.drawable.gc));
        educations.add(new Education("Sher-E-Bangla Medical College", R.drawable.smc));
        educations.add(new Education(" বরিশাল পলিটেকনিক ইনস্টিটিউট", R.drawable.bpi));
        educations.add(new Education("Barisal Govt. Women's College", R.drawable.bwc));
        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


    }

    private void showRajshahiAllEducations() {
        educations = new ArrayList<>();
        educations.add(new Education("Rajshahi University(RU)", R.drawable.ru));
        educations.add(new Education("Rajshahi Medical College", R.drawable.rmc));
        educations.add(new Education("Rajshahi University of Engineering and Technology(RUET)", R.drawable.ruet));
        educations.add(new Education("Rajshahi Govt. Mahila College", R.drawable.rwc));
        educations.add(new Education("রাজশাহী পলিটেকনিক ইনস্টিটিউট", R.drawable.rpi));
        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


    }

    private void showMymensinghAllEducations() {
        educations = new ArrayList<>();
        educations.add(new Education("Bangladesh Agricultural University(BAU)", R.drawable.bau));
        educations.add(new Education("Ananda Mohan College", R.drawable.amc));
        educations.add(new Education("Mymensingh Medical College", R.drawable.mmc));
        educations.add(new Education(" মুমিনুন্নিসা সরকারি মহিলা", R.drawable.mwc));
        educations.add(new Education("জাতীয় কবি কাজী নজরুল ইসলাম বিশ্ববিদ্যালয়", R.drawable.knu));
        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


    }

    private void showDhakaAllEducations() {


        educations = new ArrayList<>();

        educations.add(new Education("Bangladesh University of Engineering and Technology(BUET)", R.drawable.buet));
        educations.add(new Education("Dhaka University", R.drawable.dhakauniversity));
        educations.add(new Education("Jahangirnagar University", R.drawable.jahangirnagar));
        educations.add(new Education("North South University", R.drawable.northsout));
        educations.add(new Education("Brac University", R.drawable.brac));


        adapter = new EducationAdapter(this, educations);
        setRecyclerView();


    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }


}


