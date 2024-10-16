package com.example.demo.entities;

import java.util.List;

public class Song
{
    private final Long id;
    private final String name;
	private List<Artist> artist;
	private String album;
	private Genre genre; 

    public Song(Long id,String name, List<Artist> artist, String album, Genre genre)
    {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public Song(String name, List<Artist> artist, String album, Genre genre)
    {
        this(null, name, artist, album, genre);
    }

    public Long getId()
    {
        return id;
    }
    public String getName()
    {
      return name;
    }
    public Genre getGenre()
    {
      return genre;
    }
    public String getAlbum()
    {
      return album;
    } 
    public List<Artist> getArtist()
    {
      return artist;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
       Song other = (Song) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    @Override
    public String toString()
    {
        return "Song [id=" + id + "]";
    }
    
}
