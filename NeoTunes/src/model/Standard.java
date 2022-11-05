package model;

import java.time.LocalDate;
import java.util.Arrays;

public class Standard extends Consumer{

    private Song[] songs;
    private Podcast[] podcasts;
    private LocalDate[] dateBuySong;
    private PlayList[] playlists;

    public Standard(String nickname, String id, LocalDate date) {
        super(nickname, id, date);
        this.songs = new Song[100];
        this.podcasts = new Podcast[100];
        this.dateBuySong = new LocalDate[100];
        this.playlists = new PlayList[20];
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public Podcast[] getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(Podcast[] podcasts) {
        this.podcasts = podcasts;
    }

    public LocalDate[] getDateBuySong() {
        return dateBuySong;
    }

    public void setDateBuySong(LocalDate[] dateBuySong) {
        this.dateBuySong = dateBuySong;
    }

    public PlayList[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(PlayList[] playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "Consumer (Standard): " +
                "\nSongs: " + Arrays.toString(songs) +
                "\nPodcasts: " + Arrays.toString(podcasts) +
                "\nPlaylists: " + Arrays.toString(playlists);
    }

    public boolean addPlaylist(PlayList newPlaylist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] != null) {
                playlists[i] = newPlaylist;
                return true;
            }
        }
        return false;
    }

    public boolean searchPlaylist(String playlistName, Audio audio, int playlistMenu) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlistName.equalsIgnoreCase(playlists[i].getName())) {
                switch (playlistMenu) {
                    case 1:
                        return playlists[i].addAudio(audio);
                    case 2:
                        return playlists[i].deleteAudio(audio);
                }
            }
        }
        return false;
    }
}
