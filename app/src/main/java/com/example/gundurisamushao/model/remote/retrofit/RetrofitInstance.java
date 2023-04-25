package com.example.gundurisamushao.model.remote.retrofit;

import com.example.gundurisamushao.model.remote.crypto.CryptoService;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit getCryptoRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.coinpaprika.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static CryptoService getCryptoService(){
        return getCryptoRetrofit().create(CryptoService.class);
    }
    public static CryptoService getCryptoByIdService(){
        return getCryptoRetrofit().create(CryptoService.class);
    }
}
