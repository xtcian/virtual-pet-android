package edu.gatech.virtual_pet_app;

public class Mood 
{
	int happinessImpact;
	String type;
	
	public Mood()
	{
		happinessImpact = 0;
		type = "Content";
	}
	public Mood(happiness, type)
	{
		this.happinessImpact = happiness;
		this.type = type;
	}
	
}
