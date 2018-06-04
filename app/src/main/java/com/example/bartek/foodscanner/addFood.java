package com.example.bartek.foodscanner;
/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;*/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class addFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        final EditText editName = (EditText) findViewById(R.id.editName);
        final EditText editCode = (EditText) findViewById(R.id.editCode);
        final EditText editFirst = (EditText) findViewById(R.id.editFirst);
        final EditText editSecond = (EditText) findViewById(R.id.editSecond);
        final EditText editThird = (EditText) findViewById(R.id.editThird);
        final EditText editFourth = (EditText) findViewById(R.id.editFourth);
        final EditText editFifth = (EditText) findViewById(R.id.editFifth);
        final EditText editSixth = (EditText) findViewById(R.id.editSixth);
        final EditText editSeventh = (EditText) findViewById(R.id.editSeventh);
        final EditText editEighth= (EditText) findViewById(R.id.editEighth);
        final EditText editNinth = (EditText) findViewById(R.id.editNinth);
        final EditText editTenth = (EditText) findViewById(R.id.editTenth);

        Button addFoodtoDatabase = (Button) findViewById(R.id.addProductButton);

        addFoodtoDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foodModel foodmodel = new foodModel(
                        editName.getText().toString(),
                        Long.parseLong(editCode.getText().toString()),
                        editFirst.getText().toString(),
                        editSecond.getText().toString(),
                        editThird.getText().toString(),
                        editFourth.getText().toString(),
                        editFifth.getText().toString(),
                        editSixth.getText().toString(),
                        editSeventh.getText().toString(),
                        editEighth.getText().toString(),
                        editNinth.getText().toString(),
                        editTenth.getText().toString()
                );
                sendNetworkRequest(foodmodel);
            }

        });
    }

    private void  sendNetworkRequest(final foodModel foodmodel) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://foodapi18.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Controller service = retrofit.create(Controller.class);
        Call<foodModel> call = service.create(foodmodel);

        call.enqueue(new Callback<foodModel>() {
            @Override
            public void onResponse(Call<foodModel> call, Response<foodModel> response) {
                Toast.makeText(addFood.this, "Tak! Nazwa poduktu:" + response.body().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<foodModel> call, Throwable t) {
                Toast.makeText(addFood.this, "Ups... Coś poszło nie tak :( ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


