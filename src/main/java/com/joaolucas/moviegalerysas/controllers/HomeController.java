package com.joaolucas.moviegalerysas.controllers;

import com.joaolucas.moviegalerysas.config.Logger;
import com.joaolucas.moviegalerysas.config.interfaces.ILogger;
import com.joaolucas.moviegalerysas.models.Movie;
import com.joaolucas.moviegalerysas.services.interfaces.IMovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    IMovieServices movieServices;

    @Autowired
    ILogger logger;

    public HomeController(IMovieServices movieServices, ILogger logger){
        this.movieServices = movieServices;
        this.logger = logger;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Movie> getPopularMovies(){
        logger.info("getPopularMovies: Popular movies returned");
        return movieServices.getPopularMovies();
    }
}

