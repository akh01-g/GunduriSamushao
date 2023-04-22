package com.example.gundurisamushao.model.repository;

import com.example.gundurisamushao.model.remote.brewery.Brewery;
import com.example.gundurisamushao.model.remote.retrofit.RetrofitInstance;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BreweryRepository {

    public Single<List<Brewery>> getBreweries(){
        return RetrofitInstance.getBreweryService().getBreweries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
