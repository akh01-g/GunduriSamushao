package com.example.gundurisamushao.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gundurisamushao.databinding.FragmentHomeBinding;
import com.example.gundurisamushao.view.BreweryAdapter;
import com.example.gundurisamushao.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private BreweryAdapter breweryAdapter = new BreweryAdapter();
    private HomeViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setObservers();
    }

    private void init(){
        binding.rvBreweries.setAdapter(breweryAdapter);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getBreweries();
    }

    private void setObservers(){
        viewModel.breweryLiveData.observe(getViewLifecycleOwner(), breweries -> {
            breweryAdapter.updateList(breweries);
        });
    }
}
