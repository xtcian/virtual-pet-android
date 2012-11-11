package edu.gatech.virtual_pet_app;

import java.util.ArrayList;

public class Pet {
	String name;
	Breed breed;
	int weight;
	int age;
	int health, hunger, happiness;
	Illness sickness;
	Mood mood;
	ArrayList<Item> items;
	/**
	 * Initialize the pet from data read in from database
	 * @param name
	 * @param breed
	 * @param weight
	 * @param age
	 * @param health
	 * @param hunger
	 * @param happiness
	 * @param sickness
	 * @param mood
	 * @param items
	 */
	Pet(String name, Breed breed, int weight, int age, int health, int hunger,
			int happiness, Illness sickness, Mood mood, ArrayList<Item> items) {
		this.name = name;
		this.breed = breed;
		this.weight=weight;
		this.age=age;
		this.health=health;
		this.hunger=hunger;
		this.happiness=happiness;
		this.sickness=sickness;
		this.mood=mood;
		this.items=items;
	}
	
	/**
	 * Pet buys an item, adds it to the item owning list
	 * @param itemBought
	 */
	void buy(Item itemBought){
		items.add(itemBought);
	}
	
	void play(Item toyItem){
		happiness+=toyItem.happinessImpact;
	}
	
	void eat(Item foodItem){
		hunger+=foodItem.hungerImpact;
	}
	
	/**
	 * If the pet takes the right medicine, sickness goes to null and health goes up
	 * health goes down otherwise
	 * @param medicine
	 */
	void takeMedicine(Item medicine){
		if(sickness.equals(medicine.sicknessImpact)){
			sickness=null;
			health+=medicine.healthImpact;
		}else{
			health-=medicine.healthImpact;
		}
	}
	
}
