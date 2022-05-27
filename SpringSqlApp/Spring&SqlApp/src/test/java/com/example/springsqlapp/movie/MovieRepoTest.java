package com.example.springsqlapp.movie;

import com.example.springsqlapp.entity.Movie;
import com.example.springsqlapp.entity.MovieGenre;
import com.example.springsqlapp.repository.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class MovieRepoTest {
    @Autowired
    private MovieRepository movieRepositoryUnderTest;

    @BeforeEach
    void setUp() {
        System.out.println("We will test our repository's methods!");
    }

    @AfterEach
    void tearDown() {
        movieRepositoryUnderTest.deleteAll();
        System.out.println("Tests done!");
    }

    @Test
    void itShouldFindIfMovieExistsByNameIgnoreCase() {
        //given
        String name = "WonderWomen";
        Movie movie = new Movie(1, "wonderWomen", 12, 3.5, MovieGenre.SF);
        movieRepositoryUnderTest.save(movie);
        //when
        movieRepositoryUnderTest.findByNameIgnoreCase(name);
        //then
        assertThat(movie.getName()).isEqualToIgnoringCase(name);
    }

    @Test
    void itShouldFindIfMoviesWithRatingAfterExist() {
        //given
        Double rating = 3.5;
        Movie movie1 = new Movie(1, "WonderWomen", 12, 4.5, MovieGenre.SF);
        movieRepositoryUnderTest.save(movie1);
        //when
        movieRepositoryUnderTest.findAllByRatingAfter(rating);
        //then
        assertThat(movie1.getRating()).isGreaterThanOrEqualTo(rating);

    }
}
