package com.example.gundurisamushao.view.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.gundurisamushao.databinding.FragmentCryptoDetailsBinding;

public class CryptoDetailsFragment extends Fragment {

    private FragmentCryptoDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCryptoDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners(){
        String description = getArguments().getString("description");
        binding.tvDescription.setText(description);
        String name = getArguments().getString("name");
        binding.tvName.setText(name);
        String started_at = getArguments().getString("started_at");
        binding.tvStartedAt.setText(started_at);
        String symbol = getArguments().getString("symbol");
        binding.tvSymbol.setText(symbol);
        binding.btnBack.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(CryptoDetailsFragmentDirections.actionCryptoDetailsFragmentToCryptoApiFragment());
        });

        String website = getArguments().getString("website");
        binding.tvWebsite.setText(website);

        String logo = getArguments().getString("logo");
        Glide.with(binding.imageview)
                .load(logo)
                .into(binding.imageview);



    }
}
