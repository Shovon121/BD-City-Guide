package com.example_bd_city_guide_app.cityguideapp.HelperClasses.CategoriesAdapter;

import android.graphics.drawable.Drawable;

public class CategoriesHelperClass {
    int image;
    String title;
    Drawable gradient;

    public CategoriesHelperClass() {
    }


    public CategoriesHelperClass(int image, String title, Drawable gradient) {
        this.image = image;
        this.title = title;
        this.gradient = gradient;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getGradient() {
        return gradient;
    }
}
