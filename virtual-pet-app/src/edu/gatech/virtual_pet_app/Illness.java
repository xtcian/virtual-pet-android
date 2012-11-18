package edu.gatech.virtual_pet_app;

public class Illness 
{
	private int healthImpact;
	private int happinessImpact;
	private String cure;
	private boolean hasIllness;
	
	public Illness()
	{
		healthImpact = 0;
		happinessImpact = 0;
		cure = "";
		hasIllness = 0;
	}
	
	public int getHealthImpact()
	{
		return healthImpact;
	}
	public int getHappinessImpact()
	{
		return healthImpact;
	}
	public String getCure()
	{
		return healthImpact;
	}
	public boolean getHasIllness()
	{
		return hasIllness;
	}
	public void setHealthImpact(int health)
	{
		this.healthImpact = health;
	}
	public void setHappinessImpact(int happiness)
	{
		this.healthImpact = healthImpact;
	}
	public void setCure(String cure)
	{
		this.healthImpact = healthImpact;
	}
	public void getHasIllness(boolean hasIllness)
	{
		this.hasIllness = hasIllness;
	}
}
