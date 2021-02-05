package com.imtiaj.encoders.post_method_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.imtiaj.encoders.R;

import com.imtiaj.encoders.post_method_project.model.DataObject;
import com.imtiaj.encoders.post_method_project.model.LastLogin;
import com.imtiaj.encoders.post_method_project.model.MainObject;
import com.imtiaj.encoders.post_method_project.response.MainResponseObject;

public class PostActivity extends AppCompatActivity {

    LastLogin lastLogin;
    DataObject dataObject;
    MainObject mainObject;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_post);
      textView = findViewById(R.id.dataText);


        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("https://app.fakejson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        lastLogin = new LastLogin("dateTime|UNIX","172.242.228.245");
        dataObject = new DataObject("555","internetEmail","personGender",lastLogin);
        mainObject = new MainObject("H2bJUp21J2hPIxyMao76bg",dataObject);


        OurRetrofitClient retrofitClient = retrofit.create(OurRetrofitClient.class);
        Call<MainResponseObject> response = retrofitClient.getResponse(mainObject);

        response.enqueue(new Callback<MainResponseObject>() {
            @Override
            public void onResponse(Call<MainResponseObject> call, Response<MainResponseObject> response) {
                String email = response.body().getEmail();
                String gender = response.body().getGender();
                String id  = response.body().getId();
                LastLogin lastLogin = response.body().getLast_login();
                String date = lastLogin.getDate_time();
                String ip4 = lastLogin.getIp4();

                Log.d("Email",email);
                Log.d("Gender",gender);
                Log.d("Id",id);
                Log.d("Date",date);
                Log.d("Ip",ip4);

                textView.setText(email+",\n \n"+gender+",\n\n"+id+",\n\n"+date+",\n\n"+id);
            }

            @Override
            public void onFailure(Call<MainResponseObject> call, Throwable t) {

                Log.d("response","Fail");
            }
        });

    }
}