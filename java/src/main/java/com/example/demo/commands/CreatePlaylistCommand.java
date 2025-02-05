package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand{

    private final PlaylistService playlistService;
    
    public CreatePlaylistCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens)
    {
        String playlistName = tokens.get(1);
        List<Long> ids = new ArrayList<>();
        for(int i=2;i<tokens.size();i++){
            ids.add(Long.parseLong(tokens.get(i)));
        } 

        Playlist playlist = playlistService.createPlaylist(playlistName, ids);
        System.out.println(playlist);
    }
    
}
