package com.joaolucas.moviegalerysas.controllers;

import com.joaolucas.moviegalerysas.config.interfaces.ILogger;
import com.joaolucas.moviegalerysas.models.Movie;
import com.joaolucas.moviegalerysas.services.interfaces.IMovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/movies")
public class MovieController {

    private final IMovieServices movieServices;

    private ILogger logger;

    @Autowired
    public MovieController(IMovieServices movieServices, ILogger logger){
        this.movieServices = movieServices;
        this.logger = logger;
    }

    @GetMapping("/")
    public List<Movie> getAll(){
        logger.info("getPopularMovies: Popular movies returned");
        return movieServices.getPopularMovies();
    }

    @GetMapping("/{name}")
    ResponseEntity<?> getMovie(@PathVariable String name){
        System.out.println(name);
        return ResponseEntity.ok(movieServices.findByName(name));
    }

}
