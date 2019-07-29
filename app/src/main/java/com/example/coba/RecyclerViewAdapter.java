package com.example.coba;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Movie> mDataMovie;


    public RecyclerViewAdapter(Context mContext, List<Movie> mDataMovie) {
        this.mContext = mContext;
        this.mDataMovie = mDataMovie;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)  {
        View v;

        v = LayoutInflater.from(mContext).inflate(R.layout.item_movie, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int i) {
        holder.tv_title.setText(mDataMovie.get(i).getTitle());
        holder.tv_desc.setText(mDataMovie.get(i).getDesc());
        holder.iv_img.setImageResource(mDataMovie.get(i).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(v.getContext(), detail.class);
                //mengirimkan data yang dipilih dengan identitas Extra_Movie
                x.putExtra(detail.Extra_Movie, mDataMovie.get(i));
                v.getContext().startActivity(x);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataMovie.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder   {
        private TextView tv_title, tv_desc;
        private ImageView iv_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title_movie);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc_movie);
            iv_img = (ImageView) itemView.findViewById(R.id.img_movie);

        }
    }



}
