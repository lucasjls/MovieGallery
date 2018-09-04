package com.joaolucas.moviegalerysas.services;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaolucas.moviegalerysas.repositories.interfaces.MovieRepository;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieServicesTests {

    @MockBean
    MovieRepository movieRepository;

    @Test
    public void getPopularMoviesSuccessful(){

        ObjectCodec mapper = new ObjectMapper();

        when(movieRepository.getPopularMovies()).thenReturn(((ObjectMapper) mapper).createArrayNode());

    }

    @Test(expected = Exception.class)
    public void getPopularMoviesUnsuccessful(){

    }

}
