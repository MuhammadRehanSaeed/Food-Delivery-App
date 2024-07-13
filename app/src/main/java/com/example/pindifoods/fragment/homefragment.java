package com.example.pindifoods.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.example.pindifoods.MenuFragment;
import com.example.pindifoods.R;

import java.util.List;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pindifoods.adapter.popularadapter;
import com.example.pindifoods.databinding.FragmentHomefragmentBinding;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pindifoods.model.PopularItem;

import java.util.ArrayList;

public class homefragment extends Fragment {
    private FragmentHomefragmentBinding binding;
    Context context;


    public homefragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomefragmentBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));

        binding.imageSlider.setImageList(imageList);
        binding.imageSlider.setImageList(imageList , ScaleTypes.FIT);
        binding.imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void doubleClick(int i) {

            }

            public void onItemSelected(int position) {
                SlideModel itemPosition = imageList.get(position);
                String itemMessage = "selected image " + position;
                Toast.makeText(getContext(), itemMessage, Toast.LENGTH_SHORT).show();
            }
        });
        List<PopularItem> popularItemList = new ArrayList<>();
        popularItemList.add(new PopularItem("Herbal Pancake", 7, R.drawable.menu1));
        popularItemList.add(new PopularItem("Fruit Salad", 5, R.drawable.menu2));
        popularItemList.add(new PopularItem("Green Noodle", 15, R.drawable.menu3));
        popularItemList.add(new PopularItem("Herbal Pancake", 7, R.drawable.menu4));
        popularItemList.add(new PopularItem("Herbal Pancake", 7, R.drawable.menu5));
        popularItemList.add(new PopularItem("Fruit Salad", 5, R.drawable.menu6));
        popularItemList.add(new PopularItem("Green Noodle", 15, R.drawable.menu7));

        popularadapter adapter = new popularadapter(popularItemList, getContext());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.viewAllMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragment bottomSheetFragment = new MenuFragment();
                bottomSheetFragment.show(getParentFragmentManager(), "test");

            }
        });


        return rootView;
    }
}