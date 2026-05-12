package com.aevur.movie_service.client.omdb;

import com.aevur.movie_service.domain.Movie;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OmdbMapper {

    public static Movie toMoive(Map<String, Object> results){
        Movie movie = new Movie();

        movie.setTitle((String) results.get("Title"));
        movie.setYear(parseYear(results.get("Year")));

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
    private static List<String> split(String value){
        try{
            if(value==null){
                return List.of();
            }else{
                return Arrays.asList(value.split(","));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
