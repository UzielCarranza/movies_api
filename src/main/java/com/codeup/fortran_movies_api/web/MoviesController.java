package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RequestMapping("/api/movies/")
@RestController
public class MoviesController {
    private final List<Movie> movies = setAllMovies();

    @GetMapping()
    public Movie one() {
        return getAll().get(1);
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable Long id) {
        return movies.stream().filter((movie) -> {
                    return movie.getId() == id;
                }).findFirst()
                .orElse(null);
    }

    @GetMapping("all")
    public List<Movie> getAll() {

        return this.movies;
    }


    @PostMapping
    public void createOne(@RequestBody Movie newMovie) {
        System.out.println(newMovie);
        movies.add(newMovie);


    }

    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesAll) {
        movies.addAll(moviesAll);
    }


    public List<Movie> setAllMovies() {
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie(1, "test", "1995", "someone", "actors", "some genre", "some plot", "5", "");
        Movie movie2 = new Movie(2, "test", "1995", "someone", "actors", "some genre", "some plot", "5", "");
        movies.add(movie1);
        movies.add(movie2);
        return movies;
    }
}
