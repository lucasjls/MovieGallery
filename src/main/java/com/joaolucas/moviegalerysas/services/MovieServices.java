package com.joaolucas.moviegalerysas.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaolucas.moviegalerysas.models.Movie;
import com.joaolucas.moviegalerysas.repositories.MovieRepository;
import com.joaolucas.moviegalerysas.services.interfaces.IMovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServices implements IMovieServices {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ObjectMapper objectMapper;

    public MovieServices(MovieRepository movieRepository, ObjectMapper objectMapper){
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
    }

    public ArrayList<Movie> getPopularMovies(){
        try {
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            JsonNode popularMovies = movieRepository.getPopularMovies();
            JsonNode jsonMovies = popularMovies.get("results");

            return getMoviesFromJsonNode(jsonMovies);

        }catch (Exception ex){

            //Logar exeption
            return null;
        }
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
