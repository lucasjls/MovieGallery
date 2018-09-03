package com.joaolucas.moviegalerysas.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.joaolucas.moviegalerysas.domain.Movie;

import java.io.Serializable;

@JsonAutoDetect
public class MovieDTO implements Serializable {

    private String title;
    private String pathPoster;
    private String overview;

    public MovieDTO(){

    }

    public MovieDTO(Movie movie){
        this.title = movie.getTitle();
        this.pathPoster = movie.getPathPoster();
        this.overview = movie.getOverview();
    }
}
