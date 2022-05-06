package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class MoviesController {


    @RequestMapping("/api/movie")
    @GetMapping
    public Movie one() {
        return new Movie(1, "test", "1995", "someone", "The dude", "idk", "comedy", "some plot", "assaas");
    }


    @RequestMapping("/api/movies")
    @GetMapping
    public List<Movie> getAll() {
        List<Movie> Movies = new ArrayList<>();
        Movie movie1 = new Movie(1, "test", "1995", "someone", "The dude", "idk", "comedy", "some plot", "assaas");
        Movie movie2 = new Movie(1, "test", "1995", "someone", "The dude", "idk", "comedy", "some plot", "assaas");
        Movies.add(movie1);
        Movies.add(movie2);
        return Movies;
    }


}
