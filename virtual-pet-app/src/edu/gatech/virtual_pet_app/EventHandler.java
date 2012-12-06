package edu.gatech.virtual_pet_app;
import java.util.List;


public class EventHandler 
{
	List<REvent> events;
	List<Interaction> inter;
	List<Illness> illness;
	
	public EventHandler(List<REvent> events, List<Interaction> interaction, List<Illness> illness)
	{
		this.events = events;
		this.inter = interaction;
		this.illness = illness;
	}
	
	public void getRandomEvent(Pet pet)
	{
		
	}
	
	public int calcMood(Pet pet)
	{
		//if average happieness >75 Friendly; happiness > 60; content; 
		//happiness > 40 depressed; happiness > 0 aggressive;
		return 0;
	}
	
	public int calcWeight()
	{
		//if weight > x obesity
		//if weight < x mal-nutrition
		return 0;
	}
}
