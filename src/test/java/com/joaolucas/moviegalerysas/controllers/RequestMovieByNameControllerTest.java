package com.joaolucas.moviegalerysas.controllers;

import com.joaolucas.moviegalerysas.MovieGalleryApplication;
import com.joaolucas.moviegalerysas.dto.MovieDTO;
import com.joaolucas.moviegalerysas.services.MovieServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = MovieGalleryApplication.class)
@WebAppConfiguration
public class RequestMovieByNameControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private MovieServices movieServices;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void whenMovieIsFoundShouldReturn200StatusCode() throws Exception{

        String movieName = "Avengers";
        when(movieServices.findByName(any(String.class))).thenReturn(getMovie());

        mockMvc.perform(get("/movies").param("name","Avanger")).andExpect(status().isOk());

    }

    private Optional<MovieDTO> getMovie() {
        return Optional.of(new MovieDTO());
    }

}
