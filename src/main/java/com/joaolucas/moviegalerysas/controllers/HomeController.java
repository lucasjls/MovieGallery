package com.joaolucas.moviegalerysas.controllers;

import com.joaolucas.moviegalerysas.config.Logger;
import com.joaolucas.moviegalerysas.models.Movie;
import com.joaolucas.moviegalerysas.services.MovieServices;
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
    MovieServices movieServices;

    @Autowired
    Logger logger;

    public HomeController(MovieServices movieServices){
        this.movieServices = movieServices;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Movie> getPopularMovies(){

        return movieServices.getPopularMovies();
    }
}

