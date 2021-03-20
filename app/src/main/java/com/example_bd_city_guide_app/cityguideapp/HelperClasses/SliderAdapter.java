package com.example_bd_city_guide_app.cityguideapp.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example_bd_city_guide_app.cityguideapp.R;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[]={

            R.drawable.search_place,
            R.drawable.make_a_call,
            R.drawable.add_missing_place,
            R.drawable.sit_back_and_relax
    };

    int heading[]={
            R.string.first_slide_title,
            R.string.second_slide_title,
            R.string.thered_slide_title,
            R.string.fourth_slide_title

    };
    int descriptions[]={

            R.string.first_slide_description,
            R.string.second_slide_description,
            R.string.thred_slide_description,
            R.string.fourt_slide_description

    };

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        ImageView imageView = view.findViewById(R.id.sliderImage);
        TextView  sliderTitle = view.findViewById(R.id.slider_headline);
        TextView  sliderDescription = view.findViewById(R.id.slider_description);

        imageView.setImageResource(images[position]);
        sliderTitle.setText(heading[position]);
        sliderDescription.setText(descriptions[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
