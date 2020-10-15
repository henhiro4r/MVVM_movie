package com.uc.mvvm_week5.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.MovieResponse;
import com.uc.mvvm_week5.network.ApiEndPoints;
import com.uc.mvvm_week5.network.RetrofitService;
import com.uc.mvvm_week5.util.Constans;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static MovieRepository movieRepository;
    private ApiEndPoints apiEndPoints;
    private static final String TAG = "MovieRepository";

    public MovieRepository(ApiEndPoints apiEndPoints) {
        this.apiEndPoints = apiEndPoints;
    }

    public static MovieRepository getInstance(){
        if (movieRepository == null){
            movieRepository = new MovieRepository(RetrofitService.createService(ApiEndPoints.class));
        }
        return movieRepository;
    }
    public MutableLiveData<List<Movie>> getMovieColection(){
        MutableLiveData<List<Movie>> listMovie = new MutableLiveData<>();
        
        apiEndPoints.getMovies(Constans.API_KEY).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listMovie.postValue(response.body().getResults());
                    }
//                    Log.d(TAG, "onSuccess ");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        
        return listMovie;
    }
}
