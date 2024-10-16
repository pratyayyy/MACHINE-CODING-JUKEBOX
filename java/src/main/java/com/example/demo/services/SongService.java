package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Artist;
import com.example.demo.entities.Genre;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService {

    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository)
    {
        this.songRepository = songRepository;
    }

    public Song addSong(String songName,List<Artist> artist, String album, Genre genre)
    {
        Song song = new Song(songName,artist,album,genre);
       return songRepository.save(song);
    }
    
    public List<Song> listSongs()
    {
        return songRepository.findAll();
    }
}
