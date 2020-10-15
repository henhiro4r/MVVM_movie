package com.uc.mvvm_week5.network;

import com.uc.mvvm_week5.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoints {
    //path yang di API
    @GET("discover/movie")
    Call<MovieResponse> getMovies(@Query("api_key")String apiKey);

//    @GET("movie/{movie_id}")
//    Call<MovieResponse> getDetailMovie(@Path("movie_id") int movieId, @Query("api_key") String apiKey);
}
