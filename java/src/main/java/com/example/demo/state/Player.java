package com.example.demo.state;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;

public class Player {
    private List<Long> songIds;
    private int currentSongId;
    private Playlist currentPlaylist;
    private PlayerState state;

    public Player()
    {
        this.state = new StoppedState(this);
        this.songIds = new ArrayList<>();
    }


    public void playSong() {
        this.state.playSong();
    }

    public void stopSong() {
        this.state.stopSong();
    }

    public void nextSong() {
        this.state.nextSong();
    }

    public void previousSong() {
        this.state.previousSong();
    }

    public List<Long> getsongIds() {
        return songIds;
    }

    public void setsongIds(List<Long> songIds) {
        this.songIds = songIds;
    }

    
    public int getCurrentSongId() {
        return this.currentSongId;
    }

    public void setCurrentSongId(int currentSongId) {
        this.currentSongId = currentSongId;
    }

    public Playlist getCurrentPlaylist() {
        return this.currentPlaylist;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

}
