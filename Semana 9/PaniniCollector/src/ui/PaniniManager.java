package ui;

import java.util.Scanner;

import model.PaniniController;

public class PaniniManager {

	public static Scanner reader;
	public static PaniniController controller;

	public static void main(String[] args) {

		init();
		showMainMenu();

	}

	public static void init() {

		reader = new Scanner(System.in);
		controller = new PaniniController();

	}

	public static void showMainMenu() {

		System.out.println("Welcome to Panini Collector");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register Teams");
			System.out.println("2. Register Players");
			System.out.println("3. Show Teams Players");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				registerTeam();
				break;
			case 2:
				registerPlayer();
				break;
			case 3:
				showTeams();
				break;
			case 0:
				stopFlag = true;
				System.out.println("Thanks for using our system");
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}

	}

	private static void registerTeam() {

		System.out.println("Type the new Team name: ");
		String teamName = reader.nextLine();
		teamName = reader.nextLine();

		System.out.println("Type the new Team foundation date (YYYY-MM-DD): ");
		String foundationDate = reader.next();

		int year = Integer.parseInt(foundationDate.split("-")[0]);
		int month = Integer.parseInt(foundationDate.split("-")[1]);
		int day = Integer.parseInt(foundationDate.split("-")[2]);

		if (controller.registerTeam(teamName, day, month, year)) {
			System.out.println("The Team " + teamName + " was successfully registered");
		} else {
			System.out.println("The Team " + teamName + " couldn't be registered");
		}

	}

	private static void showTeams() {

		String teamInfo = controller.showTeams();

		if (teamInfo.equals("")) {

			System.out.println("There aren't any Teams registered.");
		} else {

			System.out.println("These are the Teams currently registered:" + teamInfo);

		}

	}

	private static void registerPlayer() {

		String teamList = controller.showTeamsList();

		if (teamList.equals("")) {

			System.out.println("There aren't any Teams registered.");
		} else {

			System.out.println("These are the Teams currently registered:" + teamList);

			System.out.println("Type the ID of the Team you want to register a Player: ");
			String teamID = reader.next();

			System.out.println("Collection Id: ");
			String id = reader.next();
			
			System.out.println("Type the Players's information: ");
			System.out.println("Name: ");
			String name = reader.next();

			System.out.println("Lastname: ");
			String lastName = reader.next();
	
			System.out.println("Shirt number: ");
			int shirtNumber = reader.nextInt();

			reader.nextLine();
			System.out.println(
					"Type the position of the player");
			String playerPosition = reader.nextLine();

			if (controller.registerPlayer(teamID, name, lastName, id, shirtNumber, playerPosition)) {
				System.out.println("Player was successfully registered");
			} else {
				System.out.println("Player couldn't be registered");
			}

		}
	}

}
