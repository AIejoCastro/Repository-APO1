package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Premium extends Consumer{

    private ArrayList<Song> songs;
    private ArrayList<Podcast> podcasts;
    private ArrayList<LocalDate> dateBuySong;
    private ArrayList<PlayList> playlists;

    public Premium(String nickname, String id, LocalDate date) {
        super(nickname, id, date);
        this.songs = new ArrayList<Song>();
        this.podcasts = new ArrayList<Podcast>();
        this.dateBuySong = new ArrayList<LocalDate>();
        this.playlists = new ArrayList<PlayList>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public ArrayList<LocalDate> getDateBuySong() {
        return dateBuySong;
    }

    public void setDateBuySong(ArrayList<LocalDate> dateBuySong) {
        this.dateBuySong = dateBuySong;
    }

    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "Consumer (Premium): " +
                "\nSongs: " + songs +
                "\nPodcasts: " + podcasts +
                "\nPlaylists: " + playlists;
    }

    public boolean addPlaylist(PlayList newPlaylist) {
        return playlists.add(newPlaylist);
    }

    public boolean searchPlaylist(String playlistName, Audio audio, int playlistMenu) {
        for (int i = 0; i < playlists.size(); i++) {
            if (playlistName.equalsIgnoreCase(playlists.get(i).getName())) {
                switch (playlistMenu) {
                    case 1:
                        return playlists.get(i).addAudio(audio);
                    case 2:
                        return playlists.get(i).deleteAudio(audio);
                }
            }
        }
        return false;
    }
}
