package com.example.worldinfo.worldinfoservice.entities;


import java.io.Serializable;
import java.util.Date;

public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    private final short countryId;
    private final String name;
    private final float area;
    private final Date nationalDay;
    private final String countryCodeTwoLetters;
    private final String countryCodeThreeLetters;
    private final short regionId;

    public Country(short countryId, String name, float area, Date nationalDay, String countryCodeTwoLetters, String countryCodeThreeLetters, short regionId) {
        this.countryId = countryId;
        this.name = name;
        this.area = area;
        this.nationalDay = nationalDay;
        this.countryCodeTwoLetters = countryCodeTwoLetters;
        this.countryCodeThreeLetters = countryCodeThreeLetters;
        this.regionId = regionId;
    }

    public short getRegionId() {
        return regionId;
    }

    public Date getNationalDay() {
        return nationalDay;
    }

    public String getCountryCodeTwoLetters() {
        return countryCodeTwoLetters;
    }

    public String getCountryCodeThreeLetters() {
        return countryCodeThreeLetters;
    }

    public short getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public float getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", nationalDay=" + nationalDay +
                ", countryCodeTwoLetters='" + countryCodeTwoLetters + '\'' +
                ", countryCodeThreeLetters='" + countryCodeThreeLetters + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}
