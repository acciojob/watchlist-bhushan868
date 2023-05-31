package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    @Autowired
    com.driver.MovieRepository movieRepository;
    public void addMovie(com.driver.Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(com.driver.Director director) {
        movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String movie, String director) {
        return movieRepository.addMovieDirectorPair(movie,director);
    }

    public com.driver.Movie getMovieByName(String name) {

        return movieRepository.getMovieByName(name);
    }

    public com.driver.Director getDirectorByName(String name) {

        return movieRepository.getDirectorByName(name);
    }

    public List<com.driver.Movie> getMoviesByDirectorName(String name)
    {
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String name) {

        return movieRepository.deleteDirectorByName(name);
    }

    public String deleteAllDirectors() {

        return movieRepository.deleteAllDirectors();
    }
}

