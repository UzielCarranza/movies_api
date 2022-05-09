package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RequestMapping("/api/movies/")
@RestController
public class MoviesController {
    private List<Movie> Movies;

    @GetMapping()
    public Movie one() {
        return getAll().get(1);
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        return Movies.stream().filter((movie) -> {
                    return movie.getId() == id;
                }).findFirst()
                .orElse(null);
    }

    @GetMapping("all")
    public List<Movie> getAll() {
        Movies = new ArrayList<>();
        Movie movie1 = new Movie(1, "test", "1995", "someone", "The dude", "idk", "comedy", "some plot", "assaas");
        Movie movie2 = new Movie(2, "test", "1995", "someone", "The dude", "idk", "comedy", "some plot", "assaas");
        Movies.add(movie1);
        Movies.add(movie2);
        return Movies;
    }
}
