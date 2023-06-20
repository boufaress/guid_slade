package com.exempleapp.firstapp.Ads;

import android.app.Activity;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;

public class ironesource {
    public interface Adfinished{
        void onADfinished();

    }



    public static void initialize_ironSource (Activity activity){




        IronSource.init(activity, constant.ironsourceid, IronSource.AD_UNIT.INTERSTITIAL);
        IronSource.init(activity, constant.ironsourceid, IronSource.AD_UNIT.REWARDED_VIDEO);
        //Init Interstitial
        IronSource.init(activity, constant.ironsourceid, IronSource.AD_UNIT.INTERSTITIAL);
//Init Offerwall
        IronSource.init(activity, constant.ironsourceid, IronSource.AD_UNIT.OFFERWALL);
//Init Banner
        IronSource.init(activity, constant.ironsourceid, IronSource.AD_UNIT.BANNER);
        lowdReword( activity);
        IronSource.loadInterstitial();
        IronSource.init(activity, constant.ironsourceid, new InitializationListener() {
                    @Override
                    public void onInitializationComplete() {

                    }
                });


        applovinADS.ApplovIninit(activity);

    }
    public static void interstitial_ironSource (Activity activity) {
        if (IronSource.isInterstitialReady()){
           // Toast.makeText(activity, "ironsource inter show", Toast.LENGTH_SHORT).show();
            IronSource.showInterstitial();
            ironesource.lowdinter(activity);
        }
        else  {

            IronSource.loadInterstitial();

        }



    }
    public static void lowdinterAdfeneched (Activity activity) {
        IronSource.loadInterstitial();

        IronSource.setInterstitialListener(new InterstitialListener() {

            @Override
            public void onInterstitialAdReady() {

                IronSource.showInterstitial();


            }


            @Override
            public void onInterstitialAdLoadFailed(IronSourceError error) {



            }


            @Override
            public void onInterstitialAdOpened() {
            }

            /*
             * Invoked when the ad is closed and the user is about to return to the application.
             */
            @Override
            public void onInterstitialAdClosed() {





            }


            @Override
            public void onInterstitialAdShowFailed(IronSourceError error) {




            }

            /*
             * Invoked when the end user clicked on the interstitial ad, for supported networks only.
             */
            @Override
            public void onInterstitialAdClicked() {
            }


            @Override
            public void onInterstitialAdShowSucceeded() {
            }
        });
    }

    public static void lowdinter (Activity activity) {
        IronSource.loadInterstitial();

        IronSource.setInterstitialListener(new InterstitialListener() {

            @Override
            public void onInterstitialAdReady() {

                IronSource.showInterstitial();


            }


            @Override
            public void onInterstitialAdLoadFailed(IronSourceError error) {



            }


            @Override
            public void onInterstitialAdOpened() {
            }

            /*
             * Invoked when the ad is closed and the user is about to return to the application.
             */
            @Override
            public void onInterstitialAdClosed() {





            }


            @Override
            public void onInterstitialAdShowFailed(IronSourceError error) {




            }

            /*
             * Invoked when the end user clicked on the interstitial ad, for supported networks only.
             */
            @Override
            public void onInterstitialAdClicked() {
            }


            @Override
            public void onInterstitialAdShowSucceeded() {
            }
        });
    }
        public static void lowdReword (Activity activity){
            IronSource.loadRewardedVideo();

            IronSource.setLevelPlayRewardedVideoListener(new LevelPlayRewardedVideoListener() {

                @Override
                public void onAdOpened(AdInfo adInfo) {

                }

                @Override
                public void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
                    IronSource.loadRewardedVideo();
                }

                @Override
                public void onAdClicked(Placement placement, AdInfo adInfo) {

                }

                @Override
                public void onAdRewarded(Placement placement, AdInfo adInfo) {

                }

                @Override
                public void onAdClosed(AdInfo adInfo) {
                    IronSource.loadRewardedVideo();
                }

                @Override
                public void onAdAvailable(AdInfo adInfo) {

                }

                @Override
                public void onAdUnavailable() {

                }
            });



        }

    public static void ShowReword (Activity activity){
        if (IronSource.isRewardedVideoAvailable()){
            IronSource.showRewardedVideo();
            IronSource.loadRewardedVideo();
        }
        else
        {

            IronSource.loadRewardedVideo();
        }

    }











}
