package com.joaolucas.moviegalerysas.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import com.joaolucas.moviegalerysas.repositories.interfaces.IMovieRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class MovieRepository implements IMovieRepository {

    private String baseUrl = "https://api.themoviedb.org/3";

    public JsonNode getPopularMovies(){
        JsonNode restTemplate = new RestTemplate().getForObject(String.format("%s/discover/movie?sort_by=popularity.desc&api_key=%s", baseUrl, System.getenv("API_KEY")), JsonNode.class);
        return restTemplate;
    }


}
