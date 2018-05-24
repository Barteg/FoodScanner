package com.example.bartek.foodscanner;

/**
 * Created by Bartek on 13.05.2018.
 */
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Controller {

        @GET("/products")
        Call<List<foodModel>> all();


        @GET("/product/{name}")
        Call<foodModel> get(@Path("name") String productName);

        @GET("/producted/{code}")
        Call<foodModel> getPath(@Path("code") String productCode);

        @POST("products/")
        Call<foodModel> create(@Body foodModel postfood);
}
