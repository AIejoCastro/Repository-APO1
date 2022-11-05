package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ContentCreator extends Producers{

    private ArrayList<Podcast> podcasts;

    public ContentCreator(String name, String URLImage, LocalDate date) {
        super(name, URLImage, date);
        this.podcasts = new ArrayList<Podcast>();
    }

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    @Override
    public String toString() {
        return "ContentCreator: " +
                "Podcasts: " + podcasts;
    }

    public boolean addPodcast(Podcast newPodcast) {
        return podcasts.add(newPodcast);
    }
}
