package com.aevur.movie_service.persistence.mapper;

import com.aevur.movie_service.domain.Movie;
import com.aevur.movie_service.persistence.entity.MovieEntity;

public class MovieEntityMapper {

    public Movie toMovie(MovieEntity movieEntity) {

        Movie movie = new Movie();
        movie.setId(movieEntity.getId());
        movie.setTitle(movieEntity.getTitle());
        movie.setYear(movieEntity.getYear());
        movie.setRated(movieEntity.getRated());
        movie.setPlot(movieEntity.getPlot());
        movie.setReleaseDate(movieEntity.getReleaseDate());
        movie.setRuntime(movieEntity.getRuntime());
        movie.setGenre(movieEntity.getGenre());
        movie.setWriter(movieEntity.getWriter());
        movie.setDirector(movieEntity.getDirector());
        movie.setActors(movieEntity.getActors());
        movie.setLanguage(movieEntity.getLanguage());
        movie.setCountry(movieEntity.getCountry());
        movie.setAwards(movieEntity.getAwards());

        return movie;
    }

    public MovieEntity toMovieEntity(Movie movie) {

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(movie.getId());
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setYear(movie.getYear());
        movieEntity.setRated(movie.getRated());
        movieEntity.setPlot(movie.getPlot());
        movieEntity.setReleaseDate(movie.getReleaseDate());
        movieEntity.setRuntime(movie.getRuntime());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setWriter(movie.getWriter());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setActors(movie.getActors());
        movieEntity.setLanguage(movie.getLanguage());
        movieEntity.setCountry(movie.getCountry());
        movieEntity.setAwards(movie.getAwards());

        return movieEntity;
    }
}
