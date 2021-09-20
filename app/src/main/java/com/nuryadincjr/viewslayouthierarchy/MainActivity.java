package com.nuryadincjr.viewslayouthierarchy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.nuryadincjr.viewslayouthierarchy.databinding.ActivityMainBinding;
import com.nuryadincjr.viewslayouthierarchy.fragment.ConstainLayoutFragment;
import com.nuryadincjr.viewslayouthierarchy.fragment.HomeFragment;
import com.nuryadincjr.viewslayouthierarchy.fragment.LinierLayoutFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getFragmentPage(new HomeFragment());

        binding.menuNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.btnHome:
                    getFragmentPage(new HomeFragment());
                    break;
                case R.id.btnConstain:
                    getFragmentPage(new ConstainLayoutFragment());
                    break;
                case R.id.btnLinier:
                        getFragmentPage(new LinierLayoutFragment());
                    break;
            }
            return true;
        });
    }

    private boolean getFragmentPage(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contactContainer, fragment)
                    .commit();
            return true;
        }
        return true;
    }
}