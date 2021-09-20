package com.nuryadincjr.viewslayouthierarchy.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.viewslayouthierarchy.R;
import com.nuryadincjr.viewslayouthierarchy.activity.AddContactActivity;
import com.nuryadincjr.viewslayouthierarchy.adapter.RecyclerAdapterContact;
import com.nuryadincjr.viewslayouthierarchy.databinding.FragmentHomeBinding;
import com.nuryadincjr.viewslayouthierarchy.interpace.ItemClickListener;
import com.nuryadincjr.viewslayouthierarchy.modul.Contacts;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerAdapterContact adapterContact;
    private ArrayList<Contacts> contactsArrayList;
    private RecyclerView views;
    Contacts contacts = new Contacts("", "");

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        getContacts();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        binding.rcvContact.setLayoutManager(manager);

        adapterContact = new RecyclerAdapterContact(contactsArrayList);
        binding.rcvContact.setAdapter(adapterContact);

        adapterContact.setItemClickListener((view1, position) -> {
            String name = contactsArrayList.get(position).getName();

            contacts.setName(name);

            Toast.makeText(getActivity(), contacts.getName(), Toast.LENGTH_SHORT).show();
        });

        binding.btnFabAdd.setOnClickListener(view12 -> {
            Intent intent = new Intent(getContext(), AddContactActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void getContacts() {
        if(contactsArrayList == null) {
            Resources resources = getResources();
            String[] names = resources.getStringArray(R.array.names);

            final TypedArray PHOTO = resources.obtainTypedArray(R.array.photo);

            contactsArrayList = new ArrayList<>();
            for (int i = 0; i < names.length; i++)
                contactsArrayList.add(new Contacts(names[i],
                        String.valueOf(PHOTO.getResourceId(i, -1))));
        }
    }
}