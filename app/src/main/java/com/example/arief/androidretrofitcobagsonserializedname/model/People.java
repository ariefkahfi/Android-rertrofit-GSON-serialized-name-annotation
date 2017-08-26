package com.example.arief.androidretrofitcobagsonserializedname.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arief on 8/24/2017.
 */

public class People {


    @SerializedName("id")
    private int id;

    @SerializedName("nama")
    private String nama;

    @SerializedName("hobi")
    private ArrayList<String> hobis;

    public People() {

    }

    public ArrayList<String> getHobis() {
        return hobis;
    }

    public void setHobis(ArrayList<String> hobis) {
        this.hobis = hobis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
