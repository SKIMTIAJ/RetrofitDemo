package com.imtiaj.encoders.previouswork;

import com.imtiaj.encoders.previouswork.model.ApiPojo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("amit/backup/dummeyJson.php")
    Call<ApiPojo> getUserAll();

}
