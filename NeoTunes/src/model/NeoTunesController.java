package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class NeoTunesController {

    private ArrayList<Premium> premiumConsumer;
    private ArrayList<Standard> standardConsumer;
    private ArrayList<Artist> artistProducer;
    private ArrayList<ContentCreator> contentCreatorProducer;
    private ArrayList<Song> allSongs;
    private ArrayList<Podcast> allPodcasts;

    public NeoTunesController() {
        this.premiumConsumer = new ArrayList<Premium>();
        this.standardConsumer = new ArrayList<Standard>();
        this.artistProducer = new ArrayList<Artist>();
        this.contentCreatorProducer = new ArrayList<ContentCreator>();
        this.allSongs = new ArrayList<Song>();
        this.allPodcasts = new ArrayList<Podcast>();
    }

    public boolean addConsumer(int standardOrPremium, String nickname, String id) {
        LocalDate date = LocalDate.now();
        switch (standardOrPremium) {
            case 1:
                return premiumConsumer.add(new Premium(nickname, id, date));
            case 2:
                return standardConsumer.add(new Standard(nickname, id, date));
        }
        return false;
    }

    public boolean addProducer(int artistOrContentCreator, String name, String URLImage) {
        LocalDate date = LocalDate.now();
        switch (artistOrContentCreator) {
            case 1:
                return artistProducer.add(new Artist(name, URLImage, date));
            case 2:
                return contentCreatorProducer.add(new ContentCreator(name, URLImage, date));
        }
        return false;
    }

    public boolean addSong(String producerName, String songName, String albumName, int songGenre, String URLImageSong, double songDuration, double songPrice) {
        for (int i = 0; i < artistProducer.size(); i++) {
            if (producerName.equalsIgnoreCase(artistProducer.get(i).getName())) {
                allSongs.add(new Song(songName, URLImageSong, songDuration, 0, albumName, songGenre - 1, songPrice));
                return artistProducer.get(i).addSong(new Song(songName, URLImageSong, songDuration, 0, albumName, songGenre - 1, songPrice));
            }
        }
        return false;
    }

    public boolean addPodcast(String producerName, String podcastName, String podcastDescription, int podcastGenre, String URLImagePodcast, double podcastDuration) {
        for (int i = 0; i < contentCreatorProducer.size(); i++) {
            if (producerName.equalsIgnoreCase(artistProducer.get(i).getName())) {
                allPodcasts.add(new Podcast(podcastName, URLImagePodcast, podcastDuration, 0, podcastDescription, podcastGenre - 1));
                return contentCreatorProducer.get(i).addPodcast(new Podcast(podcastName, URLImagePodcast, podcastDuration, 0, podcastDescription, podcastGenre - 1));
            }
        }
        return false;
    }

    public boolean addPlaylist(String consumerName, String playlistName) {
        for (int i = 0; i < premiumConsumer.size(); i++) {
            if (consumerName.equalsIgnoreCase(premiumConsumer.get(i).getNickname())) {
                return premiumConsumer.get(i).addPlaylist(new PlayList(playlistName));
            }
        }
        for (int i = 0; i < standardConsumer.size(); i++) {
            if (consumerName.equalsIgnoreCase(standardConsumer.get(i).getNickname())) {
                return standardConsumer.get(i).addPlaylist(new PlayList(playlistName));
            }
        }
        return false;
    }

    public boolean editPlaylist(String consumerName, String playlistName, String audioName, int playlistMenu) {
        for (int i = 0; i < premiumConsumer.size(); i++) {
            if (consumerName.equalsIgnoreCase(premiumConsumer.get(i).getNickname())) {
                for (int j = 0; j < allSongs.size(); j++) {
                    if (audioName.equalsIgnoreCase(allSongs.get(i).getName())) {
                        return premiumConsumer.get(i).searchPlaylist(playlistName, allSongs.get(i), playlistMenu);
                    }
                }
                for (int j = 0; j < allPodcasts.size(); j++) {
                    if (audioName.equalsIgnoreCase(allPodcasts.get(i).getName())) {
                        return premiumConsumer.get(i).searchPlaylist(playlistName, allPodcasts.get(i), playlistMenu);
                    }
                }
            }
        }
        for (int i = 0; i < standardConsumer.size(); i++) {
            if (consumerName.equalsIgnoreCase(standardConsumer.get(i).getNickname())) {
                for (int j = 0; j < allSongs.size(); j++) {
                    if (audioName.equalsIgnoreCase(allSongs.get(i).getName())) {
                        return standardConsumer.get(i).searchPlaylist(playlistName, allSongs.get(i), playlistMenu);
                    }
                }
                for (int j = 0; j < allPodcasts.size(); j++) {
                    if (audioName.equalsIgnoreCase(allPodcasts.get(i).getName())) {
                        return standardConsumer.get(i).searchPlaylist(playlistName, allPodcasts.get(i), playlistMenu);
                    }
                }
            }
        }
        return false;
    }
}
