package com.example.erivan.marvelapp.Util;

public class Constants {

    public static final String URL_TODO = "http://gateway.marvel.com/v1/public/characters?ts=27-05-2018&limit=10&apikey=c4277e6f4669e393203ad3424c7eb369&hash=9b5351214145b73d4a33f74105d8c2ba";
    public static  final String PORTRAIT_SMALL = "/portrait_small.";
    public static  final String PORTRAIT_MEDIUM = "/portrait_medium.";
    public static  final String PORTRAIT_XLARGE = "/portrait_xlarge.";
    public static  final String PORTRAIT_FANTASTIC= "/portrait_fantastic.";
    public static  final String PORTRAIT_UCANNY = "/portrait_uncanny.";
    public static  final String PORTRAIT_INCREDIBLE = "/portrait_incredible.";

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";
    private static final String API_KEY = "c4277e6f4669e393203ad3424c7eb369";
    private static final String HASH = "9b5351214145b73d4a33f74105d8c2ba";
    private String ID = "";
    private String URL = "";

    public String Constants(String request, String id, String timestamp, String limit) {
        if (id != ""){
            ID = "/" + id;
        }
        URL = BASE_URL + request + ID + "?ts=" + timestamp + "&limit=" + limit + "&apikey=" + API_KEY + "&hash=" + HASH;
        return URL;
    }
}
