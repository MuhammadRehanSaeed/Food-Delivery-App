package com.example.pindifoods.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pindifoods.databinding.BuyAgainItemBinding;
import java.util.ArrayList;

public class BuyAgainAdapter extends RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder> {

    private ArrayList<String> buyAgainFoodName;
    private ArrayList<String> buyAgainFoodPrice;
    private ArrayList<Integer> buyAgainFoodImage;

    public BuyAgainAdapter(ArrayList<String> buyAgainFoodName, ArrayList<String> buyAgainFoodPrice, ArrayList<Integer> buyAgainFoodImage) {
        this.buyAgainFoodName = buyAgainFoodName;
        this.buyAgainFoodPrice = buyAgainFoodPrice;
        this.buyAgainFoodImage = buyAgainFoodImage;
    }

    @NonNull
    @Override
    public BuyAgainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        BuyAgainItemBinding binding = BuyAgainItemBinding.inflate(layoutInflater, parent, false);
        return new BuyAgainViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return buyAgainFoodName.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAgainViewHolder holder, int position) {
        holder.bind(buyAgainFoodName.get(position), buyAgainFoodPrice.get(position), buyAgainFoodImage.get(position));
    }

    class BuyAgainViewHolder extends RecyclerView.ViewHolder {

        private final BuyAgainItemBinding binding;

        public BuyAgainViewHolder(BuyAgainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String foodName, String foodPrice, int foodImage) {
            binding.BuyAgainFoodName.setText(foodName);
            binding.BuyAgainFoodPrice.setText(foodPrice);
            binding.BuyAgainFoodImage.setImageResource(foodImage);
        }
    }
}
