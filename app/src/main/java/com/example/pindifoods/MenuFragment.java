package com.example.pindifoods;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pindifoods.adapter.MenuAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.pindifoods.databinding.FragmentMenuBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFragment extends BottomSheetDialogFragment {
    private FragmentMenuBinding binding;
    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentMenuBinding binding = FragmentMenuBinding.inflate(inflater, container, false);
        ArrayList<String> menuFoodName = new ArrayList<>(Arrays.asList("Burger", "Burger", "Burger", "Burger", "Burger", "Burger"));
        ArrayList<String> menuPrice = new ArrayList<>(Arrays.asList("$5", "$5", "$5", "$5", "$5", "$5"));
        ArrayList<Integer> menuImage = new ArrayList<>(Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu5,
                R.drawable.menu6
        ));

        MenuAdapter adapter = new MenuAdapter(menuFoodName,menuPrice,menuImage);
        binding.menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecyclerView.setAdapter(adapter);
        return binding.getRoot();
    }
}