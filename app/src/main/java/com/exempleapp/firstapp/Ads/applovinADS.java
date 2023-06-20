package com.exempleapp.firstapp.Ads;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.bumptech.glide.Glide;
import com.exempleapp.firstapp.R;

public  class applovinADS {
    public interface Adfinished{
        void onADfinished();

    }
    public static MaxAdView adView;
    public static MaxInterstitialAd interstitialAd;
    public static MaxNativeAdLoader nativeAdLoader;
    public static MaxAd             nativeAd;
    public static MaxRewardedAd rewardedAd;
    public static int           retryAttempt;
    public static void ApplovIninit (Activity activity){







        AppLovinSdk.getInstance( activity ).setMediationProvider( "max" );

        AppLovinSdk.initializeSdk( activity, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads

        }
        } );
}
    public static void bannerapplovin (Activity activity,ViewGroup viewGroup){
        ApplovIninit(activity);
            String ApplovinBanner = constant.Bannerapplovine;
        adView = new MaxAdView( ApplovinBanner, activity );


        ViewGroup rootView = viewGroup;
        rootView.addView( adView );

        // Load the ad
        adView.loadAd();



        adView.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd maxAd) {

            }

            @Override
            public void onAdCollapsed(MaxAd maxAd) {

            }

            @Override
            public void onAdLoaded(MaxAd maxAd) {

            }

            @Override
            public void onAdDisplayed(MaxAd maxAd) {

            }

            @Override
            public void onAdHidden(MaxAd maxAd) {

            }

            @Override
            public void onAdClicked(MaxAd maxAd) {

            }

            @Override
            public void onAdLoadFailed(String s, MaxError maxError) {

            }

            @Override
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {

            }
        });
        adView.loadAd();
    }
    public static void showinter (Activity activity){
        if (interstitialAd.isReady()){
            interstitialAd.showAd();
        }
        else {
            interstitialload(activity);
        }
    }

    public static void interstitialload(Activity activity) {
        String interapplovin = constant.Interapplovine;
        interstitialAd = new MaxInterstitialAd(interapplovin, activity );
        MaxAdListener adListener= new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {


            }

            @Override
            public void onAdDisplayed(MaxAd ad) {
                interstitialload(activity);

            }

            @Override
            public void onAdHidden(MaxAd ad) {

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        interstitialAd.setListener(adListener);
        interstitialAd.loadAd();


    }












    public static void interstitialadload(Activity activity,Adfinished adfinished) {
        Loadingads.StartDialoge(activity);
        String interapplovin = constant.Interapplovine;
        interstitialAd = new MaxInterstitialAd(interapplovin, activity );
        MaxAdListener adListener= new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                interstitialAd.showAd();

            }

            @Override
            public void onAdDisplayed(MaxAd ad) {


            }

            @Override
            public void onAdHidden(MaxAd ad) {
                adfinished.onADfinished();
                Loadingads.closeDialoge(activity);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                adfinished.onADfinished();
                Loadingads.closeDialoge(activity);
            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                adfinished.onADfinished();
                Loadingads.closeDialoge(activity);
            }
        };
        interstitialAd.setListener(adListener);
        interstitialAd.loadAd();



    }



    public static void createNativeAd(Activity activity,FrameLayout frameLayout)
    {
        FrameLayout nativeAdContainer = frameLayout;
        String Nativeapplovin = constant.Nativeapplovine;
        nativeAdLoader = new MaxNativeAdLoader( Nativeapplovin, activity );
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if ( nativeAd != null )
                {
                    nativeAdLoader.destroy( nativeAd );
                }

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeAdContainer.removeAllViews();
                nativeAdContainer.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {
                // We recommend retrying with exponentially higher delays up to a maximum delay
            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {
                // Optional click callback
            }
        } );

        nativeAdLoader.loadAd();
    }
    public static void max_native_small(Activity activity,FrameLayout frameLayout)
    {
        FrameLayout nativeAdContainer = frameLayout;
        String Nativeapplovin = constant.max_native_small;
        nativeAdLoader = new MaxNativeAdLoader( Nativeapplovin, activity );
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if ( nativeAd != null )
                {
                    nativeAdLoader.destroy( nativeAd );
                }

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeAdContainer.removeAllViews();
                nativeAdContainer.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {
                // We recommend retrying with exponentially higher delays up to a maximum delay
            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {
                // Optional click callback
            }
        } );

        nativeAdLoader.loadAd();
    }
    public static void PromotedAds (Activity activity, ViewGroup viewGroup, ImageView imageView){

            imageView.setVisibility(View.VISIBLE);
            Glide.with(activity).load(constant.PromotedrImg)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imageView);

            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(constant.PromotedrUrl); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    activity.startActivity(intent);
                }
            });
        }

    public static void createRewardedAd(Activity activity,Adfinished adfinished)
    {
        Loadingads.StartDialoge(activity);
        rewardedAd = MaxRewardedAd.getInstance( constant.rewordapplovine, activity );
        rewardedAd.setListener(new MaxRewardedAdListener() {
            @Override
            public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {

            }

            @Override
            public void onRewardedVideoStarted(MaxAd maxAd) {

            }

            @Override
            public void onRewardedVideoCompleted(MaxAd maxAd) {

            }

            @Override
            public void onAdLoaded(MaxAd maxAd) {
                rewardedAd.showAd();
            }

            @Override
            public void onAdDisplayed(MaxAd maxAd) {

            }

            @Override
            public void onAdHidden(MaxAd maxAd) {
                Loadingads.closeDialoge(activity);
                adfinished.onADfinished();
            }

            @Override
            public void onAdClicked(MaxAd maxAd) {

            }

            @Override
            public void onAdLoadFailed(String s, MaxError maxError) {
                Loadingads.closeDialoge(activity);
                adfinished.onADfinished();
            }

            @Override
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                Loadingads.closeDialoge(activity);
                adfinished.onADfinished();
            }
        });

        rewardedAd.loadAd();
    }



}



