package com.example.springsqlapp.service;

import com.example.springsqlapp.entity.Movie;
import com.example.springsqlapp.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).orElse(null);
        existingMovie.setName(movie.getName());
        existingMovie.setGenre(movie.getGenre());
        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public Movie getMovieByNameIgnoreCase(String name) {
        return movieRepository.findByNameIgnoreCase(name).orElseThrow(() -> new NoSuchElementException("No person with name: " + name + " exists!"));
    }

    public List<Movie> getAllMoviesByRatingAfter(double rating) {
        return movieRepository.findAllByRatingAfter(rating);
    }
}
