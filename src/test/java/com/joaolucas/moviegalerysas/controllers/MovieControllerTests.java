package com.joaolucas.moviegalerysas.controllers;

import com.joaolucas.moviegalerysas.domain.Movie;
import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.services.interfaces.MovieServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MovieServices movieServices;

    @Test
    public void ShouldFindPopularMoviesAndStatusCodeOk() throws Exception {
        MovieDTO movieDTO = new MovieDTO(new Movie("Titulo", "pathPoster", "originalLanguage",  new ArrayList<>(), "overview", false));
        ArrayList mockReturn = new ArrayList<MovieDTO>();
        mockReturn.add(movieDTO);

        given(this.movieServices.getPopularMovies()).willReturn(mockReturn);

        this.mockMvc
                .perform(get("/popularmovies"))
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldReturnEmptyListAndStatusCodeOk() throws Exception {
        given(this.movieServices.getPopularMovies()).willReturn(new ArrayList<>());

        this.mockMvc
                .perform(get("/popularmovies"))
                .andExpect(status().isOk());
    }

}
