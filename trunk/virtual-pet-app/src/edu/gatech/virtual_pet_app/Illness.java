package edu.gatech.virtual_pet_app;

public class Illness {
	private String name;
	private int healthImpact;
	private int happinessImpact;

	public Illness(String name,int health, int happy) {
		this.name=name;
		healthImpact = health;
		happinessImpact = happy;

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
