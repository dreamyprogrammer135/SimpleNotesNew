package com.dreamyprogrammer.simplenotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Task implements Parcelable {
    private String id;
    private String name;
    private Date createDate;
    private String note;
    private Integer delete;

    protected Task(Parcel in) {
        id = in.readString();
        name = in.readString();
        note = in.readString();
        if (in.readByte() == 0) {
            delete = null;
        } else {
            delete = in.readInt();
        }
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(note);
        if (delete == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(delete);
        }
    }
}
