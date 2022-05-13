package com.codeup.fortran_movies_api.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String year;

    @ManyToOne
    @JsonIgnoreProperties("directedMovies")
    private Director director;
    private String plot;
    private String rating;
    private String poster;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("movies")
    @JoinTable(name = "movie_genre",
            joinColumns =
            @JoinColumn(name = "movie_id"),
            inverseJoinColumns =
            @JoinColumn(name = "genre_id"))
    private List<Genre> genres;


    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties("movies")
    private List<Actors> actors;

//    public Movie(String title, String year, String plot, String poster, String rating) {
//    }

    public Movie(String title, String year, String plot, String poster, String rating) {
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.poster = poster;
        this.rating= rating;

    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public Movie(int id, String title, String year, String plot, String poster, String rating /*String directors,*/ /*String actors, String genre*/) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.poster = poster;
        this.rating = rating;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Movie() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    public List<Genre> getGenres() {
        return genres;
    }

    //
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", director=" + director.getName() +
                ", plot='" + plot + '\'' +
                ", rating='" + rating + '\'' +
                ", poster='" + poster + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
