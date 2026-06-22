package com.aevur.movie_service.domain;

public record MovieSummary(
        String title,
        String year,
        String imdbId
) {}