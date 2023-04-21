package com.example.gundurisamushao.model.remote.brewery;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface BreweryService {

    @GET("breweries")
    Single<List<Brewery>> getBreweries();
}
