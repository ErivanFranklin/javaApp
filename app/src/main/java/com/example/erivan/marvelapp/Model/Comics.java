package com.example.erivan.marvelapp.Model;

import java.io.Serializable;

public class Comics implements Serializable {
    private static final long id = 1L;

    private  String title;
    private  String variantDescription;
    private  String format;
    private  String Poster;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVariantDescription() {
        return this.variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
