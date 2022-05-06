package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @GetMapping
    public Movie one() {
        return new Movie(1, "test", "1995", "someone", "The dude", "idk", "comedy", "some plot", "assaas");
    }
}
