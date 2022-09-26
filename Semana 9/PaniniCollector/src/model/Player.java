package model;

public class Player {

	private String name;
	private String lastName;
	private String collectionId;
	private int shirtNumber;
	private String playerPosition;

	public Player(String name, String lastName, String id, int shirtNumber, String playerPosition) {

		this.name = name;
		this.lastName = lastName;
		this.collectionId = id;
		this.shirtNumber = shirtNumber;
		this.playerPosition = playerPosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String id) {
		this.collectionId = id;
	}

	public int getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	public String toString() {
		return "Player:\nCollection Id: " + collectionId + "\nFullname: " + name + " " + lastName + "\nShirt Number: "
				+ shirtNumber + "\nPosition: " + playerPosition;
	}
}
