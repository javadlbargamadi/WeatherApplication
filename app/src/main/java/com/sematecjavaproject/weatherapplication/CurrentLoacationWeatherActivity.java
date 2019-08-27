package com.sematecjavaproject.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentLoacationWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_loacation_weather);

        Toast.makeText(CurrentLoacationWeatherActivity.this, "in down section", Toast.LENGTH_LONG).show();
        Toast.makeText(CurrentLoacationWeatherActivity.this, "swipe left", Toast.LENGTH_LONG).show();

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
