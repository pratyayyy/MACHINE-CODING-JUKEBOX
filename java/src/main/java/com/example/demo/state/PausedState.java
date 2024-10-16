package com.example.demo.state;

public class PausedState implements PlayerState {
    private Player player;

    public PausedState(Player player){
        this.player = player;
    }

    public void playSong()
    {

    }

    public void stopSong()
    {
        System.out.println("Song [id=" + player.getsongIds().get(player.getCurrentSongId()) + "] is stopped!");
        player.setState(new StoppedState(player));
    }

    public void nextSong()
    {
       int currentId = this.player.getCurrentSongId();
       System.out.println("Song [id=" + (currentId + 1) + "] is playing!");
    }

    public void previousSong()
    {
        int currentId = this.player.getCurrentSongId();
        System.out.println("Song [id=" + (currentId - 1) + "] is playing!");
    }
}
