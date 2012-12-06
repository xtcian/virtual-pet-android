package edu.gatech.virtual_pet_app;

public class Illness {
	private String name;
	private int healthImpact;
	private int happinessImpact;
	private String description;

	public Illness(String name,int health, int happy, String description) {
		this.setName(name);
		setHealthImpact(health);
		setHappinessImpact(happy);
		this.setDescription(description);

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setHealthImpact(int healthImpact) {
		this.healthImpact = healthImpact;
	}

	public int getHealthImpact() {
		return healthImpact;
	}

	public void setHappinessImpact(int happinessImpact) {
		this.happinessImpact = happinessImpact;
	}

	public int getHappinessImpact() {
		return happinessImpact;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	

}

