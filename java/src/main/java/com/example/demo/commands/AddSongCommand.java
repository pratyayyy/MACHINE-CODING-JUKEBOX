package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Artist;
import com.example.demo.entities.Genre;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

public class AddSongCommand implements ICommand{

    private final SongService songService;
    
    public AddSongCommand(SongService songService)
    {
        this.songService = songService;
    }
    
    @Override
    public void execute(List<String> tokens)
    {
        String name = tokens.get(1).trim();
        String artistName = tokens.get(2).trim();
        String album = tokens.get(3).trim();
        String genretype = tokens.get(4).trim();


        Genre genre = Genre.valueOf(genretype);
        List<Artist> artist = new ArrayList<>();

        if(artistName.contains(",")){
        String[] artistArray = artistName.split(",");
        for(String a : artistArray)
        {
            artist.add(new Artist(a.trim()));
        }
        }
        else{
            artist.add(new Artist(artistName));
        }
         
        Song song = songService.addSong(name,artist,album,genre);
        System.out.println(song);

    }
    
    
}
