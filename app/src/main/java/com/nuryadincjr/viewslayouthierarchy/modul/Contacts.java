package com.nuryadincjr.viewslayouthierarchy.modul;

import android.os.Parcel;
import android.os.Parcelable;

public class Contacts implements Parcelable {

    private String name;
    private String photo;

    public Contacts(String neme, String photo) {
        this.name = neme;
        this.photo = photo;
    }

    protected Contacts(Parcel in) {
        name = in.readString();
        photo = in.readString();
    }

    public static final Creator<Contacts> CREATOR = new Creator<Contacts>() {
        @Override
        public Contacts createFromParcel(Parcel in) {
            return new Contacts(in);
        }

        @Override
        public Contacts[] newArray(int size) {
            return new Contacts[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(photo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
