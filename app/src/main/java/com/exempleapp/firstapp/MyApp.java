package com.exempleapp.firstapp;

import androidx.multidex.MultiDexApplication;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.exempleapp.firstapp.Ads.constant;

import org.json.JSONException;
import org.json.JSONObject;

public class MyApp extends MultiDexApplication {

    RequestQueue queue;

    @Override
    public void onCreate() {


        Getdata ();
        super.onCreate();
    }

    private void  Getdata () {
        queue = Volley.newRequestQueue(this);
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, constant.Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject ads = response.getJSONObject("ads");

                    constant.Bannerapplovine = ads.getString("Bannerapplovine");
                    constant.Interapplovine = ads.getString("Interapplovine");
                    constant.Nativeapplovine = ads.getString("max_native_normal");
                    constant.rewordapplovine = ads.getString("rewordapplovine");
                    constant.max_native_small = ads.getString("max_native_small");
                    constant.PromotedrImg = ads.getString("PromotedrImg");
                    constant.PromotedrUrl = ads.getString("PromotedrUrl");
                    constant.appfutur_Url = ads.getString("appfutur_Url");


                    constant.statue = 1;
                }
                catch (JSONException e){
                    e.printStackTrace();
                    constant.statue = 2;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                constant.statue =2;
            }
        });
        request.setShouldCache(false);
        queue.add(request);
    }



}
