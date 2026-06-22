package com.aevur.movie_service.client.omdb;

import com.aevur.movie_service.domain.Movie;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OmdbMapper {

    public static Movie toMovie(Map<String, Object> results){
        Movie movie = new Movie();

        movie.setTitle((String) results.get("Title"));
        movie.setYear(parseYear((String)results.get("Year")));
        movie.setRated((String) results.get("Rated"));
        movie.setPlot((String) results.get("Plot"));
        movie.setGenre((String) results.get("Genre"));
        movie.setWriter((String) results.get("Writer"));
        movie.setDirector((String) results.get("Director"));
        movie.setLanguage((String) results.get("Language"));
        movie.setCountry((String) results.get("Country"));

        movie.setActors(split((String) results.get("Actors")));
        movie.setAwards(split((String) results.get("Awards")));
        movie.setRuntime(parseRuntime((String)results.get("Runtime")));

        return movie;
    }

    private static int parseYear(String year){
        try{
            return Integer.parseInt(year.split("-")[0]);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    private static Duration parseRuntime(String runtime){
        try{
            String minutes = runtime.replace(" min", "");
            return Duration.ofMinutes(Integer.parseInt(minutes));
        }catch (Exception e){
            return Duration.ZERO;
        }
    }

    private static List<String> split(String value) {
        if (value == null) return List.of();
        return Arrays.asList(value.split(", "));
    }

}
