package com.example.arief.androidretrofitcobagsonserializedname.retrofithandler;

import com.example.arief.androidretrofitcobagsonserializedname.model.People;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Arief on 8/24/2017.
 */

public interface RetrofitAPI {



    @GET("coba_json_arr.php")
    Call<People> getPeople();

    @GET("coba_json_arr.php")
    Call<List<People>> getPeopleByList();

    @GET("coba_json_arr.php")
    Call<JsonArray> getJsonArr();
}
