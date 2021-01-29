package com.imtiaj.encoders.team.model;

import com.google.gson.annotations.SerializedName;

public class PlayerChildObject {

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("dateofbirth")
    private String dateofbirth;

    @SerializedName("gender")
    private String gender;

    @SerializedName("position")
    private Position position;

    @SerializedName("image_path")
    private String image_path;

    public PlayerChildObject(String fullname, String dateofbirth, String gender, Position position, String image) {
        this.fullname = fullname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.position = position;
        image_path = image;
    }

    public PlayerChildObject() {
    }

    public String getImage() {
        return image_path;
    }

    public void setImage(String image) {
        image_path = image;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
