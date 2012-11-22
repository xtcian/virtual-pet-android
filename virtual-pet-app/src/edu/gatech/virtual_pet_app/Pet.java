package edu.gatech.virtual_pet_app;


public class Pet {
	String name;
	Breed breed;
	int weight;
	int age;
	int health, hunger, happiness;
	Illness illness;
	Mood mood;
	Inventory inventory;
	
	/**
	 * Mood impacts happiness and random event generations
	 * Contains HAPPY SAD ANGRY CONTENT
	 * @author Leshi
	 *
	 */
	enum Mood{HAPPY, SAD, ANGRY, CONTENT};
	
	/**
	 * Initialize the pet from data read in from database
	 * @param name
	 * @param breed
	 * @param weight
	 * @param age
	 * @param health
	 * @param hunger
	 * @param happiness
	 * @param illness
	 * @param mood
	 * @param items
	 */
	Pet(String name, Breed breed, int weight, int age, int health, int hunger,
			int happiness, Illness illness, Mood mood, Inventory inventory) {
		this.name = name;
		this.breed = breed;
		this.weight=weight;
		this.age=age;
		this.health=health;
		this.hunger=hunger;
		this.happiness=happiness;
		this.illness=illness;
		this.mood=mood;
		this.inventory=inventory;
	}

	void play(Item toyItem){
		happiness+=toyItem.happinessImpact;
	}
	
	void eat(Item foodItem){
		hunger+=foodItem.hungerImpact;
	}
	
	/**
	 * If the pet takes the right medicine, illness goes to null and health goes up
	 * health goes down otherwise
	 * @param medicine
	 */
	void takeMedicine(Item medicine)
	{
		if(illness.equals(medicine.illnessImpact)){
			this.illness=null;
			health+=medicine.healthImpact;
		}
		else
		{
			health-=medicine.healthImpact;
		}
	}
	
	
}
