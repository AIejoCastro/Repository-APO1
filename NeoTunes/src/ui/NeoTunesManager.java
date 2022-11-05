package ui;

import model.NeoTunesController;
import java.util.Scanner;

public class NeoTunesManager {

    private Scanner sc;
    private NeoTunesController neoController;

    public NeoTunesManager() {
        this.sc = new Scanner(System.in);
        this.neoController = new NeoTunesController();
    }

    public static void main (String[] args){
        NeoTunesManager manager = new NeoTunesManager();
        manager.menu();
    }

    public void menu() {
        int menu = 0;
        while (menu != 4) {
            System.out.println("---------------------------------" +
                    "\nHi, welcome to NeoTunes. ¿What do you want to do? " +
                    "\n1. Create new user" +
                    "\n2. Register new audio" +
                    "\n3. Playlists");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("---------------------------------" +
                            "\n¿Which user do you want to create?" +
                            "\n1. Consumer" +
                            "\n2. Producer");
                    int menuUser = sc.nextInt();
                    switch (menuUser) {
                        case 1:
                            System.out.println("---------------------------------" +
                                    "\nPlease insert all the necessary information ");
                            addConsumer();
                            break;
                        case 2:
                            System.out.println("---------------------------------" +
                                    "\nPlease insert all the necessary information");
                            addProducer();
                    }
                    break;
                case 2:
                    System.out.println("---------------------------------" +
                            "\nPlease insert all the necessary information");
                    addAudio();
                    break;
                case 3:
                    System.out.println("---------------------------------" +
                            "\nWhat do you want to do? " +
                            "\n1. Create a playlist" +
                            "\n2. Edit playlist");
                    int menuPlaylist = sc.nextInt();
                    switch (menuPlaylist) {
                        case 1:
                            System.out.println("---------------------------------" +
                                    "\nPlease insert all the necessary information");
                            addPlaylist();
                            break;
                        case 2:
                            System.out.println("---------------------------------" +
                                    "\nPlease insert all the necessary information");

                    }

            }
        }
    }

    public void addConsumer() {
        System.out.println("---------------------------------" +
                "\nDo you want to be a premium user?" +
                "\n1. Yes" +
                "\n2. No");
        sc.nextLine();
        int standardOrPremium = sc.nextInt();
        System.out.println("---------------------------------" +
                "\nPlease enter a nickname ");
        String nickname = sc.nextLine();
        System.out.println("---------------------------------" +
                "\nPlease enter your ID ");
        String id = sc.nextLine();
        if (neoController.addConsumer(standardOrPremium, nickname, id)) {
            System.out.println("---------------------------------" +
                    "\nThe consumer was saved correctly");
        } else {
            System.out.println("---------------------------------" +
                    "\nThe consumer was not saved correctly");
        }
    }

    public void addProducer() {
        System.out.println("---------------------------------" +
                "\nWhat do you want to be?" +
                "\n1. Artist" +
                "\n2. Content Creator");
        sc.nextLine();
        int artistOrContentCreator = sc.nextInt();
        System.out.println("---------------------------------" +
                "\nPlease enter your name ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("---------------------------------" +
                "\nPlease enter an URL image of you ");
        String URLImage = sc.nextLine();
        if (neoController.addProducer(artistOrContentCreator, name, URLImage)) {
            System.out.println("---------------------------------" +
                    "\nThe consumer was saved correctly");
        } else {
            System.out.println("---------------------------------" +
                    "\nThe consumer was not saved correctly");
        }
    }

    public void addAudio() {
        System.out.println("---------------------------------" +
                "\nPlease enter your nickname or name ");
        sc.nextLine();
        String producerName = sc.nextLine();
        System.out.println("---------------------------------" +
                "\n¿What do you want to create?" +
                "\n1. Song" +
                "\n2. Podcast");
        int songOrPodcast = sc.nextInt();
        switch (songOrPodcast) {
            case 1:
                System.out.println("---------------------------------" +
                        "\nPlease enter the name of the song ");
                sc.nextLine();
                String songName = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nPlease enter the name of the album ");
                String albumName = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nWhich is the genre of the song: " +
                        "\n1. Rock " +
                        "\n2. Pop " +
                        "\n3. Trap " +
                        "\n4. House");
                int songGenre = sc.nextInt();
                System.out.println("---------------------------------" +
                        "\nPlease enter the URL of the album image ");
                sc.nextLine();
                String URLImageSong = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nPlease enter the song duration in seconds ");
                double songDuration = sc.nextDouble();
                System.out.println("---------------------------------" +
                        "\nPlease enter the price of the song in dollars ");
                double songPrice = sc.nextDouble();
                if (neoController.addSong(producerName, songName, albumName, songGenre, URLImageSong, songDuration, songPrice)) {
                    System.out.println("---------------------------------" +
                            "\nThe song was saved correctly");
                } else {
                    System.out.println("---------------------------------" +
                            "\nThe song was not saved correctly");
                }
                break;
            case 2:
                System.out.println("---------------------------------" +
                        "\nPlease enter the name of the podcast ");
                sc.nextLine();
                String podcastName = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nPlease enter the description of the podcast");
                String podcastDescription = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nWhich is the genre of the podcast: " +
                        "\n1. Politics" +
                        "\n2. Entertainment" +
                        "\n3. VideoGames" +
                        "\n4. Fashion");
                int podcastGenre = sc.nextInt();
                System.out.println("---------------------------------" +
                        "\nPlease enter the URL of the image ");
                sc.nextLine();
                String URLImagePodcast = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nPlease enter the podcast duration in seconds ");
                double podcastDuration = sc.nextDouble();
                if (neoController.addPodcast(producerName, podcastName, podcastDescription, podcastGenre,URLImagePodcast, podcastDuration)) {
                    System.out.println("---------------------------------" +
                            "\nThe podcast was saved correctly");
                } else {
                    System.out.println("---------------------------------" +
                            "\nThe podcast was not saved correctly");
                }
                break;
        }
    }

    public void addPlaylist() {
        System.out.println("---------------------------------" +
                "\nPlease enter your nickname or name");
        sc.nextLine();
        String consumerName = sc.nextLine();
        System.out.println("---------------------------------" +
                "\nPlease enter the name of the playlist");
        String playlistName = sc.nextLine();
        if (neoController.addPlaylist(consumerName, playlistName)) {
            System.out.println("---------------------------------" +
                    "\nThe playlist was saved correctly");
        } else {
            System.out.println("---------------------------------" +
                    "\nThe playlist was not saved correctly");
        }
    }

    public void editPlaylist() {
        System.out.println("---------------------------------" +
                "\nPlease enter your nickname");
        sc.nextLine();
        String consumerName = sc.nextLine();
        System.out.println("---------------------------------" +
                "\n¿What do you want to do?" +
                "\n1. Add audios" +
                "\n2. Delete audios");
        int playlistMenu = sc.nextInt();
        switch (playlistMenu) {
            case 1:
                System.out.println("---------------------------------" +
                        "\nPlease enter the name of the playlist you want to modify");
                String playlistName = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nPlease enter the name of the audio");
                String audioName = sc.nextLine();
                if (neoController.editPlaylist(consumerName, playlistName, audioName, playlistMenu)) {
                    System.out.println("---------------------------------" +
                            "\nThe audio was saved correctly in the playlist");
                } else {
                    System.out.println("---------------------------------" +
                            "\nThe audio was not saved correctly in the playlist");
                }
                break;
            case 2:
                System.out.println("---------------------------------" +
                        "\nPlease enter the name of the playlist you want to modify");
                String playlistNameDelete = sc.nextLine();
                System.out.println("---------------------------------" +
                        "\nPlease enter the name of the audio");
                String audioNameDelete = sc.nextLine();
                if (neoController.editPlaylist(consumerName, playlistNameDelete, audioNameDelete, playlistMenu)) {
                    System.out.println("---------------------------------" +
                            "\nThe audio was deleted correctly in the playlist");
                } else {
                    System.out.println("---------------------------------" +
                            "\nThe audio was not deleted correctly in the playlist");
                }
                break;
        }
    }
}
