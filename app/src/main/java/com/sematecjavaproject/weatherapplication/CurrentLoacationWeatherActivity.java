package com.sematecjavaproject.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.sematecjavaproject.weatherapplication.Weather.Weather;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class CurrentLoacationWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_loacation_weather);

        String url;
        final Double mainTemp;

        Toast.makeText(CurrentLoacationWeatherActivity.this, "open drawer to change city", Toast.LENGTH_SHORT).show();




        TextView txtCity = findViewById(R.id.txtCity);
        TextView txtWeatherType = findViewById(R.id.txtWeatherType);
        TextView txtWeatherDescription = findViewById(R.id.txtWeatherDescription);

        ImageView imgWeatherIcon = findViewById(R.id.imgWeatherIcon);

        TextView txtMinTemp = findViewById(R.id.txtMinTemp);
        TextView txtMaxTemp = findViewById(R.id.txtMaxTemp);
        TextView txtMainTemp = findViewById(R.id.txtMainTemp);
        TextView txtWindSpeed = findViewById(R.id.txtWindSpeed);
        TextView txtSunrise = findViewById(R.id.txtSunrise);
        TextView txtSunset = findViewById(R.id.txtSunset);

        url = "http://api.openweathermap.org/data/2.5/find?q=Tehran&units=metric&APPID=05c1d09d0ef22e9f6ddfbf67d8dcc151";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();

                Weather weather = gson.fromJson(response.toString(), Weather.class);
                mainTemp = weather.getMain().ge;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


        TextView txtChangeCity = findViewById(R.id.txtChangeCity);
        TextView textView = findViewById(R.id.txtTest);
        RecyclerView recyclerView = findViewById(R.id.OtherDaysRecyclerView);

        txtChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent changeCityIntent = new Intent(CurrentLoacationWeatherActivity.this, SearchCityActivity.class);
                startActivity(changeCityIntent);
            }
        });

        ItemAdapterActivity itemAdapterActivity = new ItemAdapterActivity();
        recyclerView.setAdapter(itemAdapterActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(CurrentLoacationWeatherActivity.this, RecyclerView.HORIZONTAL, false));




    }
}
