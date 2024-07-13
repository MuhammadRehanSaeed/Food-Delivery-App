package com.example.pindifoods.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pindifoods.R;
import com.example.pindifoods.model.PopularItem;

import java.util.List;


public class popularadapter extends RecyclerView.Adapter<popularadapter.ViewHolder> {

    private List<PopularItem> popularItemList;
    private Context context;

    public popularadapter(List<PopularItem> popularItemList, Context context) {
        this.popularItemList = popularItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopularItem item = popularItemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText("$" + item.getPrice());
        holder.itemImage.setImageResource(item.getImageResId());
        holder.addToCartButton.setOnClickListener(v -> {
            Toast.makeText(context, item.getName() + " added to cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return popularItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemName;
        public TextView itemPrice;
        public TextView addToCartButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.food);
            itemName = itemView.findViewById(R.id.foodnamepopular);
            itemPrice = itemView.findViewById(R.id.pricepopular);
            addToCartButton = itemView.findViewById(R.id.addtocartpopular);
        }
    }
}