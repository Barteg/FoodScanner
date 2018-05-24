package com.example.bartek.foodscanner;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bartek on 13.05.2018.
 */

public class foodModel {

    @SerializedName("productName")
    public String productName;

    @SerializedName("productCode")
    public long productCode;
    @SerializedName("firstComponent")
    String firstComponent;
/*
    @SerializedName("second")
    String second;

    @SerializedName("third")
    String third;

*/
    public foodModel(long productCode, String productName) {
        this.productCode = productCode;
        this.productName = productName;
    }
    public String getName() {
        return productName;
    }

    public foodModel(String productName, long productCode, String firstComponent)
    {
        this.productName = productName;
        this.productCode = productCode;
        this.firstComponent = firstComponent;
    }
    public foodModel(String productName)
    {
        this.productName = productName;
    }
}
