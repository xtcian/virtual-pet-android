package edu.gatech.virtual_pet_app;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;
import android.util.SparseArray;
import edu.gatech.virtual_pet_app.Item.Type;

public class Store {
	/* contains a map with key = type of item, value= map of that type of item */
	private Map<Type, SparseArray<Item>> store;
	private SparseArray<Item> food, toys, medicine;

	public Store(Map<Item.Type, SparseArray<Item>> inventory) {
		this.store = inventory;

	}

	public Store() {
		food = new SparseArray<Item>();
		toys = new SparseArray<Item>();
	    medicine = new SparseArray<Item>();
		store = new HashMap<Type, SparseArray<Item>>();
		store.put(Item.Type.FOOD, food);
		store.put(Item.Type.MEDICINE, toys);
		store.put(Item.Type.TOY, medicine);

	}

	public void addItem(Item item) {
		if (store.get(item.getType()).get(item.getItem_id()) == null) {
			Log.d("Store", "adding to" + item.getType().toString());
			store.get(item.getType()).put(item.getItem_id(), item);
		} else {
			store.get(item.getType())
					.get(item.getItem_id())
					.setQuantity(
							item.getQuantity()
									+ (store.get(item.getType()).get(
											item.getItem_id()).getQuantity()));
		}
	}

	public void removeItem(Item item, int quantity) {
		if (store.get(item.getType()).get(item.getItem_id()) == null) {
			Log.d("Store", "removing something that DNE! ERROR!");
		} else {
			store.get(item.getType())
					.get(item.getItem_id())
					.setQuantity(
							(store.get(item.getType()).get(item.getItem_id())
									.getQuantity() - quantity));
		}
	}

	public SparseArray<Item> getFood() {
		return store.get(Item.Type.FOOD);
	}

	public SparseArray<Item> getToys() {
		return store.get(Item.Type.TOY);
	}

	public SparseArray<Item> getMedicine() {
		return store.get(Item.Type.MEDICINE);
	}

	public String toString() {
		return "[" + getFood().size() + ", " + getToys().size() + ", "
				+ getMedicine().size() + "]";
	}

}