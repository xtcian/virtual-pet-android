package edu.gatech.virtual_pet_app;

public class REvent 
{
	private int id;
	private int happiness;
	private int health;
	private int hunger;
	private String illness;
	private String description;
	public REvent(int id, int happiness, int health, int hunger, String illness, String description )
	{
		this.id = id;
		this.happiness = happiness;
		this.health = health;
		this.hunger = hunger;
		this.illness = illness;
		this.description = description;
	}
}
