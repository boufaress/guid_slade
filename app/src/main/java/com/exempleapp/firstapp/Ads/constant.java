package com.exempleapp.firstapp.Ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.exempleapp.firstapp.BuildConfig;

public class constant {

    public static String Url= BuildConfig.Jsonurl;
    public static int statue=0;
    public static String Bannerapplovine = "1";
    public static String Interapplovine = "1";
    public static String rewordapplovine = "1";
    public static String Nativeapplovine  ="1" ;
    public static String max_native_small  ="1" ;
    public static String ironsourceid = "17c56b255";
    public static int ADSremot  =0 ;
    public static String PromotedrImg  ="" ;
    public static String PromotedrUrl  ="" ;
    public static String scrollbg1  ="https://cdn.pixabay.com/photo/2023/03/27/18/06/bird-7881393_1280.jpg" ;
    public static String scrollUrl1  ="https://cdn.pixabay.com/photo/2023/03/27/18/06/bird-7881393_1280.jpg" ;
    public static String scrollbg2  ="https://cdn.pixabay.com/photo/2023/06/03/18/12/benz-8038240_1280.jpg" ;
    public static String scrollUrl2  ="https://cdn.pixabay.com/photo/2023/03/27/18/06/bird-7881393_1280.jpg" ;
    public static String scrollbg3  ="https://cdn.pixabay.com/photo/2023/03/27/18/06/bird-7881393_1280.jpg" ;
    public static String scrollUrl3  ="https://cdn.pixabay.com/photo/2023/03/27/18/06/bird-7881393_1280.jpg" ;
    public static String scrollbg4  ="https://cdn.pixabay.com/photo/2023/06/03/18/12/benz-8038240_1280.jpg" ;
    public static String scrollUrl4  ="https://cdn.pixabay.com/photo/2023/03/27/18/06/bird-7881393_1280.jpg" ;
    public static String appfutur_Text1  ="App futur" ;
    public static String appfutur_Text2  ="-App futur \n-App futur \n-App futur" ;
    public static String appfutur_Url  ="https://www.google.com" ;
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
