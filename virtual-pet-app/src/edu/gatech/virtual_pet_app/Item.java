package edu.gatech.virtual_pet_app;

public class Item {
	private int item_id;
	private String description;
	private int price;
	private int healthImpact;
	private int happinessImpact;
	private int hungerImpact;
	private Illness illnessImpact;
	private int quantity;
	private Type type;
	public enum Type {FOOD,TOY,MEDICINE};
	
	public Item(int item_id, String description, int price, int health, int happy, 
			int hunger, Illness sick, Type t, int quantity){
		this.item_id=item_id;
		this.description=description;
		this.price=price;
		healthImpact=health;
		happinessImpact=happy;
		hungerImpact=hunger;
		illnessImpact=sick;
		type=t;
		this.quantity = quantity;
	}
	public Item()
	{
		
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
	public Type getType()
	{
		return type;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
	public void setQuantity(int num)
	{
		this.quantity = num;
	}
}
