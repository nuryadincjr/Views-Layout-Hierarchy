package com.nuryadincjr.viewslayouthierarchy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.viewslayouthierarchy.databinding.ActivityLinearLayoutBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinearLayoutActivity extends AppCompatActivity {

    private ActivityLinearLayoutBinding binding;
    private String addresses, subject, messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        binding = ActivityLinearLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSend.setOnClickListener(view -> {
            addresses = binding.inpTo.getText().toString();
            subject = binding.inpSubject.getText().toString();
            messages = binding.inpMsg.getText().toString();

            sendEmail(emailAddresses(), subject, messages);
        });
    }

    public void sendEmail(String[] addresses, String subject, String messages) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, messages);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String[] emailAddresses() {
        final Pattern MY_PATTERN = Pattern.compile("(\\S+)");
        final Matcher MAT = MY_PATTERN.matcher(addresses);

        List<String> list = new ArrayList<>();
        while (MAT.find()) {
            list.add(MAT.group(1));
        }
        String[] add = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            add[i] = list.get(i);
        }
        return add;
    }
}