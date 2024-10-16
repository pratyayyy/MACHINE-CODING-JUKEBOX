package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class LoadPlaylistCommand implements ICommand {

    private final PlaylistService playlistService;
    
    public LoadPlaylistCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String>tokens){
        String playlistName = tokens.get(1);
        String loadPlaylist = playlistService.loadPlaylist(playlistName);
        System.out.println(loadPlaylist);
    }
}
