package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/api/movies/")
public class MoviesController {

    private final MoviesRepository moviesRepository;
    private final DirectorsRepository directorsRepository;
    private final GenresRepository genresRepository;
    private final ActorsRepository actorsRepository;

    public MoviesController(MoviesRepository moviesRepository, DirectorsRepository directorsRepository, GenresRepository genresRepository, ActorsRepository actorsRepository) {
        this.moviesRepository = moviesRepository;
        this.directorsRepository = directorsRepository;
        this.genresRepository = genresRepository;
        this.actorsRepository = actorsRepository;
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
    public List<MovieDto> getAll() {
        List<Movie> movieList = moviesRepository.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();
//        MovieDto movieDto = new MovieDto();

        for (Movie movie : movieList) {
            movieDtoList.add(new MovieDto(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getYear(),
                    movie.getPlot(),
                    movie.getPoster(),
                    movie.getRating(),
                    movie.getDirector().getName(),
                    movie.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", "))));
        }
        return movieDtoList;
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
    public void createOne(@RequestBody MovieDto newMovie) {

        Movie movieToAdd = new Movie(
                newMovie.getTitle(),
                newMovie.getYear(),
                newMovie.getPlot(),
                newMovie.getPoster(),
                newMovie.getRating()
        );

        List<Director> director = directorsRepository.findByName(newMovie.getDirector());

        if (director.isEmpty()){
            Director director1 = new Director(newMovie.getDirector());
            movieToAdd.setDirector(directorsRepository.save(director1));
        }
        else {
            movieToAdd.setDirector(director.get(0));
        }
        String[] genres = newMovie.getGenre().split(", ");
        List<Genre> movieGenres = new ArrayList<>();
        for (String genre : genres){
            Genre genreInDn = genresRepository.findAllByName(genre);
            if (genreInDn == null){
                Genre newGenre = new Genre(genre);
                genresRepository.save(newGenre);
            } else {
                movieGenres.add(genreInDn);
            }
        }
        movieToAdd.setGenres(movieGenres);
        moviesRepository.save(movieToAdd);
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
    }

    @GetMapping("search/director")
    public List<Director> getByDirector(@RequestParam("name") String directorName) {

        return directorsRepository.findByName(directorName);
    }

    @GetMapping("search/genres")
    public List<Genre> getByGenre(@RequestParam("genre") String genre) {
        return genresRepository.findByName(genre);
    }

    @GetMapping("search/actors")
    public List<Actors> getByActorName(@RequestParam("name") String name) {
        return actorsRepository.findByName(name);
    }
}
