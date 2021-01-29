package com.imtiaj.encoders.previouswork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.imtiaj.encoders.R;
import com.imtiaj.encoders.previouswork.adapter.Recycler_Main;
import com.imtiaj.encoders.previouswork.model.ApiPojo;
import com.imtiaj.encoders.previouswork.model.BeautyAndSpa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Recycler_Main adapter;

    List<BeautyAndSpa> arraylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView)findViewById(R.id.Recyclerview);
        arraylist =  new ArrayList<>();

        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);

        Call<ApiPojo> call = service.getUserAll();

        call.enqueue(new Callback<ApiPojo>() {
            @Override
            public void onResponse(Call<ApiPojo> call, Response<ApiPojo> response) {
                loadDataList(response.body());
            }
            @Override
            public void onFailure(Call<ApiPojo> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("MainActivity_Msg",t.toString());
            }
        });

    }

    private void loadDataList(ApiPojo body) {

           /* for (ApiPojo pojo:body){*/
                Log.d("MainActivity_msg",body.getResult());
                arraylist = body.getBeautyAndSpa();

            adapter = new Recycler_Main(arraylist,MainActivity.this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
        /*}
        else{
            Toast.makeText(MainActivity.this,"api fetching is not successfull",Toast.LENGTH_LONG).show();
        }*/
    }


}


