package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorsRepository extends JpaRepository<Actors, Integer> {


    List<Actors> findByName(String name);
}
