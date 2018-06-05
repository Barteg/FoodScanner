package com.example.bartek.foodscanner;

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

/**
 * Created by Radex on 05.06.2018.
 */

public class DeleteFood extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_food);


        final EditText deleteText = (EditText) findViewById(R.id.deleteText);
        final Button deleteButton = (Button) findViewById(R.id.deleteItButton);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://foodapi18.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        final Controller service = retrofit.create(Controller.class);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String productCode = deleteText.getText().toString();

                //Call<Void> deleteProduct(@Path("products/{code}") long productCode);
               Call<foodModel> deleteCall = service.deleteProduct(productCode);

                deleteCall.enqueue(new Callback<foodModel>() {

                    @Override
                    public void onResponse(Call<foodModel> call, Response<foodModel> response) {

                            //if (response.body().productCode == deleteText)

                            Toast.makeText(DeleteFood.this, "nie usunięto: " + response.body().getName(), Toast.LENGTH_LONG).show();
                        }


                    @Override
                    public void onFailure(Call<foodModel> call, Throwable t) {
                        Toast.makeText(DeleteFood.this, "Usunięto ", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
