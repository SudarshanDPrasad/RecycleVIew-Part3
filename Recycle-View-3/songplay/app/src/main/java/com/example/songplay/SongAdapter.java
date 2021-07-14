package com.example.songplay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
    private ArrayList<Song> songArrayList;
    private ItemOnClicker itemOnClicker;

    public SongAdapter(ArrayList<Song> songArrayList,ItemOnClicker itemOnClicker) {
        this.songArrayList = songArrayList;
        this.itemOnClicker = itemOnClicker;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songArrayList.get(position);
        holder.setData(song,itemOnClicker);

    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }
}
