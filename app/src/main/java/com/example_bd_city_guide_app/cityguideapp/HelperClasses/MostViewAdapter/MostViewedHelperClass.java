package com.example_bd_city_guide_app.cityguideapp.HelperClasses.MostViewAdapter;

public class MostViewedHelperClass {
    int image ;
    String title;

    public MostViewedHelperClass() {
    }

    public MostViewedHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
