package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/movies/")
public class MoviesController {

    private final MoviesRepository moviesRepository;
    private final DirectorsRepository directorsRepository;
    private final GenresRepository genresRepository;

    public MoviesController(MoviesRepository moviesRepository, DirectorsRepository directorsRepository, GenresRepository genresRepository) {
        this.moviesRepository = moviesRepository;
        this.directorsRepository = directorsRepository;
        this.genresRepository = genresRepository;
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

        return moviesRepository.findByTitle(title);
    }


    @GetMapping("search/year")
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear) {
        return moviesRepository.findByYearRange(startYear, endYear);
    }

    @PostMapping
    public void createOne(@RequestBody Movie newMovie) {

        moviesRepository.save(newMovie);
    }


    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesAll) {
        moviesRepository.saveAll(moviesAll);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id, HttpServletResponse response) throws Exception {
        try {

            moviesRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie with ID: " + id + " exists within the database");

        }
//        try {
//
//            moviesRepository.deleteById(id);
//            } else {
//                throw new SecondException();
//            }
//        } catch (Exception e) {
//            throw e;
//        }
    }

    @GetMapping("search/director")
    public List<Director> getByDirector(@RequestParam("name") String directorName){
        List<Director> directors =  directorsRepository.findByName(directorName);

        return directors;
    }

    @GetMapping("search/genres")
    public List<Genre> getByGenre(@RequestParam("genre") String genre) {
        List<Genre> genres = genresRepository.findByName(genre);
        return genres;
    }
}
