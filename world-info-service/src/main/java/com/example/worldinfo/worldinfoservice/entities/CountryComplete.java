package com.example.worldinfo.worldinfoservice.entities;

import java.io.Serializable;
import java.util.Date;

public class CountryComplete extends CountryWithStats implements Serializable {
    private final static long serialVersionUID = 1L;
    private final String continent;
    private final String region;

    public CountryComplete(short countryId, String name, float area, Date nationalDay, String countryCodeTwoLetters, String countryCodeThreeLetters, short regionId, int year, long population, long gdp, float gdpPerCapita, String continent, String region) {
        super(countryId, name, area, nationalDay, countryCodeTwoLetters, countryCodeThreeLetters, regionId, year, population, gdp, gdpPerCapita);
        this.continent = continent;
        this.region = region;
    }

    @Override
    public String toString() {
        return "CountryComplete{" +
                "continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }
}
