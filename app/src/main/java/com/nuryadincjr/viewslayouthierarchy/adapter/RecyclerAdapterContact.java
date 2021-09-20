package com.nuryadincjr.viewslayouthierarchy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.viewslayouthierarchy.R;
import com.nuryadincjr.viewslayouthierarchy.interpace.ItemClickListener;
import com.nuryadincjr.viewslayouthierarchy.modul.Contacts;

import java.util.ArrayList;

public class RecyclerAdapterContact extends RecyclerView.Adapter<RecyclerAdapterContact.ViewHolder> {

    private final ArrayList<Contacts> contactsArrayList;
    private ItemClickListener itemClickListener;

    public RecyclerAdapterContact(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_contact, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int no = position + 1;
        holder.no.setText(String.valueOf(no));
        holder.name.setText(contactsArrayList.get(position).getName());
        holder.photo.setImageResource(Integer.parseInt(contactsArrayList.get(position).getPhoto()));
    }

    @Override
    public int getItemCount() {
        return contactsArrayList != null ? contactsArrayList.size():0;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        public TextView no, name;
        public ImageView photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            no = itemView.findViewById(R.id.txtNo);
            name = itemView.findViewById(R.id.txtName);
            photo = itemView.findViewById(R.id.photo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener != null)
                itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
