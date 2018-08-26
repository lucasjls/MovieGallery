package com.joaolucas.moviegalerysas.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class GetMoviesRepository {

    public static final String API_ROOT = "https://api.themoviedb.org/3";

    @Test
    public void getPopularMoviesSuccessful(){

        String apiUrl = API_ROOT + "/discover/movie?sort_by=popularity.desc&api_key=" + System.getenv("API_KEY");

        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        Assert.assertNotNull(jsonNode);
    }

    @Test(expected = HttpClientErrorException.class)
    public void getPopularMoviesUnauthorized(){

        String apiUrl = API_ROOT + "/discover/movie?sort_by=popularity.desc&api_key=123" ;

        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);
    }

}
