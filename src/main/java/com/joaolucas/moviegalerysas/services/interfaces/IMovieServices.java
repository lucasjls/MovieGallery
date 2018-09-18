package com.joaolucas.moviegalerysas.services.interfaces;

import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.models.Movie;

import java.util.ArrayList;
import java.util.Optional;

public interface IMovieServices {

    ArrayList<Movie> getPopularMovies();

    Optional<MovieDTO> findByName(String name);
}
