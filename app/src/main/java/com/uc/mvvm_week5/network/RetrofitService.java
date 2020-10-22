package com.uc.mvvm_week5.network;

import com.uc.mvvm_week5.model.CastResponse;
import com.uc.mvvm_week5.model.GenreResponse;
import com.uc.mvvm_week5.model.MovieResponse;
import com.uc.mvvm_week5.model.TvShowResponse;
import com.uc.mvvm_week5.util.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
//    private static Retrofit retrofit;
//
//    // klo yg di dalam <S> hrs sama dengan diluar yaitu S
//    public static <S> S createService(Class<S> serviceClass){
//        if (retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(Constans.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit.create(serviceClass);
//    }

    private ApiEndPoints api;
    private static RetrofitService service;
    private static String TAG = "RetrofitService";


    private RetrofitService() {
        api = new Retrofit.Builder()
                    .baseUrl(Constants.BaseSetting.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiEndPoints.class);
    }
    public static RetrofitService getInstance(){
        if (service == null){
            service = new RetrofitService();
        }
        return service;
    }
    public Call<MovieResponse> getMovies(){
        return api.getMovies (Constants.BaseSetting.API_KEY, Constants.BaseSetting.LANGUAGE);
    }
    public Call<TvShowResponse> getTvShows() {
        return api.getTvShows(Constants.BaseSetting.API_KEY, Constants.BaseSetting.LANGUAGE);
    }
    public Call<GenreResponse> getGenres(String type, int id) {
        return api.getGenres(type, id, Constants.BaseSetting.API_KEY);
    }

    public Call<CastResponse> getCasts(String type, int id) {
        return api.getCasts(type, id, Constants.BaseSetting.API_KEY);
    }
//    public Call<TvShowResponse> getTvShows() {
//        return api.getTvShows(Constants.API_KEY, Constants.BaseSetting.LANGUAGE);
//    }
}
