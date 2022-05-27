package com.example.springsqlapp.movie;

import com.example.springsqlapp.entity.Movie;
import com.example.springsqlapp.entity.MovieGenre;
import com.example.springsqlapp.repository.MovieRepository;
import com.example.springsqlapp.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;
    //    private AutoCloseable autoCloseable;
    private MovieService movieServiceUnderTest;

    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
        movieServiceUnderTest = new MovieService(movieRepository);
        System.out.println("We will test our repository's methods!");
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void canAddMovie() {
        //given
        Movie movie = new Movie(1, "wonderWomen", 12, 3.5, MovieGenre.SF);
        //when
        movieServiceUnderTest.addMovie(movie);
        //then
        ArgumentCaptor<Movie> movieArgumentCaptor = ArgumentCaptor.forClass(Movie.class);
        verify(movieRepository).save(movieArgumentCaptor.capture());
        Movie capturedMovie = movieArgumentCaptor.getValue();
        assertThat(capturedMovie).isEqualTo(movie);
    }

    @Test
    void canGetAllMovies() {
        //when
        movieServiceUnderTest.getAllMovies();
        //then
        verify(movieRepository).findAll();
    }

    @Test
    void canGetMovieById() {
        //given
        Movie movie = new Movie(1, "wonderWomen", 12, 3.5, MovieGenre.SF);
        //when
        movieServiceUnderTest.getMovieById(movie.getId());
        //then
        verify(movieRepository).findById(1);
    }

    @Test
    void canDeleteMovie() {
        //given
        Movie movie = new Movie(1, "wonderWomen", 12, 3.5, MovieGenre.SF);
        //when
        movieServiceUnderTest.deleteMovie(movie.getId());
        //then
        assertThat(movieServiceUnderTest.getMovieById(movie.getId())).isNull();
    }
}