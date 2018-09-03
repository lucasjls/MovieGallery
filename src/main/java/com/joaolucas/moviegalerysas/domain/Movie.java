package com.joaolucas.moviegalerysas.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.List;

@JsonAutoDetect
public class Movie implements Serializable {

    private String title;
    private String pathPoster;
    private String originalLanguage;
    private List<Integer> generesIds;
    private String overview;
    private Boolean isAdult;

    public Movie(){

    }

    public Movie(String title, String pathPoster, String originalLanguage, List<Integer> generesIds, String overview, Boolean isAdult) {
        this.title = title;
        this.pathPoster = pathPoster;
        this.originalLanguage = originalLanguage;
        this.generesIds = generesIds;
        this.overview = overview;
        this.isAdult = isAdult;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPathPoster() {
        return this.pathPoster;
    }

    public String getOverview() {
        return this.overview;
    }
}
