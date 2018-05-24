
package com.example.bartek.foodscanner;

/*
public class findFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Button button1 = (Button) findViewById(R.id.finditButton);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textProductName = (TextView) findViewById(R.id.textProductName);
        final TextView textProductCode = (TextView) findViewById(R.id.textProductCode);
        final TextView textProductFirst = (TextView) findViewById(R.id.textFirstComponent);//trzbea dopisać dla pozostałcyh składników

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_food);

        //polaczenie z api
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://foodapi17.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            final Controller service = retrofit.create(Controller.class);

       // button1.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String productCode = editText.getText().toString();

                //czyszczenie pól tekstowych
                textProductName.setText("");
                textProductCode.setText("");
                textProductFirst.setText("");

                Call<foodModel> createCall = service.getPath(productCode); //w środku service.get pluje się, ze "get(String) w interfejsie nie może być zastosowany"

                createCall.enqueue(new Callback<foodModel>() {
                    @Override
                    public void onResponse(Call<foodModel> call, Response<foodModel> resp) {
                        if (resp.body() != null) {

                            //   textView.setText("ALL foods by name:\n");
                            //  for (Food f : resp.body()) {
                            textProductName.append(resp.body().name + "\n");
                            textProductCode.append(resp.body().code + "\n");
                            textProductFirst.append(resp.body().first + "\n");
                        }
                        else
                        {
                            textProductName.setText("Bład ");
                            textProductCode.setText("Nie znaleziono produktu");
                            textProductFirst.setText(" lub kod jest niepoprawny");
                        }
                    }

                    @Override
                    public void onFailure(Call<foodModel> _, Throwable t) {
                        t.printStackTrace();
                        textProductName.setText(t.getMessage());
                    }
                });
            }
        });


    }
}
*/
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class findFood
        extends AppCompatActivity {


    private Controller service;
    private EditText textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_food);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textProductName = (TextView) findViewById(R.id.textProductName);
        final TextView textProductCode = (TextView) findViewById(R.id.textProductCode);
        final TextView textProductFirst = (TextView) findViewById(R.id.textFirstComponent);

        final Button button = (Button) findViewById(R.id.finditButton);
        final String dolan = "empty";


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://foodapi18.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        final Controller service = retrofit.create(Controller.class);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String productCode = editText.getText().toString();

                //czyszczenie pól tekstowych
                textProductName.setText("");
                textProductCode.setText("");
                textProductFirst.setText("");

                Call<foodModel> createCall = service.getPath(productCode);

                createCall.enqueue(new Callback<foodModel>() {
                    @Override
                    public void onResponse(Call<foodModel> call, Response<foodModel> resp) {
                        if (resp.body() != null) {

                            //   textView.setText("ALL foods by name:\n");
                            //  for (Food f : resp.body()) {
                            textProductName.append(resp.body().productName + "\n");
                            textProductCode.append(resp.body().productCode + "\n");
                            textProductFirst.append(resp.body().firstComponent + "\n");
                        }
                        else
                        {
                            textProductName.setText("Bład ");
                            textProductCode.setText("Nie znaleziono produktu");
                            textProductFirst.setText(" lub kod jest niepoprawny");
                        }
                    }

                    @Override
                    public void onFailure(Call<foodModel> _, Throwable t) {
                        t.printStackTrace();
                        textProductName.setText(t.getMessage());
                    }
                });

            }
        });
    }
}
