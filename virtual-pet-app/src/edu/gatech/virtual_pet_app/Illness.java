package edu.gatech.virtual_pet_app;

public class Illness {
	private int healthImpact;
	private int happinessImpact;

	public Illness(int health, int happy) {
		healthImpact = health;
		happinessImpact = happy;

	}

	public int getHealthImpact() {
		return healthImpact;
	}

	public int getHappinessImpact() {
		return happinessImpact;
	}

}
