package edu.gatech.virtual_pet_app;

public class Job 
{
	private int earnings;
	private int id;
	private String description;
	
	public Job(int id, int earnings, String description)
	{
		this.id = id;
		this.earnings = earnings;
		this.description =description;
	}
	public Job()
	{
		
	}
	public int getEarnings() {
		return earnings;
	}
	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
