package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository{

    private final Map<Long,Song> songMap; 
    private Long counter = 1L;

    public SongRepository()
    {
       songMap = new HashMap<>();
    }

    public Song save(Song song)
    {
        if(song.getId() == null)
        {
            Song songs = new Song(counter,song.getName(),song.getArtist(),song.getAlbum(),song.getGenre());
            songMap.put(songs.getId(),songs);
            counter++;
            return songs;
        }
            songMap.put(song.getId(),song);
            return song;
    }


    public Optional<Song> findById(long id)
    {
        return Optional.ofNullable(songMap.get(id));
    }


    public List<Song> findAll()
    {
        return songMap.values().stream().collect(Collectors.toList());
    }


    public void deleteById(Long id)
    {
        songMap.remove(id);
    }
}
