package com.imtiaj.encoders.post_method_project.response;

import com.imtiaj.encoders.post_method_project.model.LastLogin;

public class MainResponseObject {

    private String email;
    private String gender;
    private String id;
    private LastLogin last_login;

    public MainResponseObject(String email, String gender, String id, LastLogin last_login) {
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.last_login = last_login;
    }

    public MainResponseObject() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LastLogin getLast_login() {
        return last_login;
    }

    public void setLast_login(LastLogin last_login) {
        this.last_login = last_login;
    }
}
