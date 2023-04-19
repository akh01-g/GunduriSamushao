package com.example.gundurisamushao.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gundurisamushao.model.remote.Brewery;
import com.example.gundurisamushao.model.repository.BreweryRepository;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class HomeViewModel extends ViewModel {

    private BreweryRepository breweryRepository = new BreweryRepository();
    private CompositeDisposable disposables = new CompositeDisposable();
    public MutableLiveData<List<Brewery>> breweryLiveData = new MutableLiveData<>();


    public void getBreweries(){
        disposables.add(
                breweryRepository.getBreweries()
                        .subscribe(breweries -> {
                            breweryLiveData.setValue(breweries);
                        })
        );
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
