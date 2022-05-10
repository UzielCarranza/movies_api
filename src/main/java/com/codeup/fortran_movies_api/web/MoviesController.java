package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/movies/")
public class MoviesController {
//    private final List<Movie> movies = setAllMovies();


    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
//        return movies.stream().filter((movie) -> {
//                    return movie.getId() == id;
//                }).findFirst()
//                .orElse(null);
        return moviesRepository.findById(id).orElse(null);
    }

    @GetMapping("all")
    public List<Movie> getAll() {
        return moviesRepository.findAll();
    }

    @GetMapping("search")
    public List<Movie> getByTitle(@RequestParam("title") String title) {
//        Movie movieToReturn = null;
//        for (Movie movie : movies) {
//            if (movie.getTitle().equals(movie)) {
//                movieToReturn = movie;
//            }
//        }
//        return movieToReturn;

        return moviesRepository.findByTitle(title);
    }


    @PostMapping
    public void createOne(@RequestBody Movie newMovie) {
//        System.out.println(newMovie);
//        movies.add(newMovie);
        moviesRepository.save(newMovie);
    }


    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesAll) {
        moviesRepository.saveAll(moviesAll);
    }

//
//    public List<Movie> setAllMovies() {
//        List<Movie> movies = new ArrayList<>();
//        return movies;
//    }
}
