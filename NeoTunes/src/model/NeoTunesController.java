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
                return premiumConsumer.get(i).searchPlaylist(playlistName,audioName,playlistMenu);
            }
        }
        for (int i = 0; i < standardConsumer.size(); i++) {
            if (consumerName.equalsIgnoreCase(standardConsumer.get(i).getNickname())) {
                return standardConsumer.get(i).searchPlaylist(playlistName,audioName,playlistMenu);
            }
        }
        return false;
    }

    public String reproduceAudio(String consumerName, String playlistName, String audioName) {
        for (int i = 0; i < premiumConsumer.size(); i++){
            if (consumerName.equalsIgnoreCase(premiumConsumer.get(i).getNickname())) {
                 return premiumConsumer.get(i).reproduceAudio(playlistName, audioName);
            }
        }
        for (int i = 0; i < standardConsumer.size(); i++){
            if (consumerName.equalsIgnoreCase(standardConsumer.get(i).getNickname())) {
                return standardConsumer.get(i).reproduceAudio(playlistName, audioName);
            }
        }
        return "";
    }

    public boolean buyAudio(String consumerName, String audioName) {
        for (int i = 0; i < allSongs.size(); i++) {
            if (allSongs.get(i).getName().equalsIgnoreCase(audioName)) {
                Song songBuy = allSongs.get(i);
                for (int j = 0; j < premiumConsumer.size(); j++) {
                    if (consumerName.equalsIgnoreCase(premiumConsumer.get(j).getNickname())) {
                        if (premiumConsumer.get(j).buySong(songBuy)) {
                            allSongs.get(i).setSells(allSongs.get(i).getSells() + 1);
                            return true;
                        }
                    }
                }
                for (int j = 0; j < standardConsumer.size(); j++) {
                    if (consumerName.equalsIgnoreCase(standardConsumer.get(j).getNickname())) {
                        if (standardConsumer.get(j).buySong(songBuy)) {
                            allSongs.get(i).setSells(allSongs.get(i).getSells() + 1);
                            return true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < allPodcasts.size(); i++) {
            if (allPodcasts.get(i).getName().equalsIgnoreCase(audioName)) {
                Podcast podcastBuy = allPodcasts.get(i);
                for (int j = 0; j < premiumConsumer.size(); j++) {
                    if (consumerName.equalsIgnoreCase(premiumConsumer.get(j).getNickname())) {
                        return premiumConsumer.get(i).buyPodcast(podcastBuy);
                    }
                }
                for (int j = 0; j < standardConsumer.size(); j++) {
                    if (consumerName.equalsIgnoreCase(standardConsumer.get(j).getNickname())) {
                        return standardConsumer.get(i).buyPodcast(podcastBuy);
                    }
                }
            }
        }
        return false;
    }

    public int totalReproductions() {
        int reproductions = 0;
        for (int i = 0; i < allSongs.size(); i++) {
            reproductions += allSongs.get(i).getReproductions();
        }
        for (int i = 0; i < allPodcasts.size(); i ++) {
            reproductions += allPodcasts.get(i).getReproductions();
        }
        return reproductions;
    }

    public String songGenre() {
        Song song = allSongs.get(0);
        for (int i = 1; i < allSongs.size(); i++) {
            if (song.getReproductions() < allSongs.get(i).getReproductions()) {
                song = allSongs.get(i);
            }
        }
        return "- Song genre: " + song.getGenre() + " with " + song.getReproductions() + " reproductions";
    }

    public String podcastGenre() {
        Podcast podcast = allPodcasts.get(0);
        for (int i = 1; i < allPodcasts.size(); i++) {
            if (podcast.getReproductions() < allPodcasts.get(i).getReproductions()) {
                podcast = allPodcasts.get(i);
            }
        }
        return "- Podcast genre: " + podcast.getGenre() + " with " + podcast.getReproductions() + " reproductions";
    }

    public String bestSelling() {
        Song song = allSongs.get(0);
        for (int i = 1; i < allSongs.size(); i++) {
            if (song.getSells() < allSongs.get(i).getSells()) {
                song = allSongs.get(i);
            }
        }
        double profit = song.getSells() * song.getPrice();
        return "- Song name: " + song.getName() + " Have sold: " + song.getSells() + " Profit of: " + profit;
    }

    public String allSoldSongs() {
        int sellsRock = 0;
        double profitRock = 0;
        int sellsPop = 0;
        double profitPop = 0;
        int sellsTrap = 0;
        double profitTrap = 0;
        int sellsHouse = 0;
        double profitHouse = 0;
        for (int i = 0; i < allSongs.size(); i++) {
            if (allSongs.get(i).getGenre().equals(SongGenre.ROCK)){
                sellsRock += allSongs.get(i).getSells();
                profitRock += allSongs.get(i).getSells() * allSongs.get(i).getPrice();
            } if (allSongs.get(i).getGenre().equals(SongGenre.POP)) {
                sellsPop += allSongs.get(i).getSells();
                profitPop += allSongs.get(i).getSells() * allSongs.get(i).getPrice();
            } if (allSongs.get(i).getGenre().equals(SongGenre.TRAP)) {
                sellsTrap += allSongs.get(i).getSells();
                profitTrap += allSongs.get(i).getSells() * allSongs.get(i).getPrice();
            } if (allSongs.get(i).getGenre().equals(SongGenre.HOUSE)) {
                sellsHouse += allSongs.get(i).getSells();
                profitHouse += allSongs.get(i).getSells() * allSongs.get(i).getPrice();
            }
        }
        return "- ROCK: Sells - " + sellsRock + " Profit - " + profitRock +
                "\n - POP: Sells - " + sellsPop + " Profit - " + profitPop +
                "\n - TRAP: Sells - " + sellsTrap + " Profit - " + profitTrap +
                "\n - HOUSE: Sells - " + sellsHouse + " Profit - " + profitHouse;
    }
}
