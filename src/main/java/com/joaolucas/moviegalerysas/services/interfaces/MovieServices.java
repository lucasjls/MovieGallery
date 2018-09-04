package com.joaolucas.moviegalerysas.services.interfaces;

import com.joaolucas.moviegalerysas.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieServices {

    List<MovieDTO> getPopularMovies();

}
