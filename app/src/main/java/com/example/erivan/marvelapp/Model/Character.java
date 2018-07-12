package com.example.erivan.marvelapp.Model;

import java.io.Serializable;

public class Character implements Serializable{
    private static final long id = 1L;

    private  String name;
    private  String path;
    private  String extension;
    private  String Poster;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }

//    public String getExtension() {
//        return extension;
//    }
//
//    public void setExtension(String extension) {
//        this.extension = extension;
//    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
