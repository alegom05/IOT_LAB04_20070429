package com.example.lab4;

public class LocationA {
    private String idLocation;
    private String name;
    private String country;

    public LocationA(String idLocation, String name, String country) {
        this.idLocation = idLocation;
        this.name = name;
        this.country = country;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
