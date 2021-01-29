package com.imtiaj.encoders.previouswork.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiPojo {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("beautyAndSpa")
    @Expose
    private List<BeautyAndSpa> beautyAndSpa = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<BeautyAndSpa> getBeautyAndSpa() {
        return beautyAndSpa;
    }

    public void setBeautyAndSpa(List<BeautyAndSpa> beautyAndSpa) {
        this.beautyAndSpa = beautyAndSpa;
    }

}
