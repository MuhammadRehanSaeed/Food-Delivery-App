package com.example.pindifoods.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pindifoods.MainActivity;
import com.example.pindifoods.R;
import com.example.pindifoods.adapter.CartAdapter;
import com.example.pindifoods.databinding.FragmentCartfragmentBinding;
import com.example.pindifoods.login;
import com.example.pindifoods.payout;

import java.util.ArrayList;
import java.util.Arrays;

public class cartfragment extends Fragment {
    private FragmentCartfragmentBinding binding;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCartfragmentBinding.inflate(inflater, container, false);

        ArrayList<String> cartFoodName = new ArrayList<>(Arrays.asList("Burger", "Burger", "Burger", "Burger", "Burger", "Burger"));
        ArrayList<String> cartItemPrice = new ArrayList<>(Arrays.asList("$5", "$5", "$5", "$5", "$5", "$5"));
        ArrayList<Integer> cartImage = new ArrayList<>(Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu5,
                R.drawable.menu6
        ));

        CartAdapter adapter = new CartAdapter(cartFoodName, cartItemPrice, cartImage);
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.cartRecyclerView.setAdapter(adapter);
        button = binding.getRoot().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the payout Activity
                Intent intent = new Intent(getActivity(), payout.class);
                startActivity(intent);
            }
        });


        return binding.getRoot();
    }

}