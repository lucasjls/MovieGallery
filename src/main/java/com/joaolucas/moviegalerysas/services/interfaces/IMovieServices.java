package com.joaolucas.moviegalerysas.services.interfaces;

import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.domain.Movie;

import java.util.ArrayList;
import java.util.Optional;

public interface IMovieServices {

    ArrayList<Movie> getPopularMovies();

    MovieDTO findByName(String name);
}
