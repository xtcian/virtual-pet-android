
package edu.gatech.virtual_pet_app;

public class Pet {
	private String name;
	private int weight;
	private int age;
	private int health, hunger, happiness;
	private Illness illness;
	private Mood mood;
	
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
	public Pet(String name, int weight, int age, int health, int hunger,
			int happiness, Illness illness, Mood mood) {
		this.name = name;
		this.weight=weight;
		this.age=age;
		this.health=health;
		this.hunger=hunger;
		this.happiness=happiness;
		this.illness=illness;
		this.mood=mood;
	}
	public Pet(String name)
	{
		this.name = name;
		weight = 10;
		age = 0;
		health = 100;
		hunger = 50;
		happiness = 100;
		illness = null;
		mood = Mood.HAPPY;
	}
	void play(Item toyItem){
		happiness+=toyItem.getHappinessImpact();
	}
	
	public String eat(Item foodItem)
	{
		if(hunger < 100)
		{
			hunger= hunger + foodItem.getHungerImpact();
			if(hunger > 100)
				hunger = 100;
			return "Your pet has been fed";
		}
		return "Your pet is full and can't possibly eat anymore";
		
	}
	
	/**
	 * If the pet takes the right medicine, illness goes to null and health goes up
	 * health goes down otherwise
	 * @param medicine
	 */
	void takeMedicine(Item medicine)
	{
		if(illness.equals(medicine.getIllnessImpact())){
			this.illness=null;
			health+=medicine.getHealthImpact();
		}
		else
		{
			health-=medicine.getHealthImpact();
		}
	}
	
	public String getName()
	{
		return this.name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
