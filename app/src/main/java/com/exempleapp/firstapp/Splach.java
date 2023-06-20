package com.exempleapp.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.exempleapp.firstapp.Ads.applovinADS;
import com.exempleapp.firstapp.Ads.constant;
import com.exempleapp.firstapp.Ads.pb_internet;

public class Splach extends AppCompatActivity {

    private int counter = 0 ;
    private ProgressBar progressBar;
    private TextView loading ;
    private Handler handler = new Handler();
    private int waited = 100;
    public static Intent nxtIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        progressBar = findViewById(R.id.progressBar);
        loading = findViewById(R.id.loading);

        setProgress();


    }

    public void setProgress(){
        Handler hndler = new Handler();
        hndler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (constant.statue==0){
                    hndler.postDelayed(this,500);

                } else if (constant.statue==1) {
                    nxtIntent = new Intent(Splach.this, MainActivity.class) ;
                    hndler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        applovinADS.interstitialload(Splach.this);
                            applovinADS.showinter(Splach.this);
                            startActivity(nxtIntent);
                            finish();

                        }
                    },3500);


                }
                else    {
                    Intent intent = new Intent(Splach.this, pb_internet.class);
                    startActivity(intent);

                }
            }
        },1000);
    }



}