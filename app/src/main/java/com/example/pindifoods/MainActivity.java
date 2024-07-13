package com.example.pindifoods;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pindifoods.databinding.ActivityMainBinding;
import com.example.pindifoods.fragment.cartfragment;
import com.example.pindifoods.fragment.historyfragment;
import com.example.pindifoods.fragment.homefragment;
import com.example.pindifoods.fragment.profilefragment;
import com.example.pindifoods.fragment.searchfragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth mAuth;
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
            finish();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        if (savedInstanceState == null) {
            replaceFragment(new homefragment());
            binding.bottomNavigationView.setSelectedItemId(R.id.homefragment); // Assuming R.id.homefragment is the ID for the home item
        }
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.homefragment:
                    replaceFragment(new homefragment());

                    break;
                case R.id.cartfragment:
                    replaceFragment(new cartfragment());

                    break;
                case R.id.searchfragment:
                    replaceFragment(new searchfragment());

                    break;
                case R.id.historyfragment:
                    replaceFragment(new historyfragment());

                    break;
                case R.id.profilefragment:
                    replaceFragment(new profilefragment());

                    break;

            }


            return true;

        });



    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

}