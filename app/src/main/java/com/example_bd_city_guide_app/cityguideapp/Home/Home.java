package com.example_bd_city_guide_app.cityguideapp.Home;

public class Home {

    String name;
    int image;

    public Home() {
    }

    public Home(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
