package com.exempleapp.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.exempleapp.firstapp.Ads.applovinADS;

public class data3 extends AppCompatActivity {

    Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data3);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ViewGroup rootView = findViewById(R.id.maxad_container );
        applovinADS.bannerapplovin(this,rootView);


        Back = findViewById(R.id.btn_back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applovinADS.createRewardedAd(data3.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(data3.this,data4.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        });


    }
}