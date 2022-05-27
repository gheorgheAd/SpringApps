package com.example.springsqlapp.controller;

import com.example.springsqlapp.entity.Movie;
import com.example.springsqlapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/updateMovie")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }


    @GetMapping("/movie_name/{name}")
    public Movie getMovieByNameIgnoreCase(@PathVariable String name) {
        return movieService.getMovieByNameIgnoreCase(name);
    }


    @GetMapping("/rating_after/{rating}")
    public List<Movie> getAllMoviesByRatingAfter(@PathVariable double rating) {
        return movieService.getAllMoviesByRatingAfter(rating);
    }
}
