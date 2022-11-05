package model;

public class Podcast extends Audio {

    private String description;
    private PodcastGenre genre;

    public Podcast(String name, String URLImage, double duration, int reproductions, String description, int genre) {
        super(name, URLImage, duration, reproductions);
        this.description = description;
        this.genre = PodcastGenre.values()[genre];
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PodcastGenre getGenre() {
        return genre;
    }

    public void setGenre(PodcastGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Podcast: " +
                "\nDescription: " + description +
                "\nGenre: " + genre;
    }
}
