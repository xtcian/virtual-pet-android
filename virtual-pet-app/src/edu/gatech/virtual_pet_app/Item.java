package edu.gatech.virtual_pet_app;

public class Item {
	int item_id;
	String description;
	int price;
	int healthImpact;
	int happinessImpact;
	int hungerImpact;
	Illness sicknessImpact;
	Item(int item_id, String description, int price, int health, int happy, int hunger, Illness sick){
		this.item_id=item_id;
		this.description=description;
		this.price=price;
		healthImpact=health;
		happinessImpact=happy;
		hungerImpact=hunger;
		sicknessImpact=sick;
	}
}
