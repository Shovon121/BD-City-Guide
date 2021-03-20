package com.example_bd_city_guide_app.cityguideapp.AddData;

public class DataAddHelper {
    String id;
    String placeName;
    String place;
    String website;
    String phone;
    String description;

    public DataAddHelper() {
    }

    public DataAddHelper(String id, String placeName, String place, String website, String phone, String description) {
        this.id = id;
        this.placeName = placeName;
        this.place = place;
        this.website = website;
        this.phone = phone;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
