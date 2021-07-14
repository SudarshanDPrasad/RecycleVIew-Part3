package com.example.songplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemOnClicker {
    private RecyclerView recyclerView;
    private ArrayList<Song> songArrayList = new ArrayList<>();
    private SongAdapter songAdapter;
    private Button mbtntoplay;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intidview();
        buildsongview();
        setsongview();
    }

    private void setsongview() {
        songAdapter = new SongAdapter(songArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(songAdapter);
    }

    private void buildsongview() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Song song = new Song("masai" + i, 20, R.drawable.unnamed, R.raw.fikar);
                songArrayList.add(song);

            } else {
                Song song = new Song("masai" + i, 20, R.drawable.unnamed, R.raw.kkb);
                songArrayList.add(song);
            }
        }
    }

    private void intidview() {
        recyclerView = findViewById(R.id.recycleView);
    }

    @Override
    public void onClick(int position, Song song) {
//        if (mediaPlayer != null) {
//            mediaPlayer.reset();
//        }
//        mediaPlayer = MediaPlayer.create(getApplicationContext(), song.getMusic());
//        mediaPlayer.start();

    }

    @Override
    public void pause() {
//        if (mediaPlayer != null) {
//            mediaPlayer.pause();
//        }
    }

    @Override
    public void delete(Song song) {
        songArrayList.remove(song);
        songAdapter.notifyDataSetChanged();
    }

}