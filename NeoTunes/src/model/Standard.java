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

    public boolean searchPlaylist(String playlistName, String audioName, int playlistMenu) {
        Audio audioAdd = null;
        for (int i = 0; i < songs.length; i++) {
            if (songs[i].getName().equalsIgnoreCase(audioName)) {
                audioAdd = songs[i];
                for (int j = 0; j < playlists.length; j++) {
                    if (playlistName.equalsIgnoreCase(playlists[j].getName())) {
                        switch (playlistMenu) {
                            case 1:
                                return playlists[j].addAudio(audioAdd);
                            case 2:
                                return playlists[j].deleteAudio(audioAdd);
                        }
                    }
                }
            } else if (podcasts[i].getName().equalsIgnoreCase(audioName)) {
                audioAdd = podcasts[i];
                for (int j = 0; j < playlists.length; j++) {
                    if (playlistName.equalsIgnoreCase(playlists[j].getName())) {
                        switch (playlistMenu) {
                            case 1:
                                return playlists[j].addAudio(audioAdd);
                            case 2:
                                return playlists[j].deleteAudio(audioAdd);
                        }
                    }
                }
            }
        }
        return false;
    }

    public String reproduceAudio(String playlistName, String audioName) {
        String name = "";
        for (int i = 0; i < playlists.length; i++) {
            if (playlistName.equalsIgnoreCase(playlists[i].getName())) {
                name = playlists[i].reproduceAudio(audioName);
            }
        }
        return name;
    }

    public boolean buySong(Song songBuy) {
        for (int i = 0; i < songs.length; i++) {
            if (songs[i] == null) {
                songs[i] = songBuy;
                return true;
            }
        }
        return false;
    }

    public boolean buyPodcast(Podcast podcastBuy) {
        for (int i = 0; i < podcasts.length; i++) {
            if (podcasts[i] == null) {
                podcasts[i] = podcastBuy;
                return true;
            }
        }
        return false;
    }
}
