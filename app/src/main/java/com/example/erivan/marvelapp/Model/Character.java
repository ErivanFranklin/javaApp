package com.example.erivan.marvelapp.Model;

import java.io.Serializable;

public class Character implements Serializable{
    private static final long id = 1L;

    private  String name;
    private  String Poster;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
