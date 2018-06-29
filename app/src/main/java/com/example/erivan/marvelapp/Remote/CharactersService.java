package com.example.erivan.marvelapp.Remote;


import com.example.erivan.marvelapp.Model.Characters;
import retrofit2.Call;
import retrofit2.http.GET;


public interface CharactersService {

    @GET("/")
    Call<Characters>getData();

}
