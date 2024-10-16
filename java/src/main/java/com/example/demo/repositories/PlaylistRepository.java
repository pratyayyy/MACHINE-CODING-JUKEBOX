package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository{

    private final Map<Long,Playlist> playlistMap;
    private Long counter = 1L;

    public PlaylistRepository(){
        playlistMap = new HashMap<>();
    }

    public Playlist save(Playlist playlist){
        if(playlist.getId() == null){
            Playlist playListob = new Playlist(counter,playlist.getName(),playlist.getSongs()); 
            playlistMap.put(playListob.getId(),playListob);
            counter++;
            return playListob;
        }
        playlistMap.put(playlist.getId(),playlist);
        return playlist;
    }

    public Optional<Playlist> findById(Long id){
        return Optional.ofNullable(playlistMap.get(id));
    }

    public List<Playlist> findAll(){
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    public void deleteById(Long id){
        playlistMap.remove(id);
    }
    
}
