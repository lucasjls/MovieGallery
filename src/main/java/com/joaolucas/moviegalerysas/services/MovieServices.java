package com.joaolucas.moviegalerysas.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaolucas.moviegalerysas.config.interfaces.ILogger;
import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.models.Movie;
import com.joaolucas.moviegalerysas.repositories.interfaces.IMovieRepository;
import com.joaolucas.moviegalerysas.services.interfaces.IMovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServices implements IMovieServices {

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ILogger logger;

    public MovieServices(IMovieRepository movieRepository, ObjectMapper objectMapper, ILogger logger){
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
        this.logger = logger;
    }

    public ArrayList<Movie> getPopularMovies(){
        try {
            logger.info("MovieServices: getPopularMovies: ");
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            JsonNode popularMovies = movieRepository.getPopularMovies();
            JsonNode jsonMovies = popularMovies.get("results");

            return getMoviesFromJsonNode(jsonMovies);

        }catch (Exception ex){
            logger.error(String.format("Exception %s", ex.getMessage()));
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<MovieDTO> findByName(String name) {
        return null;
    }

    private ArrayList<Movie> getMoviesFromJsonNode(JsonNode jsonMovies) throws IOException {

        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (JsonNode movie : jsonMovies){
            String title = movie.get("title").toString();
            String pathPoster = movie.get("poster_path").toString();
            String originalLanguage = movie.get("original_language").toString();

            List<Integer> generesIds =  objectMapper.readerFor(List.class).readValue(movie.get("genre_ids").toString());
            String overview = movie.get("overview").toString();
            Boolean isAdult = Boolean.valueOf(movie.get("adult").toString());

            movies.add(new Movie(title, pathPoster, originalLanguage, generesIds, overview, isAdult));
        }

        return movies;
    }

}