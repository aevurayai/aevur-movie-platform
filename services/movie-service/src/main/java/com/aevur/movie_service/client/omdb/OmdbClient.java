package com.aevur.movie_service.client.omdb;

import com.aevur.movie_service.api.response.MovieResponse;
import com.aevur.movie_service.domain.MovieSummary;
import com.aevur.movie_service.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class OmdbClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;


    public Map<String, Object> searchMovies(String keyword) {
        log.info("Searching for movies using keywords "+ keyword);

        try{
            String url = baseURl + "?apiKey=" + apiKey +"&s="+ keyword;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Constants.READ_TIME_OUT)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if( response.statusCode() != 200 ){
                throw new RuntimeException(
                        "HTTP Error: " + response.statusCode()
                );
            }

            String body = response.body();

            if(!body.contains("\"Response\":\"True\"")) {
                throw new RuntimeException("OMDB returned error response");
            }

            return parseSearchResults(body);


        }catch (Exception e){
            throw new RuntimeException("Search failed", e);
        }


    }

    public Map<String, Object> getMovieByTitle(String title) {
        String url = this.baseURl + "?api_key=" + this.apiKey + "&t=" + title + "&plot=full";
        return restTemplate.getForObject(url, Map.class);
    }


    private List<MovieSummary> parseSearchResults(String json) {

        List<MovieSummary> results = new ArrayList<>();

        String[] items = json.split("\\{");

        for (String item : items) {

            if (item.contains("Title")) {

                String title = extract(item, "Title");
                String year = extract(item, "Year");
                String imdbId = extract(item, "imdbID");

                results.add(new MovieSummary(title, year, imdbId));
            }
        }

        return results;
    }

    private String extract(String jsonPart, String key) {

        String pattern = "\"" + key + "\":\"";

        int start = jsonPart.indexOf(pattern);
        if (start == -1) return null;

        start += pattern.length();

        int end = jsonPart.indexOf("\"", start);

        if (end == -1) return null;

        return jsonPart.substring(start, end);
    }


}
