package com.alekseysamoylov.serviceprices.model;

/**
 * Created by AlekseiSamoilov on 08/05/15.
 */
public class WorldPopulation {
    private String rank;
    private String country;
    private String population;

    public WorldPopulation(String rank, String country, String population) {
        this.rank = rank;
        this.country = country;
        this.population = population;
    }

    public String getRank() {
        return this.rank;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPopulation() {
        return this.population;
    }
}