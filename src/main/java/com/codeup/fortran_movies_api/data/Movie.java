package com.codeup.fortran_movies_api.data;


import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String year;
    private String directors;
    private String actors;
    private String genre;
    private String plot;
    private String rating;
    private String poster;


    public Movie(int id, String title, String year, String plot, String poster,String rating, String directors, String actors, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.poster = poster;

        this.rating = rating;
        this.directors = directors;
        this.actors = actors;
        this.genre = genre;
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

    public String getDirector() {
        return directors;
    }

    public void setDirector(String director) {
        this.directors = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String  getRating() {
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", directors='" + directors + '\'' +
                ", actors='" + actors + '\'' +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                ", rating='" + rating + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
