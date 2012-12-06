package edu.gatech.virtual_pet_app;

public class Illness {
	private String name;
	private int healthImpact;
	private int happinessImpact;
	private String description;

	public Illness(String name,int health, int happy, String description) {
		this.name=name;
		healthImpact = health;
		happinessImpact = happy;
		this.description = description;

	}
	public String getName(){
		return name;
	}

	public int getHealthImpact() {
		return healthImpact;
	}

	public int getHappinessImpact() {
		return happinessImpact;
	}

}

