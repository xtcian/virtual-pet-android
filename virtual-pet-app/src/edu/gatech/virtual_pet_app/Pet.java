
package edu.gatech.virtual_pet_app;

public class Pet {
	private String name;
	private int weight;
	private int age;
	private int ageinc;
	private int health, hunger, happiness, id;
	private Illness illness;
	private boolean available;
	private long expiration;
	private Mood mood;
	private VirtualPetDatabaseHelper db;
	
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
	public Pet(String name, int weight, int age, int ageinc, int health, int hunger,
			int happiness, Illness illness, Mood mood,VirtualPetDatabaseHelper db ) {
		this.name = name;
		this.weight=weight;
		this.age=age;
		this.health=health;
		this.hunger=hunger;
		this.happiness=happiness;
		this.illness=illness;
		this.mood=mood;
		this.db = db;
		this.available = true;
		this.ageinc = ageinc;
		this.expiration = 0;
		this.id = db.addPet(name, age, ageinc, weight, health, happiness, hunger, illness, mood);
	}
	public Pet(String name, VirtualPetDatabaseHelper db)
	{
		this.name = name;
		weight = 10;
		age = 0;
		health = 100;
		hunger = 50;
		happiness = 100;
		illness = null;
		mood = Mood.HAPPY;
		this.db = db;
		this.available = false;
		this.expiration = 0;
		this.id = db.addPet(name, age, ageinc, weight, health, happiness, hunger, illness, mood);
	}
	public void play(Item toyItem)
	{
		if(happiness < 100)
			happiness+=toyItem.getHappinessImpact();
		if(happiness > 100)
			happiness = 100;
		db.playEvent(happiness);
	}
	
	public String eat(Item foodItem)
	{
		if(hunger < 100)
		{
			hunger = hunger + foodItem.getHungerImpact();
			if(hunger > 100)
				hunger = 100;
			db.feedEvent(happiness);
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
		if(happiness > 100)
		{
			this.happiness = 100;
		}
		else if(happiness < 0)
		{
			this.happiness = 0;
		}
		else
		{
			this.happiness = happiness;
		}
		
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
	public boolean isAvailable() {
		
		if((System.currentTimeMillis()/1000/60) > expiration)
		{
			expiration = 0;
			available = true;
		}
		
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public long getTimeAvailable() {
		return expiration;
	}
	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}
	
	
	
}
