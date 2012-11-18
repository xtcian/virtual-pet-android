package edu.gatech.virtual_pet_app;

public class User {
	private String username;
	private String password;
	private int money;
	private Inventory inventory;

	public User(String uname, String pwd) {
		username = uname;
		password = pwd;
	}

	public boolean login(String pwd) {
		if (password.equals(pwd)) {
			return true;
		}
		return false;
	}
	
	public String makePurchase(Item purchase)
	{
		if((money - Item.getPrice())<0)
		{
			return "You do not have enough money for this purchase";
		}
		else
		{
			money = money - Item.getPrice();
			inventory.addItem(item);
			return "Your purchase is successful!";
		}
	}
	
	public int pay(int amount)
	{
		money = money + amount;
		return money;
	}
}
