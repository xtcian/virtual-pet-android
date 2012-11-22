package edu.gatech.virtual_pet_app;

public class Item {
	int item_id;
	String description;
	int price;
	int healthImpact;
	int happinessImpact;
	int hungerImpact;
	Illness illnessImpact;
	Type type;
	
	public enum Type {FOOD,TOY,MEDICINE};
	
	public Item(int item_id, String description, int price, int health, int happy, int hunger, Illness sick, Type t){
		this.item_id=item_id;
		this.description=description;
		this.price=price;
		healthImpact=health;
		happinessImpact=happy;
		hungerImpact=hunger;
		illnessImpact=sick;
		type=t;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public int getHealthImpact()
	{
		return this.healthImpact;
	}
	
	public int getHappinessImpact()
	{
		return this.happinessImpact;
	}
	public int getHungerImpact()
	{
		return this.hungerImpact;
	}
	public Illness getIllnessImpact()
	{
		return this.illnessImpact;
	}
	public String getDescription()
	{
		return this.description;
	}
}
