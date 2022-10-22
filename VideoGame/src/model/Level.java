package model;

import static jdk.nashorn.internal.objects.NativeString.indexOf;

public class Level {

    private int number;
    private double maxPoints;
    private Treasure[] treasures;
    private Enemy[] enemies;
    private int[] treasuresMostRepeated;
    private LevelDifficulty difficulty;

    public Level(int number, double maxPoints){

        this.number = number;
        this.maxPoints = maxPoints;
        this.enemies = new Enemy[25];
        this.treasures = new Treasure[50];
        this.treasuresMostRepeated = new int[25];

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

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Enemy[] getEnemy() {
        return enemies;
    }

    public void setEnemy(Enemy[] enemy) {
        this.enemies = enemy;
    }

    public LevelDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(LevelDifficulty difficulty) {
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

        for(int i = 0; i < enemies.length; i++){
            if(enemies[i] != null){
                message += enemies.toString();
            }
        }

        message = "\nDifficulty: " + this.difficulty;

        return message;

    }

    /**
     * Description: This method search if the name of the enemy is not repeated and then if it is not, it save it in a null space in enemies array
     * pre: You must send the object to the method to it to be possible compare and save the object, and you have to select the option add enemy
     * pos: The object must be saved or not in a null space in enemies array
     * @param enemyCreated Enemy
     * @return boolean
     */

    public boolean addEnemies(Enemy enemyCreated){
        for(int i = 0; i < enemies.length; i++){
            for(int j = 0; j < enemies.length; j++){
                if(enemies[j] != null){
                    if(enemies[i].getName().equalsIgnoreCase(enemyCreated.getName())) {
                        return false;
                    }
                }
            }
        }
        for(int i = 0; i < enemies.length; i++){
            if(enemies[i] == null){
                enemies[i] = enemyCreated;
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This method save the object in a null space in the treasures array
     * pre: You must send the object to the method to it to be possible compare and save the object, and you have to select the option add treasure
     * pos: The object must be saved or not in a null space in enemies array
     * @param treasureCreated Treasure
     * @return boolean
     */

    public boolean addTreasures(Treasure treasureCreated){
        for(int i = 0; i < treasures.length; i++){
            if(treasures[i] == null){
                treasures[i] = treasureCreated;
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This method save the toString of all the enemies in enemies array in allEnemies
     * pre: You must select the option see enemies and select the respectively level
     * pos: The toString of all the enemies must be saved in the allEnemies
     * @return allEnemies String
     */

    public String seeEnemies(){
        String allEnemies = "";
        for(int i = 0; i < enemies.length; i++){
            if(enemies[i] != null){
                allEnemies += enemies[i].toString();
            }
        }
        return allEnemies;
    }

    /**
     * Description: This method save the toString of all the treasures in treasures array in allTreasures
     * pre: You must select the option see treasures and select the respectively level
     * pos: The toString of all the treasures must be saved in the allTreasures
     * @return allTreasures String
     */

    public String seeTreasures(){
        String allTreasures = "";
        for(int i = 0; i < treasures.length; i++){
            if(treasures[i] != null){
                allTreasures += treasures[i].toString();
            }
        }
        return allTreasures;
    }

    /**
     * Description: This method search the treasure name the user gave us to see how many there are in the level
     * pre: You must select the option summary and see the most repeated treasure
     * pos: It must send how many of that treasure is in the level
     * @param treasureSummary String
     * @return treasureCounter int
     */

    public int treasuresSearch(String treasureSummary){
        int treasureCounter = 0;
        for(int i = 0; i < treasures.length; i++){
            if(treasures[i] != null){
                if(treasures[i].getName().equalsIgnoreCase(treasureSummary)){
                    treasureCounter++;
                }
            }
        }
        return treasureCounter;
    }

    /**
     * Description: This method search how many enemies of one type is in the level
     * pre: You must select the option summary and see how many enemies of one type are in all levels
     * pos: It must send how many times the enemy type is in the level
     * @param enemySummary int
     * @return enemyCounter int
     */

    public int enemiesSearch(int enemySummary){
        int enemyCounter = 0;
        for(int i = 0; i < enemies.length; i++){
            if(enemies[i] != null){
                switch (enemySummary){
                    case 1:
                        if(enemies[i].getType().equals(EnemyType.OGRE)){
                            enemyCounter++;
                        }
                        break;
                    case 2:
                        if(enemies[i].getType().equals(EnemyType.ABSTRACT)){
                            enemyCounter++;
                        }
                        break;
                    case 3:
                        if(enemies[i].getType().equals(EnemyType.MAGIC)){
                            enemyCounter++;
                        }
                        break;
                    case 4:
                        if(enemies[i].getType().equals(EnemyType.BOSS)){
                            enemyCounter++;
                        }
                        break;
                }
            }
        }
        return enemyCounter;
    }

    /**
     * Description: This method search which is the most repeated treasure in the level
     * pre: You must select the option summary and see the most repeated treasure
     * pos: It must send the name of most repeated treasure in the level
     * @return treasures[positionTreasure] String
     */

    public String mostRepeatedTreasures(){
        int treasuresCounter = 0;
        for (int i = 0; i < treasures.length; i++){
            for (int j = 0; j < treasures.length; j++){
                if (treasures[i].getName().equalsIgnoreCase(treasures[j].getName())){
                    treasuresCounter++;
                }
            }
            treasuresMostRepeated[i] = treasuresCounter;
            treasuresCounter = 0;
        }
        int bigger = treasuresMostRepeated[0];
        for (int i = 1; i < treasuresMostRepeated.length; i++){
            if (treasuresMostRepeated[i] > bigger){
                bigger = treasuresMostRepeated[i];
            }
        }
        int positionTreasure = 0;
        for (int i = 0; i < treasuresMostRepeated.length; i++){
            if (bigger == treasuresMostRepeated[i]){
                positionTreasure = indexOf(treasuresMostRepeated, bigger);
            }
        }
        return treasures[positionTreasure].getName();
    }

    /**
     * Description: This method search the enemy that gives more points in the level
     * pre: You must select the option summary and see the enemy that give more points and in which level is
     * pos: It must send the name of the enemy that gives more points in the level
     * @return biggerEnemyName String
     */

    public String enemyWithMorePoints(){
        double biggerEnemy = enemies[0].getWinPoints();
        String biggerEnemyName = enemies[0].getName();
        for (int i = 1; i < enemies.length; i++){
            if (enemies[i].getWinPoints() > biggerEnemy){
                biggerEnemy = enemies[i].getWinPoints();
                biggerEnemyName = enemies[i].getName();
            }
        }
        return biggerEnemyName;
    }

    /**
     * Description: This method counts how many consonants are in the names of the enemies in the level
     * pre: You must select the option summary and how many consonants are in all the enemies names
     * pos: It must return how many consonants in the enemies names are in the leve
     * @return consonantsCounter int
     */

    public int consonantsEnemies(){
        int consonantsCounter = 0;
        String enemyName = "";
        String enemyCharacter = "";
        String enemyNameModified = "";
        for (int i = 0; i < enemies.length; i++){
            if (enemies[i] != null){
                enemyName = enemies[i].getName();
                enemyNameModified =  enemyName.replace(" ", "");
                for (int j = 0; j <= enemyNameModified.length(); j++){
                    enemyCharacter = String.valueOf(enemyNameModified.charAt(j));
                    if (!enemyCharacter.equalsIgnoreCase("a") && !enemyCharacter.equalsIgnoreCase("e") && !enemyCharacter.equalsIgnoreCase("i") && !enemyCharacter.equalsIgnoreCase("o") && !enemyCharacter.equalsIgnoreCase("u")){
                        consonantsCounter ++;
                    }
                }
            }
        }
        return consonantsCounter;
    }
}
