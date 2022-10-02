package model;

public class Enemies {

    private String name;
    private EnemyType type;
    private double losePoints;
    private double winPoints;
    private int positionX;
    private int positionY;

    public Enemies(String name, int type, double losePoints, double winPoints){

        this.name = name;
        this.type = EnemyType.values()[type];
        this.losePoints = losePoints;
        this.winPoints = winPoints;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnemyType getType() {
        return type;
    }

    public void setType(EnemyType type) {
        this.type = type;
    }

    public double getLosePoints() {
        return losePoints;
    }

    public void setLosePoints(double losePoints) {
        this.losePoints = losePoints;
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
        return "Enemies info"
                + "\nName: " + this.name
                + "\nType: " + this.type
                + "\nLose points: " +this.losePoints
                + "\nWin points: " + this.winPoints
                + "\nPosition X: " + this.positionX
                + "\nPosition Y: " + this.positionY;

    }
}
