package model;

public class Treasures {

    private String name;
    private String URL;
    private double winPoints;
    private int positionX;
    private int positionY;

    public Treasures(String name, String URL, double winPoints){

        this.name = name;
        this.URL = URL;
        this.winPoints = winPoints;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public double getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(double winPoints) {
        this.winPoints = winPoints;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String toString() {
        return "Treasures info"
                + "\nName: " + this.name
                + "\nURL: " + this.URL
                + "\nWin points: " + this.winPoints
                + "\nPosition X: " + this.positionX
                + "\nPosition Y: " + this.positionY;
    }
}
