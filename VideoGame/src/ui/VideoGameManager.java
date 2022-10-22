package ui;

import model.VideoGameController;

import java.util.Scanner;

public class VideoGameManager {

    public static Scanner sc = new Scanner(System.in);
    public static VideoGameController vgController = new VideoGameController();

    public static void main(String[] args){

        menu();

    }

    /**
     * Description: This method is a menu, in which you have to select what you want to do, and it will call other methods
     * pre: You must initiate the program
     * pos: It must do what you select in the menu correctly
     */

    public static void menu() {
        System.out.println("-------------------------"
                + "\nIn which screen are you playing?"
                + "\n1. SD"
                + "\n2. QHD"
                + "\n3. HD"
                + "\n4. FHD"
                + "\n5. QHD"
                + "\n6. UHD"
                + "\n7. UHD8K");
        int screen = sc.nextInt();
        int x = 0;
        int y = 0;
        switch (screen) {
            case 1:
                x = 640;
                y = 480;
                break;
            case 2:
                x = 960;
                y = 540;
                break;
            case 3:
                x = 1280;
                y = 720;
                break;
            case 4:
                x = 1920;
                y = 1080;
                break;
            case 5:
                x = 2560;
                y = 1440;
                break;
            case 6:
                x = 3840;
                y = 2160;
                break;
            case 7:
                x = 7680;
                y = 4320;
                break;
        }
        System.out.println("-------------------------"
                + "\nNow you are going to create the levels");
        addLevel();
        int menu = 0;
        while (menu != 6) {
            System.out.println("-------------------------"
                    + "\nWelcome to this video game, what do you want to do"
                    + "\n1. Enemies"
                    + "\n2. Players"
                    + "\n3. Treasures"
                    + "\n4. Levels"
                    + "\n5. Summary"
                    + "\n6. Exit");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("-------------------------"
                            + "\nYou start enemies menu, what do you want to do"
                            + "\n1. Add enemy"
                            + "\n2. See enemy");
                    int menuEnemies = sc.nextInt();
                    switch (menuEnemies) {
                        case 1:
                            int levelEnemy = 0;
                            while (levelEnemy <= 0 || levelEnemy > 10) {
                                System.out.println("-------------------------"
                                        + "\nIn which level do you want to add the enemy?");
                                levelEnemy = sc.nextInt();
                            }
                            System.out.println("-------------------------"
                                    + "\nNow enter the information to create a enemy");
                            addEnemy(x, y, levelEnemy);
                            break;
                        case 2:
                            int levelEnemies = 0;
                            while (levelEnemies <= 0 || levelEnemies > 10) {
                                System.out.println("-------------------------"
                                        + "\nIn which level do you want to see the enemies?");
                                levelEnemies = sc.nextInt();
                            }
                            String allEnemies = vgController.seeEnemies(levelEnemies);
                            if (allEnemies.equalsIgnoreCase("")) {
                                System.out.println("-------------------------"
                                        + "\nThere are no enemies registered");
                            } else {
                                System.out.println("-------------------------"
                                        + "\nThese are the enemies created: "
                                        + "\n" + allEnemies);
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("-------------------------"
                            + "\nYou start players menu, what do you want to do"
                            + "\n1. Add player"
                            + "\n2. Change player points"
                            + "\n3. See players");
                    int menuPlayers = sc.nextInt();
                    switch (menuPlayers) {
                        case 1:
                            System.out.println("-------------------------"
                                    + "\nNow enter the information to create a player");
                            addPlayer();
                            break;
                        case 2:
                            System.out.println("-------------------------"
                                    + "\nSo, you want to change the player points"
                                    + "\nWhich player do you want to modify the points");
                            String messageNicknamePlayers = vgController.seePlayersNicknames();
                            if (messageNicknamePlayers.equalsIgnoreCase("")) {
                                System.out.println("-------------------------"
                                        + "\nThere are not players registered");
                                break;
                            } else {
                                System.out.println(messageNicknamePlayers);
                                int playerSelected = sc.nextInt();
                                System.out.println("-------------------------"
                                        + "\nHow many points do you want the player have?");
                                double pointsChange = sc.nextDouble();
                                boolean pointsChanged = vgController.changePlayerPoints(playerSelected, pointsChange);
                                if (pointsChanged) {
                                    System.out.println("-------------------------"
                                            + "\nThe player points have been changed");
                                } else {
                                    System.out.println("-------------------------"
                                            + "\nThe player points was not changed");
                                }
                            }
                            break;
                        case 3:
                            String allPlayers = vgController.seePlayers();
                            if (allPlayers.equalsIgnoreCase("")) {
                                System.out.println("-------------------------"
                                        + "\nThere are no players registered");
                            } else {
                                System.out.println("-------------------------"
                                        + "\nThese are the players created: "
                                        + "\n" + allPlayers);
                                break;
                            }

                    }
                    break;
                case 3:
                    System.out.println("-------------------------"
                            + "\nYou start treasures menu, what do you want to do"
                            + "\n1. Add treasure"
                            + "\n2. See treasures");
                    int menuTreasures = sc.nextInt();
                    switch (menuTreasures) {
                        case 1:
                            int levelTreasure = 0;
                            while (levelTreasure <= 0 || levelTreasure > 10) {
                                System.out.println("-------------------------"
                                        + "\nIn which level do you want to add the level?");
                                levelTreasure = sc.nextInt();
                            }
                            System.out.println("-------------------------"
                                    + "\nHow many times do you want to add the treasure to the level?");
                            int levelTreasuresMany = sc.nextInt();
                            System.out.println("-------------------------"
                                    + "\nNow enter the information to create a treasure");
                            addTreasure(levelTreasure, levelTreasuresMany, x, y);
                            break;
                        case 2:
                            int levelTreasures = 0;
                            while (levelTreasures <= 0 || levelTreasures > 10) {
                                System.out.println("-------------------------"
                                        + "\nIn which level do you want to see the treasures?");
                                levelTreasures = sc.nextInt();
                            }
                            String allTreasures = vgController.seeTreasures(levelTreasures);
                            if (allTreasures.equalsIgnoreCase("")) {
                                System.out.println("-------------------------"
                                        + "\nThere are no enemies registered");
                            } else {
                                System.out.println("-------------------------"
                                        + "\nThese are the enemies created: "
                                        + "\n" + allTreasures);
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("-------------------------"
                            + "\nYou start level menu, what do you want to do"
                            + "\n1. See levels");
                    int menuLevels = sc.nextInt();
                    if (menuLevels == 1) {
                        int level = 0;
                        while (level <= 0 || level > 10) {
                            System.out.println("-------------------------"
                                    + "\nWhich level do you want to see?");
                            level = sc.nextInt();
                        }
                        String allLevel = vgController.seeLevel(level);
                        System.out.println("-------------------------"
                                + "\nThis is all the information of the level"
                                + "\n" + allLevel);
                    }
                    break;
                case 5:
                    System.out.println("-------------------------"
                            + "\nYou start summary menu, what do you want to do?"
                            + "\n1. See how many of one treasure are in all the levels"
                            + "\n2. See how many enemies of one type are in all the levels"
                            + "\n3. See the most repeated treasure"
                            + "\n4. See the enemy that give more points and in which level is"
                            + "\n5. How many consonants are in all the enemies names"
                            + "\n6. Top 5 of players");
                    int menuSummary = sc.nextInt();
                    switch (menuSummary){
                        case 1:
                            System.out.println("-------------------------"
                                    + "\nWhich treasure do you want to search");
                            sc.nextLine();
                            String treasureSummary = sc.nextLine();
                            System.out.println("-------------------------"
                                    + "\nThere are " + vgController.treasureSearch(treasureSummary) + " " + treasureSummary + " in all the levels");
                            break;
                        case 2:
                            System.out.println("-------------------------"
                                    + "\nWhich type of enemy do you want to search"
                                    + "\n1. Ogre"
                                    + "\n2. Abstract"
                                    + "\n3. Magic"
                                    + "\n4. Boss");
                            sc.nextLine();
                            int enemySummary = sc.nextInt();
                            System.out.println("-------------------------"
                                    + "\nThere are " + vgController.enemySearch(enemySummary) + " of that type in all the levels");
                            break;
                        case 3:
                            System.out.println("-------------------------"
                                    + "\nThe most repeated treasure is " + vgController.mostRepeatedTreasure());
                            break;
                        case 4:
                            System.out.println("-------------------------"
                                    + "\nThe enemy that give more points is " + vgController.enemyMorePoints());
                            break;
                        case 5:
                            System.out.println("-------------------------"
                                    + "\nThere are " + vgController.consonantsOfEnemies());
                            break;
                        case 6:
                            System.out.println("-------------------------"
                                    + "\nThe top 5 players are: "
                                    + "\n" + vgController.top5Players());
                            break;
                    }
                    break;
                case 6:
                    System.out.println("-------------------------"
                            + "\nGood bye, thank you for playing");
                    break;
            }
        }
    }

    /**
     * Description: The method ask the customer the information necessary to create a level
     * pre: You must initiate the program
     * pos: The info of the level must be correct to send it to collector
     */

    public static void addLevel(){
        int levelCounter = 0;
        while ((levelCounter < 10)){
            int levelNumber = levelCounter + 1;
            System.out.println("-------------------------"
                    + "\nLevel number " + levelNumber);
            System.out.println("-------------------------"
                    + "\nWhat is the maximum points, to pass the level?");
            double levelMaxPoints = sc.nextDouble();
            boolean levelSaved = vgController.addLevels(levelNumber, levelMaxPoints);
            if(levelSaved){
                System.out.println("-------------------------"
                        + "\nThe level was saved correctly");
            }else{
                System.out.println("-------------------------"
                        + "\nThe level was not saved");
            }
            levelCounter++;
        }
    }

    /**
     * Description: The method ask the customer the information necessary to create a enemy
     * pre: You must select the option add an enemy
     * pos: The info of the enemy must be correct to send it to collector
     * @param x int
     * @param y int
     * @param levelEnemy int
     */

    public static void addEnemy(int x, int y, int levelEnemy){
        System.out.println("-------------------------"
                + "\nPlease enter the name");
        sc.nextLine();
        String enemyName = sc.nextLine();
        System.out.println("-------------------------"
                + "\nPlease select the type: "
                + "\n1. Ogre"
                + "\n2. Abstract"
                + "\n3. Magic"
                + "\n4. Boss");
        int enemyType = sc.nextInt();
        System.out.println("-------------------------"
                + "\nHow many points did the enemy will reduce if the player cannot kill him");
        double enemyLosePoints = sc.nextDouble();
        System.out.println("-------------------------"
                + "\nHow many points did the enemy will increase if the player kill him");
        double enemyWinPoints = sc.nextDouble();
        boolean enemySaved = vgController.addEnemies(enemyName, enemyType, enemyLosePoints, enemyWinPoints, x, y, levelEnemy);
        if(enemySaved){
            System.out.println("-------------------------"
                    + "\nThe enemy was saved correctly");
        }else{
            System.out.println("-------------------------"
                    + "\nThe enemy was not saved");
        }
    }

    /**
     * Description: The method ask the customer the information necessary to create a player
     * pre: You must select the option add a player
     * pos: The info of the player must be correct to send it to collector
     */

    public static void addPlayer(){
        System.out.println("-------------------------"
                + "\nPlease enter your nickname");
        sc.nextLine();
        String playerNickname = sc.nextLine();
        System.out.println("-------------------------"
                + "\nPlease enter your name");
        String playerName = sc.nextLine();
        boolean playerSaved = vgController.addPlayer(playerNickname, playerName);
        if(playerSaved){
            System.out.println("-------------------------"
                    + "\nThe player was saved correctly");
        }else{
            System.out.println("-------------------------"
                    + "\nThe player was not saved");
        }
    }

    /**
     * Description: The method ask the customer the information necessary to create a treasure
     * pre: You must select the option add a treasure
     * pos: The info of the treasure must be correct to send it to collector
     * @param levelTreasure int
     * @param levelTreasureMany int
     * @param x int
     * @param y int
     */

    public static void addTreasure(int levelTreasure, int levelTreasureMany, int x, int y){
        System.out.println("-------------------------"
                + "\nPlease enter the name of the treasure");
        sc.nextLine();
        String treasureName = sc.nextLine();
        System.out.println("-------------------------"
                + "\nPlease enter the URL of the image that is going to have the treasure");
        String treasureURL = sc.nextLine();
        System.out.println("-------------------------"
                + "\nPlease enter how many points the treasure will give if it is found");
        double treasureWinPoints = sc.nextDouble();
        boolean treasureSaved = vgController.addTreasure(treasureName, treasureURL, treasureWinPoints, levelTreasure, levelTreasureMany, x, y);
        if(treasureSaved){
            System.out.println("-------------------------"
                    + "\nThe treasure/s was saved correctly");
        }else{
            System.out.println("-------------------------"
                    + "\nThe treasure/s was not saved correctly");
        }
    }
}
