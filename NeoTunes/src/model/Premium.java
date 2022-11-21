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

    public boolean searchPlaylist(String playlistName, String audioName, int playlistMenu) {
        Audio audioAdd = null;
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getName().equalsIgnoreCase(audioName)) {
                audioAdd = songs.get(i);
                for (int j = 0; j < playlists.size(); j++) {
                    if (playlistName.equalsIgnoreCase(playlists.get(j).getName())) {
                        switch (playlistMenu) {
                            case 1:
                                return playlists.get(j).addAudio(audioAdd);
                            case 2:
                                return playlists.get(j).deleteAudio(audioAdd);
                        }
                    }
                }
            } else if (podcasts.get(i).getName().equalsIgnoreCase(audioName)) {
                audioAdd = podcasts.get(i);
                for (int j = 0; j < playlists.size(); j++) {
                    if (playlistName.equalsIgnoreCase(playlists.get(j).getName())) {
                        switch (playlistMenu) {
                            case 1:
                                return playlists.get(j).addAudio(audioAdd);
                            case 2:
                                return playlists.get(j).deleteAudio(audioAdd);
                        }
                    }
                }
            }

        }
        return false;
    }

    public String reproduceAudio(String playlistName, String audioName) {
        String name = "";
        for (int i = 0; i < playlists.size(); i++) {
            if (playlistName.equalsIgnoreCase(playlists.get(i).getName())) {
                name = playlists.get(i).reproduceAudio(audioName);
            }
        }
        return name;
    }

    public boolean buySong(Song songBuy) {
        return songs.add(songBuy);
    }

    public boolean buyPodcast(Podcast podcastBuy) {
        return podcasts.add(podcastBuy);
    }
}
