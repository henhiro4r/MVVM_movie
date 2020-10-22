package com.uc.mvvm_week5.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.mvvm_week5.model.Cast;
import com.uc.mvvm_week5.model.CastResponse;
import com.uc.mvvm_week5.model.Genre;
import com.uc.mvvm_week5.model.GenreResponse;
import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.MovieResponse;
import com.uc.mvvm_week5.model.TvShow;
import com.uc.mvvm_week5.model.TvShowResponse;
import com.uc.mvvm_week5.network.RetrofitService;
import com.uc.mvvm_week5.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowRepository {
    private static TvShowRepository tvShowRepository;
    private RetrofitService service;
    private static final String TAG = "TvShowRepository";

    private TvShowRepository() {
        service = RetrofitService.getInstance();
    }

    public static TvShowRepository getInstance(){
        if (tvShowRepository == null){
            tvShowRepository = new TvShowRepository();
        }
        return tvShowRepository;
    }
    public MutableLiveData<List<TvShow>> getTvShowCollection(){
        MutableLiveData<List<TvShow>> listShow = new MutableLiveData<>();

        service.getTvShows().enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listShow.postValue(response.body().getResults());
                    }
                    Log.d(TAG, "onSuccess ");
                }
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listShow;
   }
    public MutableLiveData<List<Genre>> getGenres(int id) {
        MutableLiveData<List<Genre>> listGenres = new MutableLiveData<>();

        service.getGenres(Constants.Type.TV_SHOWS, id).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getGenres().size());
                        listGenres.postValue(response.body().getGenres());
                    }
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listGenres;
    }

    public MutableLiveData<List<Cast>> getCasts(int id) {
        MutableLiveData<List<Cast>> listCasts = new MutableLiveData<>();

        service.getCasts(Constants.Type.TV_SHOWS, id).enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(Call<CastResponse> call, Response<CastResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getCast().size());
                        listCasts.postValue(response.body().getCast());
                    }
                }
            }

            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listCasts;
    }
}
