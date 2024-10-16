package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class PlaySongCommand implements ICommand{
    private final PlaylistService playlistService;

    public PlaySongCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens)
    {
        playlistService.play();
    }
}
