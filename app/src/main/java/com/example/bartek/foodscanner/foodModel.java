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

    @SerializedName("secondComponent")
    String secondComponent;

    @SerializedName("thirdComponent")
    String thirdComponent;


    @SerializedName("fourthComponent")
    String fourthComponent;

    @SerializedName("fifthComponent")
    String fifthComponent;

    @SerializedName("sixthComponent")
    String sixthComponent;

    @SerializedName("seventhComponent")
    String seventhComponent;

    @SerializedName("eighthComponent")
    String eighthComponent;

    @SerializedName("ninthComponent")
    String ninthComponent;

    @SerializedName("tenthComponent")
    String tenthComponent;


    public foodModel(long productCode, String productName) {
        this.productCode = productCode;
        this.productName = productName;
    }
    public String getName() {
        return productName;
    }

    public foodModel(String productName, long productCode, String firstComponent, String secondComponent, String thirdComponent, String fourthComponent,
                     String fifthComponent, String sixthComponent, String seventhComponent, String eighthComponent,   String ninthComponent, String tenthComponent)
    {
        this.productName = productName;
        this.productCode = productCode;
        this.firstComponent = firstComponent;
        this.secondComponent = secondComponent;
        this.thirdComponent = thirdComponent;
        this.fourthComponent = fourthComponent;
        this.fifthComponent = fifthComponent;
        this.sixthComponent = sixthComponent;
        this.seventhComponent = seventhComponent;
        this.eighthComponent = eighthComponent;
        this.ninthComponent = ninthComponent;
        this.tenthComponent = tenthComponent;

    }
    public foodModel(String productName)
    {
        this.productName = productName;
    }
}
