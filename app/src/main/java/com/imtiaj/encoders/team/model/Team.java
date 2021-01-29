package com.imtiaj.encoders.team.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("name")
    private String name;

    @SerializedName("country_id")
    private int country_id;

    /*public Team() {
    }*/

    public Team(String name, int country_id) {
        this.name = name;
        this.country_id = country_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
