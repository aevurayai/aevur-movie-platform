package com.aevur.movie_service.service;

import com.aevur.movie_service.client.omdb.OmdbClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OmdbService {
    private final OmdbClient omdbClient;

    public List<String> searchTitle(String keyword ){

        Map<String,Object> response = omdbClient.searchMovies(keyword);

        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

    }
}
