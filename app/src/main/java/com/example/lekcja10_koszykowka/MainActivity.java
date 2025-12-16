package com.example.lekcja10_koszykowka;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lekcja10_koszykowka.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PunktyViewModel punktyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);

        punktyViewModel.getPunktyA().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer value) {
                binding.scoreA.setText(String.valueOf(value != null ? value : 0));
            }
        });

        punktyViewModel.getPunktyB().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer value) {
                binding.scoreB.setText(String.valueOf(value != null ? value : 0));
            }
        });

        binding.plus1A.setOnClickListener(v -> punktyViewModel.addPunktyA(1));
        binding.plus2A.setOnClickListener(v -> punktyViewModel.addPunktyA(2));
        binding.plus3A.setOnClickListener(v -> punktyViewModel.addPunktyA(3));

        binding.plus1B.setOnClickListener(v -> punktyViewModel.addPunktyB(1));
        binding.plus2B.setOnClickListener(v -> punktyViewModel.addPunktyB(2));
        binding.plus3B.setOnClickListener(v -> punktyViewModel.addPunktyB(3));

    }
}