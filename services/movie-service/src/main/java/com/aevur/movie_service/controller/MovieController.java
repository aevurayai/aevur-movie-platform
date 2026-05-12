package com.aevur.movie_service.controller;

import com.aevur.movie_service.api.response.MovieResponse;
import com.aevur.movie_service.api.response.MovieSearchResponse;
import com.aevur.movie_service.api.response.OmdbMovieResponse;
import com.aevur.movie_service.mapper.MovieMapper;
import com.aevur.movie_service.service.GetMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final GetMovieService movieService;
    private final MovieMapper movieMapper;

    @PostMapping("/search")
    public ResponseEntity<List<MovieSearchResponse>> search(@RequestParam String keyword) {
        List<MovieSearchResponse> results = movieService.searchMovies(keyword);
        return ResponseEntity.ok().body(results.stream()
                .map(movieMapper::toSearchResponse)
                .toList()
        );
    }

    @GetMapping("/search")
    public OmdbMovieResponse search(@RequestParam String title) {
        return searchMovieUseCase.execute(title);
    }


}
