package com.example.gundurisamushao.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.gundurisamushao.databinding.FragmentCryptoApiBinding;
import com.example.gundurisamushao.model.remote.crypto.Crypto;
import com.example.gundurisamushao.view.adapter.CryptoAdapter;
import com.example.gundurisamushao.viewmodel.CryptoViewModel;



public class CryptoApiFragment extends Fragment {

    private FragmentCryptoApiBinding binding;
    private CryptoViewModel viewModel = new CryptoViewModel();
    private CryptoAdapter cryptoAdapter = new CryptoAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCryptoApiBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setObservers();
        setListeners();
    }

    private void setListeners(){
        cryptoAdapter.setOnItemClickListener(new CryptoAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(Crypto crypto) {
                String coin = crypto.idn;
                viewModel.getCryptoByID(coin);

            }
        });
    }
    private void init(){
        viewModel = new ViewModelProvider(this).get(CryptoViewModel.class);
        binding.rvCryptos.setAdapter(cryptoAdapter);
        viewModel.getCrypto();
    }
    private void setObservers(){
        viewModel.cryptoLiveData.observe(getViewLifecycleOwner(), cryptos -> {
            cryptoAdapter.updateList(cryptos);
        });

        viewModel.cryptoByIDLiveData.observe(getViewLifecycleOwner(), crypto1 -> {
            Navigation.findNavController(binding.getRoot()).navigate(CryptoApiFragmentDirections.actionCryptoApiFragmentToCryptoDetailsFragment(
                    crypto1.description, crypto1.name, String.valueOf(crypto1.started_at), crypto1.symbol, crypto1.logo, crypto1.links.website.get(0)
            ));

        });
    }
}
