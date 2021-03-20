package com.example_bd_city_guide_app.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example_bd_city_guide_app.cityguideapp.HelperClasses.SliderAdapter;
import com.example_bd_city_guide_app.cityguideapp.R;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter adapter ;

    TextView dots[] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        init();

        adapter = new SliderAdapter(this);
        viewPager.setAdapter(adapter);
        addDots(0);
        viewPager.addOnPageChangeListener(listener);

    }

    private void init() {
        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.linerLayout);

    }

    public void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.primary));
        }
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}