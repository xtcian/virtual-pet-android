
package edu.gatech.virtual_pet_app;

public class Interaction 
{
	private int pID, time, postHap, postHealth, postHunger;
	
	public Interaction(int pID, int time, int postHap, int postHealth, int postHunger)
	{
		this.pID = pID;
		this.time = time;
		this.postHap = postHap;
		this.postHealth = postHealth;
		this.postHunger = postHunger;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPostHap() {
		return postHap;
	}

	public void setPostHap(int postHap) {
		this.postHap = postHap;
	}

	public int getPostHealth() {
		return postHealth;
	}

	public void setPostHealth(int postHealth) {
		this.postHealth = postHealth;
	}

	public int getPostHunger() {
		return postHunger;
	}

	public void setPostHunger(int postHunger) {
		this.postHunger = postHunger;
	}
	
	
}
