package com.aevur.movie_service.client.omdb;

import com.aevur.movie_service.api.response.MovieResponse;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class OmdbClient {

    private final RestTemplate restTemplate;
    private final String apiKey = "";
    private final String baseURl = "http://www.omdbapi.com/";

    public OmdbClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    SEARCH_MOVIES

    private Map<String, Object> searchMovies(String keyword){
        String url = this.baseURl + "?api_key=" + this.apiKey + "&s=" + keyword ;
        return restTemplate.getForObject(url, Map.class);
    }

    private Map<String, Object> getMovieByTitle(String title){
        String url = this.baseURl + "?api_key=" + this.apiKey + "&t=" + title + "&plot=full";
        return restTemplate.getForObject(url, Map.class);
    }

}
