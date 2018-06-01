package com.example.erivan.marvelapp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class SearchCharacters {

    private static final String PUBLIC_KEY = "c4277e6f4669e393203ad3424c7eb369";
    private static final String PRIVATE_KEY = "f4d26676265b3b7764a9ebdc0379902d18d50a6a";
    private static final String TIME_STAMP = "27-05-2018";
    private static final String CHARACTERS_URL = "https://gateway.marvel.com:443/v1/public/characters/1011334?";
    private static final String COMBINED_HASH = "9b5351214145b73d4a33f74105d8c2ba";

    String URL;

    public void getAll(){

        this.URL = CHARACTERS_URL + "ts=" + TIME_STAMP + "&apikey=" + PUBLIC_KEY + "&hash=" + COMBINED_HASH;
        Log.e("URL", this.URL);
        AsyncHttpClient client = new AsyncHttpClient();


        client.get(this.URL, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("There", String.valueOf(statusCode));

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                String userJson = "{'age':26,'email':'norman@futurestud.io','isDeveloper':true,'name':'Norman'}";
                Gson gson = new Gson();
//                UserActivity userObject = gson.fromJson(userJson, UserActivity.class);
            }
        });
    }

}
