package edu.gatech.virtual_pet_app;

import java.util.ArrayList;
import java.util.Map;

import edu.gatech.virtual_pet_app.Item.Type;

public class Inventory {
	/*contains a map with key = type of item, value= arraylist of that type of item*/
	Map<Type,ArrayList<Item>> inventory;

	public Inventory(Map<Type, ArrayList<Item>> inventory) {
		this.inventory=inventory;
	}

	public ArrayList<Item> getFood() {
		return inventory.get(Item.Type.FOOD);
	}

	public ArrayList<Item> getToys() {
		return inventory.get(Item.Type.TOY);
	}

	public ArrayList<Item> getMedicine() {
		return inventory.get(Item.Type.MEDICINE);
	}

	public void addItem(Item item){
		if (item.type==Item.Type.FOOD){
			ArrayList<Item> newfoodlist = inventory.get(Item.Type.FOOD);
			newfoodlist.add(item);
			inventory.put(Item.Type.FOOD, newfoodlist);
		}else if (item.type==Item.Type.TOY){
			ArrayList<Item> newtoylist = inventory.get(Item.Type.TOY);
			newtoylist.add(item);
			inventory.put(Item.Type.TOY, newtoylist);
		}else{
			ArrayList<Item> newmedlist = inventory.get(Item.Type.MEDICINE);
			newmedlist.add(item);
			inventory.put(Item.Type.MEDICINE, newmedlist);
		}
	}
}