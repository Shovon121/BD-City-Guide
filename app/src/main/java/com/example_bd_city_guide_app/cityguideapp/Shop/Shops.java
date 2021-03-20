package com.example_bd_city_guide_app.cityguideapp.Shop;

public class Shops {
   private String name ;
   private int image;

    public Shops() {
    }

    public Shops(String name, int image) {
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
