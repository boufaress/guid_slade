package com.exempleapp.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.exempleapp.firstapp.Ads.applovinADS;
import com.exempleapp.firstapp.Ads.constant;
import com.exempleapp.firstapp.Ads.pb_internet;

public class data1 extends AppCompatActivity {

    Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data1);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        chekinternet();

        ViewGroup rootView = findViewById(R.id.maxad_container );
        applovinADS.bannerapplovin(this,rootView);




        Back = findViewById(R.id.btn_back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applovinADS.createRewardedAd(data1.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(data1.this,data2.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        });


    }

    public void chekinternet(){
        Handler hndler = new Handler();
        hndler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (constant.isNetworkAvailable(data1.this)) {
                    chekinternet();
                } else {
                    // La connexion Internet n'est pas disponible
                    Intent intent = new Intent(data1.this, pb_internet.class);
                    startActivity(intent);
                    finish();
                }

            }
        },500);
    }

}