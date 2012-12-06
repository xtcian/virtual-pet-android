package edu.gatech.virtual_pet_app;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
	
	public REvent getRandomEvent(Pet pet)
	{
		Random rand = new Random();
		List <REvent> array = new ArrayList<REvent>();
		int avgHunger=0;
		int hunHit = 0;
		int count = 0;
		int moodHit = 0;
		int hapHit = 0;
		int total = 0;
		calcMood(pet);
		
		for (Interaction s : inter)
		{
			if(s.getPostHunger() > 0)
			{
				avgHunger = avgHunger + s.getPostHap(); 
		    count++;
			}  
		}
		
		avgHunger = avgHunger/count;
		if(avgHunger > 60 || avgHunger < 40)
		{
			hunHit = 20;
		}
		else if(avgHunger > 70 || avgHunger < 30)
		{
			hunHit = 40;
		}
		else
		{
			hunHit = 0;
		}
		
		if(pet.getMood() == Pet.Mood.AGRESSIVE)
		{
			moodHit = 40;
		}
		else if(pet.getMood() == Pet.Mood.DEPRESSED)
		{
			moodHit = 30;
		}
		else if(pet.getMood() == Pet.Mood.CONTENT)
		{
			moodHit = 20;
		}
		else
		{
			moodHit = 10;
		}
		if(pet.getHappiness() < 40)
		{
			hapHit = 20;
		}
		else if(pet.getHappiness() < 60)
		{
			hapHit = 15;
		}
		else if (pet.getHappiness() < 75)
		{
			hapHit = 10;
		}
		else
		{
			hapHit = 0;
		}
		
		total = hapHit + hunHit + moodHit;
		int number = 0;
		if(rand.nextInt(100) > total)
		{
			for(REvent e: events)
			{
				if((e.getHappiness() > 0 || e.getHealth() > 0 || e.getHunger() > 0) || (e.getItem() != null))
				{
					array.add(e);
					number++;
				}
			}
		}
		else
		{
			for(REvent e: events)
			{
				if((e.getHappiness() > 0 || e.getHealth() > 0 || e.getHunger() > 0) || (e.getItem() != null))
				{}				
				else
				{
					array.add(e);
					number++;
				}
			}
		}
		
		return array.get((rand.nextInt(number)));
		
	}
	
	public void calcMood(Pet pet)
	{
		int count = 0;
		int hap = 0;
		for (Interaction s : inter)
		{
			if(s.getPostHap() > 0)
			{
				hap = hap + s.getPostHap(); 
		    count++;
			}  
		}
		if((hap/count) > 75)
		{
			pet.setMood(Pet.Mood.FRIENDLY);
		}
		else if((hap/count) > 60)
		{
			pet.setMood(Pet.Mood.CONTENT);
		}
		else if((hap/count) > 40)
		{
			pet.setMood(Pet.Mood.DEPRESSED);
		}
		else
		{
			pet.setMood(Pet.Mood.AGRESSIVE);
		}
		
	}
	
	public int changeWeight(Pet pet)
	{
		
		int count = 0;
		int hun = 0;
		int avgHunger = 0;
		for (Interaction s : inter)
		{
			if(s.getPostHunger() > 0)
			{
				hun = hun + s.getPostHunger(); 
				count++;
			}  
		}
		avgHunger = hun/count;
		
		if(avgHunger > 50)
		{
			pet.setWeight(pet.getWeight() + (int)(((avgHunger-50)/10)));
		}
		else
		{
			pet.setWeight(pet.getWeight() - (int)(((avgHunger)/10)));
		}
		
		if(pet.getWeight() < 0)
		{
			pet.setWeight(1);
		}
		
		//if weight > x obesity		given time
		//if weight < x mal-nutrition
		return pet.getWeight();
	}
}
