package com.uc.mvvm_week5.network;

import com.uc.mvvm_week5.model.CastResponse;
import com.uc.mvvm_week5.model.GenreResponse;
import com.uc.mvvm_week5.model.MovieResponse;
import com.uc.mvvm_week5.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoints {
    //path yang di API
//    @GET("discover/movie")
//    Call<MovieResponse> getMovies(@Query("api_key")String apiKey);

    @GET("discover/movie") // get movies data
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey, @Query("language") String lang);

    @GET("discover/tv") // get tvShows data
    Call<TvShowResponse> getTvShows(@Query("api_key") String apiKey, @Query("language") String lang);

    @GET("{type}/{id}") // get details (if needed) and genres of specific movie / tv shows
    Call<GenreResponse> getGenres(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);

    @GET("{type}/{id}/credits") // get casts of specific movie / tv shows
    Call<CastResponse> getCasts(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);

//    @GET("movie/{movie_id}")
//    Call<MovieResponse> getDetailMovie(@Path("movie_id") int movieId, @Query("api_key") String apiKey);


}
