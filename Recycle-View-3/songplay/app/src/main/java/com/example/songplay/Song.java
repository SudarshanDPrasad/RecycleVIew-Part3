package com.example.songplay;

public class Song {
    private String name;
    private int timeduration;
    private int image;
    private int music;


    public Song(String name, int timeduration, int image , int music) {
        this.name = name;
        this.timeduration = timeduration;
        this.image = image;
        this.music = music;
    }

    public String getName() {
        return name;
    }


    public int getTimeduration() {
        return timeduration;
    }

    public int getImage() {
        return image;
    }
    public int getMusic() {
        return music;
    }
}
