
package com.example.bartek.foodscanner;

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
        final TextView textProductSecond = (TextView) findViewById(R.id.textSecondComponent);
        final TextView textProductThird = (TextView) findViewById(R.id.textThirdComponent);
        final TextView textProductFourth = (TextView) findViewById(R.id.textFourthComponent);
        final  TextView textProductFifth = (TextView) findViewById(R.id.textFifthComponent);
        final  TextView textProductSixth = (TextView) findViewById(R.id.textSixthComponent);
        final TextView textProductSeventh = (TextView) findViewById(R.id.textSeventhComponent);
        final  TextView textProductEighth = (TextView) findViewById(R.id.textEighthComponent);
        final  TextView textProductNinth = (TextView) findViewById(R.id.textNinthComponent);
        final  TextView textProductTenth = (TextView) findViewById(R.id.textTenthComponent);

        final Button button = (Button) findViewById(R.id.finditButton);
        //final String dolan = "empty";


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://foodapi18.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        final Controller service = retrofit.create(Controller.class);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String productCode = editText.getText().toString();
                //final String productName = editText.getText().toString().trim().toLowerCase();
                //czyszczenie pól tekstowych
                textProductName.setText("");
                textProductCode.setText("");
                textProductFirst.setText("");
                textProductSecond.setText("");
                textProductThird.setText("");
                textProductFourth.setText("");
                textProductFifth.setText("");
                textProductSixth.setText("");
                textProductSeventh.setText("");
                textProductEighth.setText("");
                textProductNinth.setText("");
                textProductTenth.setText("");

                Call<foodModel> createCall = service.getPath(productCode);
                //Call<foodModel> callName = service.getPath(productName);
                createCall.enqueue(new Callback<foodModel>() {
                    @Override
                    public void onResponse(Call<foodModel> call, Response<foodModel> resp) {
                        if (resp.body() != null) {

                            //   textView.setText("ALL foods by name:\n");
                            //  for (Food f : resp.body()) {
                            textProductName.append(resp.body().productName + "\n");
                            textProductCode.append(resp.body().productCode + "\n");
                            textProductFirst.append(resp.body().firstComponent + "\n");
                            textProductSecond.append(resp.body().secondComponent + "\n");
                            textProductThird.append(resp.body().thirdComponent + "\n");
                            textProductFourth.append(resp.body().fourthComponent + "\n");
                            textProductFifth.append(resp.body().fifthComponent + "\n");
                            textProductSixth.append(resp.body().sixthComponent + "\n");
                            textProductSeventh.append(resp.body().seventhComponent + "\n");
                            textProductEighth.append(resp.body().eighthComponent + "\n");
                            textProductNinth.append(resp.body().ninthComponent + "\n");
                            textProductTenth.append(resp.body().tenthComponent + "\n");
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
