package com.example.lab4;

public class LocationA {
    private String idLocation;  // Asegúrate de que esta variable exista
    private String name;
    private String country;

    // Constructor
    public LocationA(String idLocation, String name, String country) {
        this.idLocation = idLocation;
        this.name = name;
        this.country = country;
    }

    // Métodos getters
    public String getIdLocation() {
        return idLocation;  // Devuelve el ID de la ubicación
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    // Métodos setters
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
