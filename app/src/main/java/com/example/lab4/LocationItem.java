package com.example.lab4;

//Beans de Location Item
public class LocationItem {
    private int id;
    private String name;
    private String region;
    private String country;

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    private String latitud;
    private String longitud;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRegion() { return region; }
    public String getCountry() { return country; }
}
