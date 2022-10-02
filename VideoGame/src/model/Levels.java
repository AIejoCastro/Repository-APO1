package model;

public class Levels {

    private int number;
    private double maxPoints;
    private Treasures[] treasures;
    private Enemies[] enemy;
    private LevelsDifficulty difficulty;

    public Levels(int number, double maxPoints){

        this.number = number;
        this.maxPoints = maxPoints;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(double maxPoints) {
        this.maxPoints = maxPoints;
    }

    public Treasures[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasures[] treasures) {
        this.treasures = treasures;
    }

    public Enemies[] getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemies[] enemy) {
        this.enemy = enemy;
    }

    public LevelsDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(LevelsDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String toString() {
        String message = "Level info"
                + "\nNumber: " + this.number
                + "\nMax points: " + this.maxPoints
                + "\nTreasures: ";

        for(int i = 0; i < treasures.length; i++){
            if(treasures[i] != null){
                message += treasures.toString();
            }
        }

        message += "\nEnemies: ";

        for(int i = 0; i < enemy.length; i++){
            if(enemy[i] != null){
                message += enemy.toString();
            }
        }

        message = "\nDifficulty: " + this.difficulty;

        return message;

    }
}
