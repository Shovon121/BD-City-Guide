package com.example_bd_city_guide_app.cityguideapp.Restaurent;

public class Restaurent {

    private String name;
    private int image;

    public Restaurent() {
    }

    public Restaurent(String name, int image) {
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
