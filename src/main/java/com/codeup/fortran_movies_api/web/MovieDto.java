package com.codeup.fortran_movies_api.web;

public class MovieDto {

    private int id;
    private String title;
    private String year;
    private String plot;
    private String poster;
    private String rating;
    private String director;
    private String genre;
//    private String actors;


    public MovieDto(int id, String title, String year, String plot, String poster, String rating, String director, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;


        this.plot = plot;
        this.poster = poster;
        this.rating = rating;
        this.director = director;
        this.genre = genre;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

//    public String getActors() {
//        return actors;
//    }
//
//    public void setActors(String actors) {
//        this.actors = actors;
//    }
}
