package model;

import static jdk.nashorn.internal.objects.NativeString.indexOf;

public class VideoGameController {

    private Level[] levels;
    private Player[] players;
    private String[] levelsMostRepeated;
    private int[] treasureMostRepeated;
    private String[] enemiesWithMorePoints;
    private int[] enemiesWithMorePointsNum;

    public VideoGameController(){

        this.levels = new Level[10];
        this.players = new Player[20];
        this.levelsMostRepeated = new String[10];
        this.treasureMostRepeated = new int[10];
        this.enemiesWithMorePoints = new String[10];
        this.enemiesWithMorePointsNum = new int[10];

    }

    /**
     * Description: This method create a level and save it in a null space in array levels
     * pre: You must send the info to the method to it to be possible to create the object, and you must initiate the program
     * pos: The object must be created and saved in a null space in levels array
     * @param levelNumber int
     * @param levelMaxPoints double
     * @return boolean
     */

    public boolean addLevels(int levelNumber, double levelMaxPoints){
        Level levelCreated = new Level(levelNumber, levelMaxPoints);
        for(int i = 0; i < levels.length; i++){
            if(levels[i] == null){
                levels[i] = levelCreated;
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This method create an enemy and save it in a null space in the array of enemies in the level selected
     * pre: You must send the info to the method to it to be possible to create the object, and you have to select the option add enemy
     * pos: The object must be created and saved in a null space in enemies array in the level selected
     * @param enemyName String
     * @param enemyType int
     * @param enemyLosePoints double
     * @param enemyWinPoints double
     * @param x int
     * @param y int
     * @param levelEnemy int
     * @return boolean
     */

    public boolean addEnemies(String enemyName, int enemyType, double enemyLosePoints, double enemyWinPoints, int x, int y, int levelEnemy){
        int positionX = (int) (Math.random() * x);
        int positionY = (int) (Math.random() * y);
        enemyType --;
        Enemy enemyCreated = new Enemy(enemyName, enemyType, enemyLosePoints, enemyWinPoints, positionX, positionY);
        boolean enemySaved = levels[levelEnemy - 1].addEnemies(enemyCreated);
        if(enemySaved){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Description: This method create a level and save it in a null space in the array of players
     * pre: You must send the info to the method to it to be possible to create the object, and you have to select the option add player
     * pos: The object must be created and saved in a null space in players array
     * @param playerNickname String
     * @param playerName String
     * @return boolean
     */

    public boolean addPlayer(String playerNickname, String playerName){
        for(int i = 0; i < players.length; i++){
            for(int j = 0; j < players.length; j++){
                if(players[j] != null){
                    if(players[j].getNickanme().equalsIgnoreCase(playerNickname)){
                        return false;
                    }
                }
            }
        }
        Player playerCreated = new Player(playerNickname, playerName, 10, 5, 1);
        for(int i = 0; i < players.length; i++){
            if(players[i] == null){
                players[i] = playerCreated;
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This method create a level and save it in a null space in the array of treasures in the level selected
     * pre: You must send the info to the method to it to be possible to create the object, and you have to select the option add treasures
     * pos: The object must be created and saved in a null space in treasure array in the level selected
     * @param treasureName String
     * @param treasureURL String
     * @param treasureWinPoints double
     * @param levelTreasure int
     * @param levelTreasureMany int
     * @param x int
     * @param y int
     * @return boolean
     */

    public boolean addTreasure(String treasureName, String treasureURL, double treasureWinPoints, int levelTreasure, int levelTreasureMany, int x, int y){
        int treasuresCounter = 0;
        for(int i = 0; i < levelTreasureMany; i++){
            int positionX = (int) (Math.random() * x);
            int positionY = (int) (Math.random() * y);
            Treasure treasureCreated = new Treasure(treasureName, treasureURL, treasureWinPoints, positionX, positionY);
            boolean treasureSaved = levels[levelTreasure - 1].addTreasures(treasureCreated);
            if(treasureSaved){
                treasuresCounter++;
            }
        }
        if(treasuresCounter == levelTreasureMany){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Description: This method save the toString of the enemies and send it to manager
     * pre: You must select the option see enemies and select the respectively level
     * pos: The toString of all the enemies in the level selected must be correctly saved in the String variable
     * @param levelEnemies int
     * @return allEnemies String
     */

    public String seeEnemies(int levelEnemies){
        String allEnemies = levels[levelEnemies - 1].seeEnemies();
        return allEnemies;
    }

    /**
     * Description: This method save the toString of a player and send it to manager
     * pre: You must select the option see players and select the respectively player
     * pos: The toString of the player selected must be correctly saved in the String variable
     * @return allPlayers String
     */

    public String seePlayers(){
        String allPlayers = "";
        for(int i = 0; i < players.length; i++){
            if(players[i] != null){
                allPlayers += players[i].toString();
            }
        }
        return allPlayers;
    }

    /**
     * Description: This method save the toString of the treasures and send it to manager
     * pre: You must select the option see treasures and select the respectively level
     * pos: The toString of all the treasures in the level selected must be correctly saved in the String variable
     * @param levelTreasures int
     * @return allTreasures String
     */

    public String seeTreasures(int levelTreasures){
        String allTreasures = levels[levelTreasures].seeTreasures();
        return allTreasures;
    }

    /**
     * Description: This method save the toString of a level and send it to manager
     * pre: You must select the option see levels and select the respectively level
     * pos: The toString of the levels selected must be correctly saved in the String variable
     * @param level int
     * @return allLevel String
     */

    public String seeLevel(int level){
        String allLevel = levels[level - 1].toString();
        return allLevel;
    }

    /**
     * Description: This method save a list in which you can see the nicknames of the players created
     * pre: You must select the options player and change player points
     * pos: The nicknames must be in a String in which they are in a list format, and must be the nicknames correctly
     * @return messageNicknamePlayers String
     */

    public String seePlayersNicknames(){
        String messageNicknamePlayers = "";
        int j = 0;
        for(int i = 0; i < players.length;i++){
            if(players[i] != (null)){
                j = i + 1;
                messageNicknamePlayers += j + ". " + players[i].getNickanme() + "\n";
            }
        }
        return messageNicknamePlayers;
    }

    /**
     * Description: This method change the points and consequently the level in which the player is
     * pre: You must select the option change player points
     * pos: The points and the level of the player must be changed correctly at the values the user insert
     * @param playerSelected int
     * @param pointsChange double
     * @return boolean
     */

    public boolean changePlayerPoints(int playerSelected, double pointsChange){
        playerSelected--;
        players[playerSelected].setPoints(pointsChange);
        for(int i = 0; i <= 8; i++){
            if(levels[i].getMaxPoints() <= players[playerSelected].getPoints() && players[playerSelected].getPoints() < levels[i + 1].getMaxPoints()) {
                players[playerSelected].setLevel(i);
                return true;
            }
        }
        if(levels[9].getMaxPoints() <= players[playerSelected].getPoints()){
            players[playerSelected].setLevel(9);
            return true;
        }
        return false;
    }

    /**
     * Description: This method search how many treasures of one type is in all levels
     * pre: You must select the option summary and see how many treasures are in all levels
     * pos: It must send how many times the treasure is in all levels
     * @param treasureSummary String
     * @return treasureCounter int
     */

    public int treasureSearch(String treasureSummary){
        int treasureCounter = 0;
        for(int i = 0; i < levels.length; i++){
            if(levels[i] != null){
                treasureCounter += levels[i].treasuresSearch(treasureSummary);
            }
        }
        return treasureCounter;
    }

    /**
     * Description: This method search how many enemies of one type is in all levels
     * pre: You must select the option summary and see how many enemies of one type are in all levels
     * pos: It must send how many times the enemy type is in all levels
     * @param enemySummary int
     * @return enemyCounter int
     */

    public int enemySearch(int enemySummary){
        int enemyCounter = 0;
        for(int i = 0; i < levels.length; i++){
            if(levels[i] != null){
                enemyCounter += levels[i].enemiesSearch(enemySummary);
            }
        }
        return enemyCounter;
    }

    /**
     * Description: This method search which is the most repeated treasure in all the levels
     * pre: You must select the option summary and see the most repeated treasure
     * pos: It must send the name of most repeated treasure
     * @return levelsMostRepeatedString[positionTreasure] String
     */

    public String mostRepeatedTreasure(){
        for (int i = 0; i < levels.length; i++){
            if (levelsMostRepeated[i] == null){
                levelsMostRepeated[i] = levels[i].mostRepeatedTreasures();
            }
        }
        int treasureCounter = 0;
        for (int i = 0; i < levelsMostRepeated.length; i++){
            for (int j = 0; j < levelsMostRepeated.length; j++){
                if (levelsMostRepeated[i].equalsIgnoreCase(levelsMostRepeated[j])){
                    treasureCounter++;
                }
            }
            treasureMostRepeated[i] = treasureCounter;
            treasureCounter = 0;
        }
        int bigger = treasureMostRepeated[0];
        for (int i = 1; i < treasureMostRepeated.length; i++){
            if (treasureMostRepeated[i] > bigger){
                bigger = treasureMostRepeated[i];
            }
        }
        int positionTreasure = 0;
        for (int i = 0; i < treasureMostRepeated.length; i++){
            if (bigger == treasureMostRepeated[i]){
                positionTreasure = indexOf(treasureMostRepeated, bigger);
            }
        }
        return levelsMostRepeated[positionTreasure];
    }

    /**
     * Description: This method search the enemy that gives more points in all the levels
     * pre: You must select the option summary and see the enemy that give more points and in which level is
     * pos: It must send the name and the level of the enemy that gives more points in all the levels
     * @return biggerEnemyName String
     */

    public String enemyMorePoints(){
        for (int i = 0; i < levels.length; i ++){
            if(levels[i] != null) {
                if (enemiesWithMorePoints[i] == null) {
                    enemiesWithMorePoints[i] = levels[i].enemyWithMorePoints();
                }
            }
        }
        int enemyCounter = 0;
        for (int i = 0; i < enemiesWithMorePoints.length; i++){
            for (int j = 0; j < enemiesWithMorePoints.length; j++){
                if (enemiesWithMorePoints[i].equalsIgnoreCase(enemiesWithMorePoints[j])){
                    enemyCounter++;
                }
            }
            enemiesWithMorePointsNum[i] = enemyCounter;
            enemyCounter = 0;
        }
        int biggerEnemy = enemiesWithMorePointsNum[0];
        String biggerEnemyName = enemiesWithMorePoints[0];
        for (int i = 1; i < enemiesWithMorePointsNum.length; i++){
            if (enemiesWithMorePointsNum[i] > biggerEnemy){
                biggerEnemy = enemiesWithMorePointsNum[i];
                biggerEnemyName = enemiesWithMorePoints[i] + " it is in the level " + i + 1;
            }
        }
        return biggerEnemyName;
    }

    /**
     * Description: This method counts how many consonants are in the names of the enemies in all the levels
     * pre: You must select the option summary and how many consonants are in all the enemies names
     * pos: It must return how many consonants in the enemies names are in all the level
     * @return consonantsEnemies int
     */

    public int consonantsOfEnemies(){
        int consonantsEnemies = 0;
        for (int i = 0; i < levels.length; i++){
            if (levels[i] != null){
                consonantsEnemies += levels[i].consonantsEnemies();
            }
        }
        return consonantsEnemies;
    }

    /**
     * Description: This method makes a top 5 of the players comparing the points
     * pre: You must select the option summary and top 5 of players
     * pos: It must return the top 5 of the players comparing the points
     * @return allTop String
     */

    public String top5Players(){
        String top1 = "";
        int position1 = 0;
        double bigger = 0;
        for (int i = 0; i < players.length; i++){
            if (players[i] != null){
                if (players[i].getPoints() > bigger){
                    bigger = players[i].getPoints();
                    position1 = i;
                    top1 = players[i].getNickanme();
                }
            }
        }
        bigger = 0;
        String top2 = "";
        int position2 = 0;
        for (int i = 0; i < players.length; i++){
            if (players[i] != null && i != position1){
                if (players[i].getPoints() > bigger){
                    bigger = players[i].getPoints();
                    position2 = i;
                    top2 = players[i].getNickanme();
                }
            }
        }
        bigger = 0;
        String top3 = "";
        int position3 = 0;
        for (int i = 0; i < players.length; i++){
            if (players[i] != null && i != position1 && i != position2){
                if (players[i].getPoints() > bigger){
                    bigger = players[i].getPoints();
                    position3 = i;
                    top3 = players[i].getNickanme();
                }
            }
        }
        bigger = 0;
        String top4 = "";
        int position4 = 0;
        for (int i = 0; i < players.length; i++){
            if (players[i] != null && i != position1 && i != position2 && i != position3){
                if (players[i].getPoints() > bigger){
                    bigger = players[i].getPoints();
                    position4 = i;
                    top4 = players[i].getNickanme();
                }
            }
        }
        bigger = 0;
        String top5 = "";
        int position5 = 0;
        for (int i = 0; i < players.length; i++){
            if (players[i] != null && i != position1 && i != position2 && i != position3 && i != position4){
                if (players[i].getPoints() > bigger){
                    bigger = players[i].getPoints();
                    position5 = i;
                    top5 = players[i].getNickanme();
                }
            }
        }
        String allTop = "Top 1: " + top1
                + "\nTop 2: " + top2
                + "\nTop 3: " + top3
                + "\nTop 4: " + top4
                + "\nTop 5: " + top5;
        return allTop;
    }
}
