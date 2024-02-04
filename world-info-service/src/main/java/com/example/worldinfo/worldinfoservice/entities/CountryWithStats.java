package com.example.worldinfo.worldinfoservice.entities;

import java.io.Serializable;
import java.util.Date;

public class CountryWithStats extends Country implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int year;
    private final long population;
    private final long gdp;
    private final float gdp_per_capita;


    public CountryWithStats(short countryId, String name, float area, Date nationalDay, String countryCodeTwoLetters, String countryCodeThreeLetters, short regionId, int year, long population, long gdp, float gdpPerCapita) {
        super(countryId, name, area, nationalDay, countryCodeTwoLetters, countryCodeThreeLetters, regionId);
        this.year = year;
        this.population = population;
        this.gdp = gdp;
        this.gdp_per_capita = gdpPerCapita;
    }

    @Override
    public String toString() {
        return "CountryWithStats{" +
                "year=" + year +
                ", population=" + population +
                ", gdp=" + gdp +
                '}';
    }

    public float getGdpPerCapita() {
        return gdp_per_capita;
    }

    public int getYear() {
        return year;
    }

    public long getPopulation() {
        return population;
    }

    public long getGdp() {
        return gdp;
    }
}
