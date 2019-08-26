package com.sematecjavaproject.weatherapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isConnected(WelcomePage.this))
            buildDialog(WelcomePage.this).show();
        else
            setContentView(R.layout.activity_welcome_page);

        View btnTapToContinue = findViewById(R.id.btnTapToContinue);

        btnTapToContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goToCurrentLocationWeatherActivity = new Intent(WelcomePage.this,CurrentLoacationWeatherActivity.class);
                startActivity(goToCurrentLocationWeatherActivity);
            }
        });
    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Please make sure you are connected to the internet." + "\n" + "Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

//    private boolean isNetworkConnected() {
//
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(WelcomePage.CONNECTIVITY_SERVICE);
//        return connectivityManager.getActiveNetworkInfo() != null & connectivityManager.getActiveNetworkInfo().isConnected();
//    }

//    public boolean isInternetAvailable() {
//
//        try {
//
//            InetAddress ipAddr = InetAddress.getByName("google.com");
//            return !ipAddr.equals("");
//        } catch (Exception e) {
//
//            return false;
//        }
//    }
}
