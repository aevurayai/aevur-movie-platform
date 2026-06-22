package com.aevur.movie_service.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateMovieRequest {
    private String title;
    private int year;
    private double rated;
    private String plot;
    private LocalDate releaseDate;
    private LocalTime runtime;
    private String genre;
    private String writer;
    private String director;
    private List<String> actors;
    private String language;
    private String country;
    private List<String> awards;
}
