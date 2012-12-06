package edu.gatech.virtual_pet_app;

/**
 * A representation of the owner of the pet
 * 
 * @author Leshi
 * 
 */
public class User {
	private int user_id;
	private String username;
	private String password;
	private int money;
	private Inventory inventory;
	private int pet_id;

	public User(int user_id, String uname, String pwd, int money,
			Inventory inventory, int pet_id) {
		this.user_id = user_id;
		username = uname;
		password = pwd;
		this.inventory = inventory;
		this.money = money;
		this.pet_id = pet_id;
	}

	public User(String uname, String pwd) {
		this.user_id = 0;
		this.username = uname;
		this.password = pwd;
		this.inventory = new Inventory();
		this.money = 100;
		this.setPet_id(0);
	}

	/**
	 * login the user
	 * 
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
	 * 
	 * @param purchase
	 *            item
	 * @return
	 */
	public String makePurchase(Item purchase) {
		if ((money - purchase.getPrice()) < 0) {
			return "You do not have enough money for this purchase";
		} else {
			money = money - purchase.getPrice();
			inventory.addItem(purchase);
			return "Your purchase is successful!";
		}
	}

	// it time isn't happening, just fill "time" with 0
	public String work(Pet pet, int time, int earnings) {
		if (pet.getHappiness() > 20) {

			if (pet.getHappiness() - ((earnings * time) / 2) <= 0) {
				return "Your pet is not happy enough to work for that amount of time";
			} else {
				money = money + (earnings * time);
				pet.setHappiness(pet.getHappiness() - ((earnings * time) / 2));
				pet.setAvailable(false);
				pet.setExpiration((System.currentTimeMillis() / 1000 / 60)
						+ time);
			}
			return "Your pet will work for " + time + "minutes, earning "
					+ earnings * time + "monies";
		}
		return "Your pet is too unhappy to work";

	}

	/**
	 * This is called when pet earns money by doing jobs
	 * 
	 * @param amount
	 * @return
	 */
	public int earn(int amount) {
		money = money + amount;
		return money;
	}

	public void giveItem(Item item) {
		inventory.addItem(item);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		if (money < 0) {
			this.money = 0;
		} else
			this.money = money;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public int getPet_id() {
		return pet_id;
	}

}
