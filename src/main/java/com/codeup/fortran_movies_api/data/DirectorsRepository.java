package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorsRepository extends JpaRepository<Director, Integer> {


    //    @Query(nativeQuery = true,
//            value = "SELECT * FROM movies WHERE movies.director_id IN ( SELECT director_id FROM directors d WHERE d.name = ?);")
//    List<Object[]> findAllByDirectorMovies(String name);
    List<Director> findAllByDirectorMovies(String name);

}
