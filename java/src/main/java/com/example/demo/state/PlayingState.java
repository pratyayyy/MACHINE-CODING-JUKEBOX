package com.example.demo.state;

public class PlayingState implements PlayerState{
    private Player player;

    public PlayingState(Player player){
        this.player = player;
    }

    public void playSong()
    {
        System.out.println("Song [id=" + player.getsongIds().get(player.getCurrentSongId()) + "] is paused!");
        this.player.setState(new PausedState(this.player));
    }

    public void stopSong()
    {

    }

    public void nextSong()
    {
        int currentId = this.player.getCurrentSongId();
        player.setCurrentSongId(currentId + 1);
        System.out.println("Song [id=" + player.getsongIds().get(currentId + 1) + "] is playing!");
    }

    public void previousSong()
    {
        int currentId = this.player.getCurrentSongId();
        player.setCurrentSongId(currentId - 1);
        System.out.println("Song [id=" + player.getsongIds().get(currentId - 1) + "] is playing!");
    }



}
