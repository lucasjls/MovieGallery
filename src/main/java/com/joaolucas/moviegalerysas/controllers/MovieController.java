package com.joaolucas.moviegalerysas.controllers;

import com.joaolucas.moviegalerysas.config.interfaces.ILogger;
import com.joaolucas.moviegalerysas.domain.Movie;
import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController("/movies")
public class MovieController {

    private final MovieServices movieServices;

    private ILogger logger;

    @Autowired
    public MovieController(MovieServices movieServices, ILogger logger){
        this.movieServices = movieServices;
        this.logger = logger;
    }

    @GetMapping("/")
    public List<Movie> getAll(){
        logger.info("getPopularMovies: Popular movies returned");
        return movieServices.getPopularMovies();
    }

    @GetMapping("/{name}")
    @ResponseStatus(OK)
    MovieDTO getMovie(@PathVariable String name) throws ClassNotFoundException{
        return movieServices.findByName(name);
    }

}
