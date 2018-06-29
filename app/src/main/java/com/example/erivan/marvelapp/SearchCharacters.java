package com.example.erivan.marvelapp;

import com.example.erivan.marvelapp.Remote.Access;
import com.example.erivan.marvelapp.Remote.CharactersService;

public class SearchCharacters{

    private static final String PUBLIC_KEY = "c4277e6f4669e393203ad3424c7eb369";
    private static final String PRIVATE_KEY = "f4d26676265b3b7764a9ebdc0379902d18d50a6a";
    private static final String TIME_STAMP = "27-05-2018";
    private static final String CHARACTERS_URL = "https://gateway.marvel.com:443/v1/public/characters/1011334?";
    private static final String COMBINED_HASH = "9b5351214145b73d4a33f74105d8c2ba";


    public static CharactersService getCharactersService(){
        String BASE_URL;
        BASE_URL = CHARACTERS_URL + "ts=" + TIME_STAMP + "&apikey=" + PUBLIC_KEY + "&hash=" + COMBINED_HASH;
        return Access.getCharacters(BASE_URL).create(CharactersService.class);
    }

}
