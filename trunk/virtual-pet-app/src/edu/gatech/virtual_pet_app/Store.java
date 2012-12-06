package edu.gatech.virtual_pet_app;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;
import edu.gatech.virtual_pet_app.Item.Type;


public class Store {
	/*contains a map with key = type of item, value= map of that type of item*/
	private Map<Item.Type,Map<String,Item>> store;

	public Store(Map<Item.Type, Map<String, Item>> inventory) 
	{
		this.store=inventory;
		
	}
	public Store()
	{
		Map<String, Item> item = new HashMap<String, Item>();
		store = new HashMap<Type, Map<String, Item>>();
		store.put(Item.Type.FOOD, item);
		store.put(Item.Type.MEDICINE, item);
		store.put(Item.Type.TOY, item);
		
	}

	public void addItem(Item item)
	{
			if(store.get(item.getType()).get(item.getDescription()) == null)
			{
				store.get(item.getType()).put(item.getDescription(), item);
			}
			else
			{
				store.get(item.getType()).get(item.getDescription()).setQuantity(
						item.getQuantity() + (store.get(item.getType()).get(item.getDescription()).getQuantity()));
			}
	}
	
	public void removeItem(Item item, int quantity)
	{
		if(store.get(item.getType()).get(item.getDescription()) == null)
		{
			Log.d("Store","removing something that DNE! ERROR!");
		}
		else
		{
			store.get(item.getType()).get(item.getDescription()).setQuantity(
					(store.get(item.getType()).get(item.getDescription()).getQuantity() - quantity));
		}
	}
	

	public Map<String, Item> getFood() {
		return store.get(Item.Type.FOOD);
	}

	public Map<String, Item> getToys() {
		return store.get(Item.Type.TOY);
	}

	public Map<String, Item> getMedicine() {
		return store.get(Item.Type.MEDICINE);
	}

}