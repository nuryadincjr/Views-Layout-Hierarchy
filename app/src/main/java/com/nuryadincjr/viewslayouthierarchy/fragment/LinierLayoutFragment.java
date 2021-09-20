package com.nuryadincjr.viewslayouthierarchy.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nuryadincjr.viewslayouthierarchy.databinding.FragmentLinierLayoutBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinierLayoutFragment extends Fragment {

    private FragmentLinierLayoutBinding binding;
    private String addresses, subject, messages;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLinierLayoutBinding.inflate(inflater, container, false);
        View views = binding.getRoot();


        binding.btnSend.setOnClickListener(view -> {
            addresses = binding.inpTo.getText().toString();
            subject = binding.inpSubject.getText().toString();
            messages = binding.inpMsg.getText().toString();

            sendEmail(emailAddresses(), subject, messages);
        });

        return views;
    }

    public void sendEmail(String[] addresses, String subject, String messages) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, messages);

        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            getContext().startActivity(intent);
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