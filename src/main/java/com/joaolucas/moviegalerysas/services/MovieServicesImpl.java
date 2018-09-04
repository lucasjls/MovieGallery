package com.joaolucas.moviegalerysas.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaolucas.moviegalerysas.config.logger.LoggerImpl;
import com.joaolucas.moviegalerysas.domain.Movie;
import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.repositories.interfaces.MovieRepository;
import com.joaolucas.moviegalerysas.services.interfaces.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServicesImpl implements MovieServices {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    LoggerImpl logger;

    public MovieServicesImpl(MovieRepository movieRepository, ObjectMapper objectMapper){
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public List<MovieDTO> getPopularMovies(){
        try {
            logger.info("MovieServices: getPopularMovies: ");
            JsonNode popularMovies = movieRepository.getPopularMovies().get("results");

            List<Movie> movies = getMoviesByJsonNode(popularMovies);
            List<MovieDTO> moviesDTO = movies.stream().map(obj -> new MovieDTO(obj)).collect(Collectors.toList());

            return moviesDTO;

        }catch (Exception ex){
            logger.error(String.format("Exception %s", ex.getMessage()));
            return new ArrayList<>();
        }
    }

    private List<Movie> getMoviesByJsonNode(JsonNode jsonNodeMovies) throws IOException {

        List<Movie> movies = new ArrayList<>();
        for (JsonNode movie : jsonNodeMovies){
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
