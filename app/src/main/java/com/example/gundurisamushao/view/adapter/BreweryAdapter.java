package com.example.gundurisamushao.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gundurisamushao.databinding.ItemBreweryBinding;
import com.example.gundurisamushao.model.remote.brewery.Brewery;

import java.util.ArrayList;
import java.util.List;


public class BreweryAdapter extends RecyclerView.Adapter<BreweryAdapter.BreweryViewHolder> {

    List<Brewery> breweries = new ArrayList<>();

    public void updateList(List<Brewery> newList){
        BreweryDiffCallback callback = new BreweryDiffCallback(breweries, newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);
        breweries = newList;
        diffResult.dispatchUpdatesTo(this);
    }
    @NonNull
    @Override
    public BreweryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BreweryViewHolder(
                ItemBreweryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BreweryViewHolder holder, int position) {
        holder.bind(breweries.get(position));
    }

    @Override
    public int getItemCount() {
        return breweries.size();
    }

    public class BreweryViewHolder extends RecyclerView.ViewHolder {
        private ItemBreweryBinding binding;
        public BreweryViewHolder(ItemBreweryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Brewery brewery){
            binding.tvBreweryName.setText(brewery.name);
            binding.tvBreweryType.setText(brewery.brewery_type);
            binding.tvBreweryAddress.setText(brewery.address_1);
            binding.tvCountry.setText(brewery.country);
            binding.tvCity.setText(brewery.city);
            binding.tvPhone.setText(String.valueOf(brewery.phone));
            binding.tvWebsite.setText(brewery.website_url);
        }
    }

    public class BreweryDiffCallback extends DiffUtil.Callback{

        public List<Brewery> oldList;
        public List<Brewery> newList;

        public BreweryDiffCallback(List<Brewery> oldList, List<Brewery> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Brewery oldBrewery = oldList.get(oldItemPosition);
            Brewery newBrewery = newList.get(newItemPosition);
            return oldBrewery.id == newBrewery.id;
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            Brewery oldBrewery = oldList.get(oldItemPosition);
            Brewery newBrewery = newList.get(newItemPosition);
            return oldBrewery.id == newBrewery.id&&
                    oldBrewery.name.equals(newBrewery.name)&&
                    oldBrewery.brewery_type.equals(newBrewery.brewery_type)&&
                    oldBrewery.address_1.equals(newBrewery.address_1)&&
                    oldBrewery.country.equals(newBrewery.country)&&
                    oldBrewery.city.equals(newBrewery.city)&&
                    oldBrewery.phone == newBrewery.phone&&
                    oldBrewery.website_url.equals(newBrewery.website_url);
        }
    }
}
