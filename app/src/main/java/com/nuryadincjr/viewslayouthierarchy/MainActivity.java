package com.nuryadincjr.viewslayouthierarchy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nuryadincjr.viewslayouthierarchy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnConstain.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ConstaintLayoutActivity.class);
            startActivity(intent);
        });

        binding.btnFrame.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
            startActivity(intent);
        });

        binding.btnLinier.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
            startActivity(intent);
        });

        binding.btnRelative.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
            startActivity(intent);
        });
    }
}