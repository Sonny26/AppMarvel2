package com.example.appmarvel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelRestApi {

    @GET("marvel.json")
    Call<RestMarvelResponse> getListMarvel();

}
