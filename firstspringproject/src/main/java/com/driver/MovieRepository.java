package com.driver;

import java.util.*;

public class MovieRepository {

    private HashMap<String, com.driver.Movie> movieList=new HashMap<>();
    private   HashMap<String, com.driver.Director> directorList=new HashMap<>();

    private HashMap<String,String> movieDirectorPair= new HashMap<>();

    public String  addMovie(com.driver.Movie movie) {
        String key = movie.getName();
        movieList.put(key,movie);
        return "movie added successfully";
    }

    public String addDirector(com.driver.Director director) {
        String key = director.getName();
        directorList.put(key,director);
        return "director added successfully";
    }

    public String addMovieDirectorPair(String movie, String director) {
        movieDirectorPair.put(movie,director);
        return "Connected them";
    }

    public com.driver.Movie getMovieByName(String name) {
        if(movieList.containsKey(name)){
            return movieList.get(name);
        }
        return null;
    }

    public com.driver.Director getDirectorByName(String name) {
        if(directorList.containsKey(name)){
            return directorList.get(name);
        }
        return null;
    }

    public List<com.driver.Movie> getMoviesByDirectorName(String name) {
        List<com.driver.Movie> movies = new ArrayList<>();
        for(Map.Entry<String ,String> entry : movieDirectorPair.entrySet()){
            if(entry.getValue().equals(name)){
                String movieName = entry.getValue();
                com.driver.Movie movie = movieList.get(movieName);
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<String> findAllMovies() {
        Set<String> allMovieSet = movieList.keySet();
        List<String> allMovies = new ArrayList<>(allMovieSet);
        return allMovies;

    }

    public String deleteDirectorByName(String name) {
        directorList.remove(name);

        for(Map.Entry<String,String> entry : movieDirectorPair.entrySet()){
            if(entry.getValue().equals(name)){
                String movieN = entry.getKey();
                movieList.remove(movieN);
                movieDirectorPair.remove(movieN);
            }
        }
        return "delete director successfully";
    }

    public String deleteAllDirectors() {

        for(String name : directorList.keySet()){
            directorList.remove(name);
            for(Map.Entry<String,String> entry : movieDirectorPair.entrySet()){
                if(entry.getValue().equals(name)){
                    String movieN = entry.getKey();
                    movieList.remove(name);
                    movieDirectorPair.remove(name);
                }
            }
        }
        return "delete all";

    }
}
