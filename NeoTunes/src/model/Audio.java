package model;

public abstract class Audio {

    private String name;
    private String URLImage;
    private double duration;
    private int reproductions;

    public Audio(String name, String URLImage, double duration, int reproductions) {
        this.name = name;
        this.URLImage = URLImage;
        this.duration = duration;
        this.reproductions = reproductions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURLImage() {
        return URLImage;
    }

    public void setURLImage(String URLImage) {
        this.URLImage = URLImage;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getReproductions() {
        return reproductions;
    }

    public void setReproductions(int reproductions) {
        this.reproductions = reproductions;
    }

    @Override
    public String toString() {
        return "Audio: " +
                "\nName: " + name +
                "\nURL image: " + URLImage +
                "\nDuration: " + duration +
                "\nReproductions: " + reproductions;
    }
}
