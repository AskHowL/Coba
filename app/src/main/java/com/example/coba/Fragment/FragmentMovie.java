package com.example.coba.Fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coba.Object.Movie;
import com.example.coba.R;
import com.example.coba.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class FragmentMovie extends Fragment {

    View v;
    private RecyclerView rvMovie;
    private ArrayList<Movie> mDataMovie;
    private String[] data_title;
    private String[] data_description;
    private TypedArray data_photo;
    private String[] data_is_movie;

    public FragmentMovie() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        data_title = getResources().getStringArray(R.array.data_movie);
        data_description = getResources().getStringArray(R.array.data_description);
        data_photo = getResources().obtainTypedArray(R.array.data_photo);
        data_is_movie = getResources().getStringArray(R.array.is_movie);

        mDataMovie = new ArrayList<>();
        for (int i = 0; i < data_title.length; i++) {
            if (data_is_movie[i].equals("1") ){
                Movie movie = new Movie(data_title[i], data_description[i], data_photo.getResourceId(i, -1), data_is_movie[i]);
                movie.setTitle(data_title[i]);
                movie.setDesc(data_description[i]);
                movie.setImg(data_photo.getResourceId(i, -1));
                movie.setIs_movie(data_is_movie[i]);
                mDataMovie.add(movie);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_movie,container,false);
        rvMovie = (RecyclerView) v.findViewById(R.id.recyclermovie_id);
        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(getContext(),mDataMovie);
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovie.setAdapter(rvAdapter);

        return v;
    }



}
