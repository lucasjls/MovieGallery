package com.joaolucas.moviegalerysas.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import com.joaolucas.moviegalerysas.config.logger.LoggerImpl;
import com.joaolucas.moviegalerysas.repositories.interfaces.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private static final String baseUrl = "https://api.themoviedb.org/3";

    @Autowired
    LoggerImpl logger;

    @Value("${API_KEY}")
    private String API_KEY;

    public JsonNode getPopularMovies(){
        logger.info("MovieRepository: getPopularMovies: ");
        return new RestTemplate().getForObject(String.format("%s/discover/movie?sort_by=popularity.desc&api_key=%s", baseUrl, API_KEY), JsonNode.class);
    }

    public JsonNode getMoviesByStringQuery(String query){
        logger.info("MovieRepository: getMoviesByStringQuery: ");
        return new RestTemplate().getForObject(String.format("%s/discover/movie?movie?query=%s&api_key=%s", baseUrl, query, API_KEY), JsonNode.class);
    }


}
