package com.example;

public class Manufacturer {
    private String name;
    private String country;

    public Manufacturer(String name, String country) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name empty");
        }
        if (country == null || country.isEmpty()) {
            throw new IllegalArgumentException("Country empty");
        }
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}