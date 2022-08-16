package com.dreamyprogrammer.simplenotes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.UUID;

public class Task implements Parcelable {
    private String id;
    private String name;
    private String note;
    private long createDate;
    private long dateTask;
    private Integer delete;


    public void setName(String name) {
        this.name = name;
    }

    public Task(String name) {
        id = UUID.randomUUID().toString();
        createDate = getCurrentDate();
        this.name = name;
    }

    public static long getCurrentDate(){
        return Calendar.getInstance().getTimeInMillis();
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
