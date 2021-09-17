package com.nuryadincjr.viewslayouthierarchy;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.viewslayouthierarchy.databinding.ActivityConstaintLayoutBinding;

public class ConstaintLayoutActivity extends AppCompatActivity {

    private int value;
    private ActivityConstaintLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constaint_layout);

        binding = ActivityConstaintLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        value = Integer.parseInt(binding.textView3.getText().toString());

        binding.btnToast.setOnClickListener(view -> {
            Toast.makeText(this, String.valueOf(value),
                    Toast.LENGTH_SHORT).show();
        });

        binding.btnCount.setOnClickListener(view -> {
            value += 1;
            binding.textView3.setText(String.valueOf(value));
        });

        binding.btnZero.setOnClickListener(view -> {
            value = 0;
            binding.textView3.setText(String.valueOf(value));
        });

        // visible in rotate device
        if(savedInstanceState != null) {
            value = Integer.parseInt(savedInstanceState.getString("value"));
            binding.textView3.setText(String.valueOf(value));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value", String.valueOf(value));
    }
}