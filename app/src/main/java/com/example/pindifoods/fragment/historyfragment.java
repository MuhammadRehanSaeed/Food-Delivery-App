package com.example.pindifoods.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pindifoods.R;
import com.example.pindifoods.adapter.BuyAgainAdapter;
import com.example.pindifoods.databinding.FragmentHistoryfragmentBinding;
import java.util.ArrayList;

public class historyfragment extends Fragment {

    private FragmentHistoryfragmentBinding binding;
    private BuyAgainAdapter buyAgainAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHistoryfragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        ArrayList<String> buyAgainFoodName = new ArrayList<>();
        buyAgainFoodName.add("Food1");
        buyAgainFoodName.add("Food2");
        buyAgainFoodName.add("Food3");

        ArrayList<Integer> buyAgainFoodImage = new ArrayList<>();
        buyAgainFoodImage.add(R.drawable.menu3);
        buyAgainFoodImage.add(R.drawable.menu4);
        buyAgainFoodImage.add(R.drawable.menu5);

        ArrayList<String> buyAgainFoodPrice = new ArrayList<>();
        // Add corresponding prices here if necessary
        buyAgainFoodPrice.add("$10");
        buyAgainFoodPrice.add("$20");
        buyAgainFoodPrice.add("$30");

        buyAgainAdapter = new BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage);
        binding.BuyAgainRecyclerView.setAdapter(buyAgainAdapter);
        binding.BuyAgainRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}
