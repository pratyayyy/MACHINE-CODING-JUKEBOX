package com.example.demo.state;

public class StoppedState implements PlayerState {
    private Player player;

    public StoppedState(Player player){
        this.player = player;
    }

    public void playSong()
    {
        player.setState(new PlayingState(player));
        player.setCurrentSongId(0);
        System.out.println("Song [id="+player.getsongIds().get(0).toString()+"] is playing!");
    }

    public void stopSong()
    {
        System.out.println("Song [id=" + this.player.getCurrentSongId() + "] is stopped!");
    }

    public void nextSong()
    {

    }

    public void previousSong()
    {

    }
        

}
