package com.example.gundurisamushao.model.remote;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.openbrewerydb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static BreweryService getBreweryService(){
        return getRetrofit().create(BreweryService.class);
    }
}
