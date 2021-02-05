package com.imtiaj.encoders.post_method_project;

import com.imtiaj.encoders.post_method_project.model.MainObject;
import com.imtiaj.encoders.post_method_project.response.MainResponseObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurRetrofitClient {
    @POST("q")
    Call<MainResponseObject> getResponse(@Body MainObject mainObject);

}
