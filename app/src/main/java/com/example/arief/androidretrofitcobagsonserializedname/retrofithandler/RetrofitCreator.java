package com.example.arief.androidretrofitcobagsonserializedname.retrofithandler;

import android.util.Log;
import android.widget.ListView;

import com.example.arief.androidretrofitcobagsonserializedname.model.People;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arief on 8/24/2017.
 */

public class RetrofitCreator {

    private static final String BASE_URL = "http://192.168.1.100/AndroidRetrofit6/";

    private ListView listView;

    public RetrofitCreator() {
    }

    public RetrofitCreator(ListView listView) {
        this.listView = listView;
    }

    private static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public void loadDataByPeople(){
       getInstance()
               .create(RetrofitAPI.class)
               .getPeople()
               .enqueue(new Callback<People>() {
                   @Override
                   public void onResponse(Call<People> call, Response<People> response) {
                       if(response.isSuccessful()){
                           Log.e("info-people",response.body().getNama());
                       }
                   }

                   @Override
                   public void onFailure(Call<People> call, Throwable t) {
                        Log.e("Error on loadPeople",t.getMessage());
                        t.printStackTrace();
                   }
               });
    }

    public void loadJsonArray(){
        getInstance()
                .create(RetrofitAPI.class)
                .getJsonArr()
                .enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        if(response.isSuccessful()){
                            for(JsonElement el : response.body()){
                               JsonArray arr = el.getAsJsonObject().get("hobi").getAsJsonArray();
                               for(JsonElement json : arr){
                                   Log.e("Info_arr",json.getAsString());
                               }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonArray> call, Throwable t) {
                        Log.e("Error JsonArr",t.getMessage());
                        t.printStackTrace();
                    }
                });
    }

    public void loadDataByPeopleList(){
        getInstance()
                .create(RetrofitAPI.class)
                .getPeopleByList()
                .enqueue(new Callback<List<People>>() {
                    @Override
                    public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                        if(response.isSuccessful()){
                            for(People p : response.body()){

                                for(String hobi : p.getHobis()){
                                    Log.e(p.getNama()+ " hobinya = " ,hobi);
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<People>> call, Throwable t) {
                        Log.e("Error on loadPeopleList",t.getMessage());
                        t.printStackTrace();
                    }
                });
    }
}
