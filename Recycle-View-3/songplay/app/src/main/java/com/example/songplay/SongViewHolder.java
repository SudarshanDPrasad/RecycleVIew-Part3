package com.example.songplay;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongViewHolder extends RecyclerView.ViewHolder {
    private ImageView mivcoverimage;
    private TextView mtvsongname;
    private TextView mtvsongduration;
    private Button mbtntoplay;
    private Button mbtntopause;
    private Button mbtntodelete;

    public SongViewHolder(@NonNull View itemView) {
        super(itemView);
        intidviews(itemView);
    }

    private void intidviews(View itemView) {
        mivcoverimage = itemView.findViewById(R.id.ivcoverimage);
        mtvsongname = itemView.findViewById(R.id.tvsongname);
        mtvsongduration = itemView.findViewById(R.id.tvsongduration);
        mbtntoplay = itemView.findViewById(R.id.btntoplay);
        mbtntopause = itemView.findViewById(R.id.btntopause);
        mbtntodelete = itemView.findViewById(R.id.btntodelete);

    }

    public void setData(Song song, ItemOnClicker itemOnClicker) {
        mivcoverimage.setBackgroundResource(song.getImage());
        mtvsongname.setText(song.getName());
        mtvsongduration.setText(song.getTimeduration() + " ");
        MediaPlayer mediaPlayer = MediaPlayer.create(mtvsongname.getContext(), song.getMusic());

      
        mbtntoplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemOnClicker.onClick(getAdapterPosition(),song);
                mediaPlayer.start();
            }
        });

        mbtntopause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemOnClicker.pause();
                mediaPlayer.pause();
            }
        });

        mbtntodelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClicker.delete(song);
            }
        });
    }
}
