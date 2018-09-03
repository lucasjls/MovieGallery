package com.joaolucas.moviegalerysas.repositories.interfaces;

import com.fasterxml.jackson.databind.JsonNode;

public interface MovieRepository {

    JsonNode getPopularMovies();

    JsonNode getMoviesByStringQuery(String query);

}
