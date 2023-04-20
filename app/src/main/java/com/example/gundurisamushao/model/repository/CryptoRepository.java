package com.example.gundurisamushao.model.repository;

import android.content.Context;

import com.example.gundurisamushao.model.remote.Crypto;
import com.example.gundurisamushao.model.remote.RetrofitInstance;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CryptoRepository {

    public Single<List<Crypto>> getAllCrypto(){
        return RetrofitInstance.getCryptoService().getAllCrypto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Single<Crypto> getCryptoByID(String coin){
        return RetrofitInstance.getCryptoByIdService().getCryptoByID(coin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
