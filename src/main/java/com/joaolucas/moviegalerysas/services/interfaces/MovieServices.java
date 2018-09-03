package com.joaolucas.moviegalerysas.services.interfaces;

import com.joaolucas.moviegalerysas.dto.MovieDTO;

import java.util.List;

public interface MovieServices {

    List<MovieDTO> getPopularMovies();

}
