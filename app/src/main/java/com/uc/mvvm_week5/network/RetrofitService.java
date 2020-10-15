package com.uc.mvvm_week5.network;

import com.uc.mvvm_week5.util.Constans;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;

    // klo yg di dalam <S> hrs sama dengan diluar yaitu S
    public static <S> S createService(Class<S> serviceClass){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constans.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(serviceClass);
    }
}
