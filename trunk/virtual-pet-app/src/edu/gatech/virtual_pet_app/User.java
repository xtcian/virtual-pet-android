package edu.gatech.virtual_pet_app;
/**
 * A representation of the owner of the pet
 * @author Leshi
 *
 */
public class User {
	private String username;
	private String password;
	private int money;
	private Inventory inventory;

	public User(String uname, String pwd) {
		username = uname;
		password = pwd;
	}

	/**
	 * login the user
	 * @param pwd
	 * @return boolean on whether login was successful
	 */
	public boolean login(String pwd) {
		if (password.equals(pwd)) {
			return true;
		}
		return false;
	}
	/**
	 * Purchase an item by subtracting the money and adding it to inventory
	 * @param purchase item 
	 * @return
	 */
	public String makePurchase(Item purchase)
	{
		if((money - purchase.getPrice())<0)
		{
			return "You do not have enough money for this purchase";
		}
		else
		{
			money = money - purchase.getPrice();
			inventory.addItem(purchase);
			return "Your purchase is successful!";
		}
	}
	
	/**
	 * This is called when pet earns money by doing jobs
	 * @param amount
	 * @return
	 */
	public int earn(int amount)
	{
		money = money + amount;
		return money;
	}
}
