package com.imtiaj.encoders.post_method_project.model;

public class DataObject {

    private String id;
    private String email;
    private String gender;
    private LastLogin last_login;

    public DataObject(String id, String email, String gender, LastLogin last_login) {
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.last_login = last_login;
    }

    public DataObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LastLogin getLast_login() {
        return last_login;
    }

    public void setLast_login(LastLogin last_login) {
        this.last_login = last_login;
    }
}
