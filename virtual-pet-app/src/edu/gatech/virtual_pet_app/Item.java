package edu.gatech.virtual_pet_app;

public class Item {
	int item_id;
	String description;
	int price;
	int healthImpact;
	int happinessImpact;
	int hungerImpact;
	Illness illness;
	
	public Item(int item_id, String description, int price, int health, int happy, int hunger, Illness sick){
		this.item_id=item_id;
		this.description=description;
		this.price=price;
		healthImpact=health;
		happinessImpact=happy;
		hungerImpact=hunger;
		sicknessImpact=sick;
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
	public Illness getIllness()
	{
		return this.illness;
	}
	public String getDescription()
	{
		return this.description;
	}
}
