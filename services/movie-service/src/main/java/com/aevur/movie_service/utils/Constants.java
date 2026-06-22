package com.aevur.movie_service.utils;

import java.time.Duration;

public class Constants {

    public final static Duration READ_TIME_OUT = Duration.ofSeconds(10);
    public final static Duration WRITE_TIME_OUT = Duration.ofSeconds(30);
    public static final Duration CONNECTION_TIME_OUT = Duration.ofSeconds(30);
    public final static String API_KEY = "";
    public final static String API_BASE_URL = "http://www.omdbapi.com/";
    public static final String SEARCH_PARAM="&s=";
    public static final String GET_BY_TITLE_PARAM="&t";
    public static final String GET_BY_ID_PARAM="&i";
    public static final String API_KEY_PARAM="?api_key=";

}
