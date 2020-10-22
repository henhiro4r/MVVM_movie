package com.uc.mvvm_week5.util;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Constants {

//    public static final String BASE_URL = "https://api.themoviedb.org/3/";
//    public static final String API_KEY = "fc8a2346ecddee7ca776c1d0f3de2c89";

    @Retention(SOURCE)
    @StringDef
    public @interface BaseSetting {
        String BASE_URL = "https://api.themoviedb.org/3/";
        String API_KEY = "fc8a2346ecddee7ca776c1d0f3de2c89";
        String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500";
        String LANGUAGE = "en-US";
    }

    @Retention(SOURCE)
    @StringDef
    public @interface Type {
        String MOVIES = "movie";
        String TV_SHOWS = "tv";
    }

}
