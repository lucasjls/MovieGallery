package com.joaolucas.moviegalerysas.controllers;

import com.joaolucas.moviegalerysas.config.logger.interfaces.Logger;
import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.services.interfaces.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/popularmovies")
public class MovieController {

    @Autowired
    private MovieServices movieServices;

    @Autowired
    private Logger logger;

    public MovieController(MovieServices movieServices, Logger logger){
        this.movieServices = movieServices;
        this.logger = logger;
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> findAll(){
        logger.info("MovieController: findAll: filmes sendo buscados ");
        List<MovieDTO> movies = movieServices.getPopularMovies();

        if(movies.isEmpty()){
            logger.info("MovieController: findAll: filmes não encontrados");
        }

        return ResponseEntity.ok().body(movies);
    }

}
