package com.imtiaj.encoders.team;

import com.imtiaj.encoders.team.model.PlayerList;
import com.imtiaj.encoders.team.model.Team;
import com.imtiaj.encoders.team.model.TeamData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TeamInterface {

    @GET("teams/{id}")
    Call<TeamData> getdata(@Path("id") int id, @Query("api_token") String token);

    @GET("players")
    Call<PlayerList> getPlayerDate(@Query("api_token") String token,
                                   @Query("country_id") int countryId);

}
