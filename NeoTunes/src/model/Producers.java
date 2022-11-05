package model;

import java.time.LocalDate;

public abstract class Producers {

    private String name;
    private String URLImage;
    private LocalDate date;
    private int reproductions;
    private double reproductionTime;

    public Producers(String name, String URLImage, LocalDate date) {
        this.name = name;
        this.URLImage = URLImage;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getReproductions() {
        return reproductions;
    }

    public void setReproductions(int reproductions) {
        this.reproductions = reproductions;
    }

    public double getReproductionTime() {
        return reproductionTime;
    }

    public void setReproductionTime(double reproductionTime) {
        this.reproductionTime = reproductionTime;
    }

    @Override
    public String toString() {
        return "Producers: " +
                "\nName: " + name +
                "\nURL of the image: " + URLImage +
                "\nDate: " + date +
                "\nReproductions: " + reproductions +
                "\nPlayed time: " + reproductionTime;
    }
}
