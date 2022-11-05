package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Artist extends Producers{

    private ArrayList<Song> songs;

    public Artist(String name, String URLImage, LocalDate date) {
        super(name, URLImage, date);
        this.songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Artist: " +
                "\nSongs: " + songs;
    }

    public boolean addSong(Song newSong) {
        return songs.add(newSong);
    }
}
