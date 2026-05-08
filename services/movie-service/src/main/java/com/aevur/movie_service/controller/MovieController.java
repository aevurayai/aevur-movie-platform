package com.aevur.movie_service.controller;

import com.aevur.movie_service.api.request.response.MovieResponse;
import com.aevur.movie_service.api.request.response.OmdbMovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final ImportMovieUseCase importMovieUseCase;
    private final SearchMovieUseCase searchMovieUseCase;

    @PostMapping("/import")
    public MovieResopnse importMovie(@RequestParam String title) {
        return MovieResponse.from(importMovieUseCase.execute(title));
    }

    @GetMapping("/search")
    public OmdbMovieResponse search(@RequestParam String title){
        return  searchMovieUseCase.execute(title);
    }


}
