package com.example.springsqlapp.repository;

import com.example.springsqlapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByNameIgnoreCase(String name);

    List<Movie> findAllByRatingAfter(double rating);
}
