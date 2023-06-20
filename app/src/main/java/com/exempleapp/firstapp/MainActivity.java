package com.exempleapp.firstapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.exempleapp.firstapp.Ads.applovinADS;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.exempleapp.firstapp.Ads.constant;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
CardView cardView;
    Button START , RATE , PRIVACY;
    FrameLayout nativeads ,nativeads1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();


        slideModels.add(new SlideModel(constant.scrollbg1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(constant.scrollbg2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(constant.scrollbg3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(constant.scrollbg4, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int position) {
                SlideModel slideModel = slideModels.get(position);
                    if (position==0){
                        Uri uri = Uri.parse(constant.scrollUrl1); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else if (position==2){
                    Uri uri = Uri.parse(constant.scrollUrl2); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                    else if(position==3){
                    Uri uri = Uri.parse(constant.scrollUrl3); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                    else if (position==4){
                    Uri uri = Uri.parse(constant.scrollUrl4); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });


        cardView = findViewById(R.id.endapp);

         nativeads = findViewById(R.id.Nativeads );
        applovinADS.createNativeAd(this,nativeads);

        nativeads1 = findViewById(R.id.adsnative );
        applovinADS.createNativeAd(this,nativeads1);



        ImageView cpaimag = this.findViewById(R.id.cpaimag);
        ViewGroup rootView = findViewById(R.id.maxad_container );
        applovinADS.PromotedAds(this,rootView,cpaimag);




        START = findViewById(R.id.btn_start);
        RATE = findViewById(R.id.btn_rate);
        PRIVACY = findViewById(R.id.btn_privacy);

        START.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                applovinADS.interstitialadload(MainActivity.this, new applovinADS.Adfinished() {
                    @Override
                    public void onADfinished() {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);

                    }
                });






            }
        });



        RATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                startActivity(rateIntent);

            }
        });

        PRIVACY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.stackoverflow.com"));
                startActivity(intent);

            }
        });

    }






 @Override
    public void onBackPressed() {
        if(cardView.getVisibility()==View.GONE){
            cardView.setVisibility(View.VISIBLE);

        }
        else {
            cardView.setVisibility(View.GONE);

        }

        Button no = findViewById(R.id.No);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setVisibility(View.GONE);
            }
        });

        Button yes = findViewById(R.id.Yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });


    }
}