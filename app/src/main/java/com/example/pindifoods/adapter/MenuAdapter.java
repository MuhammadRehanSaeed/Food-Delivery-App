package com.example.pindifoods.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pindifoods.databinding.MenuItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<String> menuItems = new ArrayList<>();
    private List<String> menuItemPrice = new ArrayList<>();
    private List<Integer> menuImage = new ArrayList<>();

    public MenuAdapter(ArrayList<String> menuFoodName, ArrayList<String> menuItemPrice, ArrayList<Integer> menuImage) {
        this.menuItems = menuFoodName;
        this.menuItemPrice = menuItemPrice;
        this.menuImage = menuImage;
    }


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MenuItemBinding binding = MenuItemBinding.inflate(inflater, parent, false);
        return new MenuViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(position);


    }

    @Override
    public int getItemCount() {
        int size = menuItems.size();
        return size;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private MenuItemBinding binding;

        public MenuViewHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position) {
            binding.menuFoodName.setText(menuItems.get(position));
            binding.menuPrice.setText(menuItemPrice.get(position));
            binding.menuImage.setImageResource(menuImage.get(position));
        }
    }
}
