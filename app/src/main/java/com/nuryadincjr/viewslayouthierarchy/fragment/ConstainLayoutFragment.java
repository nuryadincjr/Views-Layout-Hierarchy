package com.nuryadincjr.viewslayouthierarchy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nuryadincjr.viewslayouthierarchy.databinding.FragmentConstainLayoutBinding;

public class ConstainLayoutFragment extends Fragment {

    private FragmentConstainLayoutBinding binding;
    private int value;

    public ConstainLayoutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentConstainLayoutBinding.inflate(inflater, container, false);
        View views = binding.getRoot();


        value = Integer.parseInt(binding.textView3.getText().toString());

        binding.btnToast.setOnClickListener(view ->
                Toast.makeText(getContext(), String.valueOf(value),
                Toast.LENGTH_SHORT).show());

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

        return views;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value", String.valueOf(value));
    }
}