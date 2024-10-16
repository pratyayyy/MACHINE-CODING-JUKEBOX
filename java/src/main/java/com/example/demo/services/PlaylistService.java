package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository; 
import com.example.demo.state.Player;

public class PlaylistService {
   private final IPlaylistRepository playlistRepository;
   private final ISongRepository songRepository;
   Playlist currentPlaylist;
   Player player;

   List<Playlist> playlist = new ArrayList<>();

   public PlaylistService(IPlaylistRepository playlistRepository,ISongRepository songRepository){
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
        this.player = new Player();
   }

   public Playlist createPlaylist(String playlistName, List<Long>songId){
      List<Song> songList = new ArrayList<>();
      for(Long id  : songId){
         Song song = songRepository.findById(id).orElseThrow(()->new RuntimeException("Song not found"));
         songList.add(song);
      }

      Playlist playlist = new Playlist(playlistName,songList);

      return playlistRepository.save(playlist);
   }

   public String deletePlaylist(String playlistName){
      for(Playlist playlist : playlistRepository.findAll()){
         if(playlist.getName().equals(playlistName)){
            playlistRepository.deleteById(playlist.getId());
            break;
         }
      }
      return "Playlist"+" " + playlistName + " is deleted!";   
   }

   public String loadPlaylist(String playlistName){
      currentPlaylist = playlistRepository.findAll().stream().filter(playlist->playlist.getName().equals(playlistName)).findFirst().get();
      player.setsongIds(currentPlaylist.getSongIds());
      return "Playlist " + currentPlaylist.getName() + " is loaded!";
   }  

   public String addSongToPlaylist(String playlistName, Long songId) {
      Song song = songRepository.findById(songId).get();
      Playlist playlist = playlistRepository.findAll().stream().filter(list->list.getName().equals(playlistName)).findFirst().get();
      playlist.addSong(song);
      return "Playlist " + playlist.getName() + " is revised with " + playlist.getSongs().toString();
   }

   public String deleteSongFromPlaylist(String playlistName, Long songId) {
      Playlist playlist = playlistRepository.findAll().stream().filter(list->list.getName().equals(playlistName)).findFirst().get();
      Song song = playlist.getSongs().stream().filter(s->s.getId().equals(songId)).findFirst().get();
      playlist.removeSong(song);
      return "Playlist " + playlistName + " is revised with " + playlist.getSongs().toString();
   }

   public void play(){
      if(currentPlaylist == null){
         System.out.println("No playlist found!");
         return;
      }
      player.playSong();
   }

   public void next(){
      if(currentPlaylist == null){
         System.out.println("No playlist found!");
         return;
      }
      player.nextSong();
   }

   public void previous(){
      if(currentPlaylist == null){
         System.out.println("No playlist found!");
         return;
      }
      player.previousSong();
   }

   public void stop(){
      if(currentPlaylist == null){
         System.out.println("No playlist found!");
         return;
      }
      player.stopSong();
   }
}
