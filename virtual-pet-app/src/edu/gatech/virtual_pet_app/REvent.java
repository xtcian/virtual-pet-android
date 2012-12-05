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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHappiness() {
		return happiness;
	}
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHunger() {
		return hunger;
	}
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
