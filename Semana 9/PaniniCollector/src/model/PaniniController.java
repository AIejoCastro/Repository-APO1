package model;

public class PaniniController {

	private Team[] teams;

	public PaniniController() {

		teams = new Team[32];

	}

	public boolean registerTeam(String teamName, int year, int month, int day) {

		Team myTeam = new Team(teamName, day, month, year);

		for (int i = 0; i < teams.length; i++) {

			if (teams[i] == null) {

				myTeam.setId((i + 1) + "");
				teams[i] = myTeam;
				return true;

			}

		}

		return false;

	}

	public String showTeamsList() {

		String msg = "";

		for (int i = 0; i < teams.length; i++) {

			if (teams[i] != null) {

				msg += "\n" + teams[i].getId() + ". " + teams[i].getName();
			}
		}

		return msg;

	}

	public String showTeams() {

		String msg = "";

		for (int i = 0; i < teams.length; i++) {

			if (teams[i] != null) {

				msg += "\n" + teams[i].toString();
			}
		}

		return msg;

	}

	public boolean registerPlayer(String teamID, String name, String lastName, String id, int shirtNumber,
			String playerPosition) {

		for (int i = 0; i < teams.length; i++) {

			if (teams[i] != null) {

				if ((i + 1 + "").equals(teamID)) {

					return teams[i].addPlayer(name, lastName, id, shirtNumber, playerPosition);

				}

			}

		}

		return false;

	}

}
