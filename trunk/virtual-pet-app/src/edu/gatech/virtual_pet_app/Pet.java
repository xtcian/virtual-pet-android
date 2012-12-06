
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
	
	/**
	 * Mood impacts happiness and random event generations
	 * Contains 
	 * @author Leshi
	 *
	 */
	enum Mood{FRIENDLY, AGRESSIVE, DEPRESSED, CONTENT};
	
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
			int happiness, Illness illness, Mood mood) {
		this.name = name;
		this.weight=weight;
		this.age=age;
		this.health=health;
		this.hunger=hunger;
		this.happiness=happiness;
		this.illness=illness;
		this.mood=mood;
		this.available = true;
		this.ageinc = ageinc;
		this.expiration = 0;
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
		mood = Mood.FRIENDLY;
		this.available = false;
		this.expiration = 0;
	}
	public void play(Item toyItem)
	{
		if(happiness < 100)
			happiness+=toyItem.getImpact();
		if(happiness > 100)
			happiness = 100;
	}
	
	public String eat(Item foodItem)
	{
		if(hunger < 100)
		{
			hunger = hunger + foodItem.getImpact();
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
		if(illness.getName().equals(medicine.getIllnessImpact())){
			this.illness=null;
			health+=medicine.getImpact();
		}
		else
		{
			health-=medicine.getImpact();
		}
	}
	public boolean applyIllnessEffects()
	{
		if(illness != null)
		{
			health = health - illness.getHealthImpact();
			happiness = happiness - illness.getHealthImpact();
		}
		if(health <= 0)
		{
			return false;
		}
		if(happiness <= 0)
		{
			return false;
		}
		return true;
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
	public int getAgeinc() {
		return ageinc;
	}
	public void setAgeinc(int ageinc) {
		this.ageinc = ageinc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getExpiration() {
		return expiration;
	}
	
	
	
}
