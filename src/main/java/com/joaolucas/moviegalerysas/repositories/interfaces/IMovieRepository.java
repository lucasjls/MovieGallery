package com.joaolucas.moviegalerysas.repositories.interfaces;


import com.fasterxml.jackson.databind.JsonNode;

public interface IMovieRepository {
    JsonNode getPopularMovies();
}
