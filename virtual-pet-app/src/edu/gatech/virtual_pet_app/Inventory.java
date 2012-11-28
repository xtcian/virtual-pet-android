package edu.gatech.virtual_pet_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
	/*contains a map with key = type of item, value= arraylist of that type of item*/
	private Map<Item.Type,Map<String,Item>> inventory;

	public Inventory(Map<Item.Type, Map<String, Item>> inventory) 
	{
		this.inventory=inventory;
		
	}
	public Inventory()
	{
		Map<String, Item> item = new HashMap();
		inventory = new HashMap();
		inventory.put(Item.Type.FOOD, item);
		inventory.put(Item.Type.MEDICINE, item);
		inventory.put(Item.Type.TOY, item);
		
	}

	public void addItem(Item item)
	{
			if(inventory.get(item.getType()).get(item.getDescription()) == null)
			{
				inventory.get(item.getType()).put(item.getDescription(), item);
			}
			else
			{
				inventory.get(item.getType()).get(item.getDescription()).setQuantity(
						item.getQuantity() + (inventory.get(item.getType()).get(item.getDescription()).getQuantity()));
			}
	}
	
	public void removeItem(Item item, int quantity)
	{
		if(inventory.get(item.getType()).get(item.getDescription()) == null)
		{
			System.out.println("it should not be possible to get this message. error in Inventory.removeItem()");
			System.exit(0);
		}
		else
		{
			inventory.get(item.getType()).get(item.getDescription()).setQuantity(
					(inventory.get(item.getType()).get(item.getDescription()).getQuantity() - quantity));
		}
	}
	

	public Map<String, Item> getFood() {
		return inventory.get(Item.Type.FOOD);
	}

	public Map<String, Item> getToys() {
		return inventory.get(Item.Type.TOY);
	}

	public Map<String, Item> getMedicine() {
		return inventory.get(Item.Type.MEDICINE);
	}

}