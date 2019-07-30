package com.example.coba.Object;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int img;
    private String title;
    private String desc;
    private String is_movie;

    public Movie( String title, String desc, int img, String is_movie){
        this.img = img;
        this.title = title;
        this.desc = desc;
        this.is_movie = is_movie;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIs_movie() {
        return is_movie;
    }

    public void setIs_movie(String is_movie) {
        this.is_movie = is_movie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.img);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeString(this.is_movie);
    }

    protected Movie(Parcel in) {
        this.img = in.readInt();
        this.title = in.readString();
        this.desc = in.readString();
        this.is_movie = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
