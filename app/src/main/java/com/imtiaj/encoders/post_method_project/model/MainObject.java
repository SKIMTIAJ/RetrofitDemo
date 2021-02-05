package com.imtiaj.encoders.post_method_project.model;

public class MainObject {
    private String token;
    private DataObject data;

    public MainObject(String token, DataObject data) {
        this.token = token;
        this.data = data;
    }

    public MainObject() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataObject getData() {
        return data;
    }

    public void setData(DataObject data) {
        this.data = data;
    }
}
