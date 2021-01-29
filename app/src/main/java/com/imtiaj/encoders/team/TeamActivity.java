package com.imtiaj.encoders.team;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.imtiaj.encoders.R;
import com.imtiaj.encoders.team.adapter.PlayerAdapter;
import com.imtiaj.encoders.team.model.PlayerChildObject;
import com.imtiaj.encoders.team.model.PlayerList;
import com.imtiaj.encoders.team.model.Position;
import com.imtiaj.encoders.team.model.Team;
import com.imtiaj.encoders.team.model.TeamData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TeamActivity extends AppCompatActivity {

    TeamInterface teamInterface;

    private RecyclerView recyclerView;
    private ArrayList<PlayerChildObject> list;
    private ArrayList<Team> teamlist;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        list = new ArrayList<>();
        teamlist = new ArrayList<>();

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit
                            .Builder()
                            .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

       teamInterface = retrofit.create(TeamInterface.class);

        Call<TeamData> call = teamInterface.getdata(10,"4t2RqsIitRSsqgTE9HgYktbcduLuTdbsVvO7tXuCWDAXyGKCbpWF2PW88j8n");
        call.enqueue(new Callback<TeamData>() {
            @Override
            public void onResponse(Call<TeamData> call, Response<TeamData> response) {
                Team team = response.body().getData();

               int contryId = team.getCountry_id();
               String teamName = team.getName();
                Log.d("contryId", String.valueOf(contryId));
                Log.d("teamName", String.valueOf(teamName));

               Call<PlayerList> callPlayer = teamInterface.getPlayerDate("4t2RqsIitRSsqgTE9HgYktbcduLuTdbsVvO7tXuCWDAXyGKCbpWF2PW88j8n",contryId);
               callPlayer.enqueue(new Callback<PlayerList>() {
                   @Override
                   public void onResponse(Call<PlayerList> call, Response<PlayerList> response) {

                      List<PlayerChildObject> playerdata = response.body().getData();
                      for (PlayerChildObject objectData : playerdata){
                          String dateOfBirth = objectData.getDateofbirth();
                          String fullName = objectData.getFullname();
                          String gender = objectData.getGender();
                          String image = objectData.getImage();

                          Position position = objectData.getPosition();
                          String positionName = position.getName();
                          int positionId = position.getId();

                          Log.d("contryId", String.valueOf(contryId));
                          Log.d("teamName", String.valueOf(teamName));
                          Log.d("dateOfBirth", String.valueOf(dateOfBirth));
                          Log.d("fullName", String.valueOf(fullName));
                          Log.d("positionName", String.valueOf(positionName));
                          Log.d("gender", String.valueOf(gender));
                          Log.d("positionId", String.valueOf(positionId));
                          list.add(new PlayerChildObject(fullName,dateOfBirth,gender,position,image));
                          teamlist.add(new Team(teamName,contryId));

                          PlayerAdapter adapter = new PlayerAdapter(getApplicationContext(),list,teamlist);
                          recyclerView.setAdapter(adapter);

                          progressBar.setVisibility(View.GONE);

                      }
                   }

                   @Override
                   public void onFailure(Call<PlayerList> call, Throwable t) {

                       t.fillInStackTrace();
                       Log.d("fail", t.toString());
                   }
               });
            }

            @Override
            public void onFailure(Call<TeamData> call, Throwable t) {

            }
        });

    }
}