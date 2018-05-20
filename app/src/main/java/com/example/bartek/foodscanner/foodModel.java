package com.example.bartek.foodscanner;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bartek on 13.05.2018.
 */

public class foodModel {

    @SerializedName("name")
    public String name;

    @SerializedName("code")
    public long code;
    @SerializedName("first")
    String first;
/*
    @SerializedName("second")
    String second;

    @SerializedName("third")
    String third;

*/
    public foodModel(long code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public foodModel(String name, long code, String first)
    {
        this.name = name;
        this.code = code;
        this.first = first;
    }
    public foodModel(String name) {
        this.name = name;
    }
}
