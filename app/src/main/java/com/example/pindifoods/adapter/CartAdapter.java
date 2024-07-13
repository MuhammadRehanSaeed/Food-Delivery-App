package com.example.pindifoods.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.pindifoods.R;
import com.example.pindifoods.databinding.CartItemBinding;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<String> cartItems;
    private List<String> cartItemPrice;
    private List<Integer> cartImage;
    private int[] itemQuantities;

    public CartAdapter(List<String> cartItems, List<String> cartItemPrice, List<Integer> cartImage) {
        this.cartItems = cartItems;
        this.cartItemPrice = cartItemPrice;
        this.cartImage = cartImage;
        this.itemQuantities = new int[cartItems.size()];
        for (int i = 0; i < cartItems.size(); i++) {
            itemQuantities[i] = 1;
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(layoutInflater, parent, false);
        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        private final CartItemBinding binding;
        private final ImageButton deletebutton;
        private final ImageButton plusbutton;
        private final ImageButton minusbutton;


        public CartViewHolder(CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.deletebutton = binding.getRoot().findViewById(R.id.deletebutton);
            this.plusbutton = binding.getRoot().findViewById(R.id.plusbutton);
            this.minusbutton = binding.getRoot().findViewById(R.id.minusbutton);

        }

        public void bind(int position) {
            int quantity = itemQuantities[position];
            binding.cartFoodName.setText(cartItems.get(position));
            binding.cartItemPrice.setText(cartItemPrice.get(position));
            binding.cartImage.setImageResource(cartImage.get(position));
            binding.cartItemQuantity.setText(String.valueOf(quantity));
            minusbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decreaseQuantity(position);

                }
            });
            plusbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increaseQuantity(position);
                }
            });


            deletebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getAdapterPosition();
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition);
                    }

                }

            });



        }
        private void decreaseQuantity(int position) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--;
                binding.cartItemQuantity.setText(String.valueOf(itemQuantities[position]));
            }
        }
        private void increaseQuantity(int position) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++;
                binding.cartItemQuantity.setText(String.valueOf(itemQuantities[position]));

            }
        }
        public void deleteItem(int position) {
            cartItems.remove(position);
            cartImage.remove(position);
            cartItemPrice.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
        }

    }

}
