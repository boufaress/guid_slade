package com.exempleapp.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.exempleapp.firstapp.Ads.Loadingads;
import com.exempleapp.firstapp.Ads.applovinADS;
import com.exempleapp.firstapp.Ads.constant;
import com.exempleapp.firstapp.Ads.pb_internet;

public class MainActivity2 extends AppCompatActivity {
    FrameLayout nativeads ,nativeads1;
    CardView cardView;
    Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6,getapp,close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btn1 =findViewById(R.id.btn_1);
        btn2 =findViewById(R.id.btn_2);
        btn3 =findViewById(R.id.btn_3);
        btn4 =findViewById(R.id.btn_4);
        btn5 =findViewById(R.id.btn_5);
        btn6 =findViewById(R.id.btn_6);

        chekinternet();

        nativeads = findViewById(R.id.Nativeads );
        applovinADS.max_native_small(this,nativeads);

        nativeads1 = findViewById(R.id.adsnative );
        applovinADS.max_native_small(this,nativeads1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                applovinADS.interstitialadload(MainActivity2.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(MainActivity2.this,data1.class);
                        startActivity(intent);
                    }
                });


            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applovinADS.interstitialadload(MainActivity2.this, new applovinADS.Adfinished(){
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(MainActivity2.this,data2.class);
                        startActivity(intent);
                    }
                });


            }
        });



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applovinADS.interstitialadload(MainActivity2.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(MainActivity2.this,data3.class);
                        startActivity(intent);
                    }
                });


            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applovinADS.interstitialadload(MainActivity2.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(MainActivity2.this,data4.class);
                        startActivity(intent);
                    }
                });



            }
        });



        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                applovinADS.interstitialadload(MainActivity2.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(MainActivity2.this,data5.class);
                        startActivity(intent);
                        Loadingads.closeDialoge(MainActivity2.this);
                    }
                });

            }
        });



        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applovinADS.createRewardedAd(MainActivity2.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(MainActivity2.this,AppFutur.class);
                        startActivity(intent);





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
                if (constant.isNetworkAvailable(MainActivity2.this)) {
                    chekinternet();
                } else {
                    // La connexion Internet n'est pas disponible
                    Intent intent = new Intent(MainActivity2.this, pb_internet.class);
                    startActivity(intent);
                    finish();
                }

            }
        },500);
    }

}