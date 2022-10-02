package model;

public class Players {

    private String nickanme;
    private String name;
    private double points;
    private int lifes;
    private int level;

    public Players(String nickanme, String name, double points, int lifes, int level){

        this.nickanme = nickanme;
        this.name = name;
        this.points = points;
        this.lifes = lifes;
        this.level = level;
    }

    public String getNickanme(){
        return this.nickanme;
    }

    public void setNickanme(String nickanme){
        this.nickanme = nickanme;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPoints(){
        return  this.points;
    }

    public void setPoints(double points){
        this.points = points;
    }

    public int getLifes(){
        return this.lifes;
    }

    public void setLifes(int lifes){
        this.lifes = lifes;
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public String toString() {
        return "Player info"
                + "\nNickname: " + this.nickanme
                + "\nName: " + this.name
                + "\nPoints: " + this.points
                + "\nlifes: " + this.lifes
                + "\nLevel: " + this.level;
    }
}
