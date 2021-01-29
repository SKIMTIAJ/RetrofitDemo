package com.imtiaj.encoders.previouswork.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeautyAndSpa {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
