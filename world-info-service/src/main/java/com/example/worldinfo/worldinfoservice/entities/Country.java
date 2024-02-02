package com.example.worldinfo.worldinfoservice.entities;


import java.util.Set;

public class Country {
    private final int countryId;
    private final String name;
    private final float area;
    private final Set<Language> spokenLanguages;

    public Country(int countryId, String name, float area, Set<Language> spokenLanguages) {
        this.countryId = countryId;
        this.name = name;
        this.area = area;
        this.spokenLanguages = spokenLanguages;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public float getArea() {
        return area;
    }

    public Set<Language> getSpokenLanguages() {
        return spokenLanguages;
    }
}
