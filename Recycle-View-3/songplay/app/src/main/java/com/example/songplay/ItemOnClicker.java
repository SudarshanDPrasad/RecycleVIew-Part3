package com.example.songplay;

public interface ItemOnClicker {
    void onClick(int position,Song song);
    void pause();
    void delete(Song song);
}
