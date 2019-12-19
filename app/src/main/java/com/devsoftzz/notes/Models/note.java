package com.devsoftzz.notes.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class note implements Parcelable {

    private String title;
    private String content;
    private String timestamp;

    public note(String title, String content, String timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public note() {
    }

    protected note(Parcel in) {
        title = in.readString();
        content = in.readString();
        timestamp = in.readString();
    }

    public static final Creator<note> CREATOR = new Creator<note>() {
        @Override
        public note createFromParcel(Parcel in) {
            return new note(in);
        }

        @Override
        public note[] newArray(int size) {
            return new note[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(timestamp);
    }
}
