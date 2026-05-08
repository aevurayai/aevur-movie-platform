package com.aevur.movie_service.service;

import com.aevur.movie_service.api.request.response.MovieResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetMovieService {
    public MovieResponse getMovieById(Long id) {
        return new MovieResponse();
    }

    public List<MovieResponse> getAllMovies() {
        return new ArrayList<MovieResponse>();
    }

    public MovieResponse searchMovies(String searchBy) {
        return new MovieResponse();
    }

    public MovieResponse getMoviesByGenre() {
        return new MovieResponse();
    }

    public MovieResponse getMoviesByTitle() {
        return new MovieResponse();
    }

    public MovieResponse getMoviesFromOmdb() {
        return new MovieResponse();
    }
}
