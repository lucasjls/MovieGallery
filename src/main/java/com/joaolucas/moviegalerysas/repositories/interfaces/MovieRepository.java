package com.joaolucas.moviegalerysas.repositories.interfaces;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository {

    JsonNode getPopularMovies();

    JsonNode getMoviesByStringQuery(String query);

}
