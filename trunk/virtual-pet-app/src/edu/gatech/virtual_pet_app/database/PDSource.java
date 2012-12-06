package edu.gatech.virtual_pet_app.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import edu.gatech.virtual_pet_app.EventHandler;
import edu.gatech.virtual_pet_app.Illness;
import edu.gatech.virtual_pet_app.Interaction;
import edu.gatech.virtual_pet_app.Inventory;
import edu.gatech.virtual_pet_app.Item;
import edu.gatech.virtual_pet_app.Job;
import edu.gatech.virtual_pet_app.Pet;
import edu.gatech.virtual_pet_app.REvent;
import edu.gatech.virtual_pet_app.Store;
import edu.gatech.virtual_pet_app.User;

public class PDSource {
	private SQLiteDatabase database;
	private VPDHelper dbHelper;

	private String[] userColumns = { VPDHelper.USER_ID, VPDHelper.USER_NAME,
			VPDHelper.USER_PASSWORD, VPDHelper.USER_MONEY, VPDHelper.USER_PET };
	private String[] petColumns = { VPDHelper.PET_ID, VPDHelper.PET_NAME,
			VPDHelper.PET_AGE, VPDHelper.PET_AGE_INC, VPDHelper.PET_WEIGHT,
			VPDHelper.PET_HEALTH, VPDHelper.PET_HAPPINESS,
			VPDHelper.PET_HUNGER, VPDHelper.PET_SICKNESS, VPDHelper.PET_MOOD };
	private String[] illnessColumns = { VPDHelper.ILLNESS_NAME,
			VPDHelper.ILLNESS_HAIMPACT, VPDHelper.ILLNESS_HEIMPACT,
			VPDHelper.ILLNESS_DESCRIPTION };
	private String[] reventColumns = { VPDHelper.REVENT_ID,
			VPDHelper.REVENT_HAIMPACT, VPDHelper.REVENT_HEIMPACT,
			VPDHelper.REVENT_HUIMPACT, VPDHelper.REVENT_ILLNESS,
			VPDHelper.REVENT_ITEM, VPDHelper.REVENT_DESCRIPTION };
	private String[] eventColums = { VPDHelper.EVENT_PET_ID,
			VPDHelper.EVENT_RAND_ID, VPDHelper.EVENT_TIME };
	private String[] interactionColumns = { VPDHelper.INTERACTION_PET_ID,
			VPDHelper.INTERACTION_TIME, VPDHelper.INTERACTION_POST_HAPPINESS,
			VPDHelper.INTERACTION_POST_HEALTH,
			VPDHelper.INTERACTION_POST_HUNGER };
	private String[] jobColumns = { VPDHelper.JOB_ID, VPDHelper.JOB_EARNINGS,
			VPDHelper.JOB_DESCRIPTION };
	private String[] ownedColumns = { VPDHelper.OWNED_USER_ID,
			VPDHelper.OWNED_ITEM_ID, VPDHelper.OWNED_QUANTITY };
	private String[] itemColumns = { VPDHelper.ITEM_ID, VPDHelper.ITEM_PRICE,
			VPDHelper.ITEM_DESCRIPTION, VPDHelper.ITEM_TYPE,
			VPDHelper.ITEM_IMPACT, VPDHelper.ITEM_ATTRIBUTE };

	public PDSource(Context context) {
		dbHelper = new VPDHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	// ---------------------------------------------------------------
	public Pet createPet() {

		return null;
	}

	public User createUser(String uname, String password) {
		return null;

	}

	public void givePetItem(Pet pet, Item item) {
		// db.execSQL("INSERT INTO Interaction VALUES("");
	}

	public Pet updatePet(Pet pet) {
		return pet;

	}

	public void updateMoney(User user) {

	}

	public Pet givePetREvent() {
		return null;
	}

	public User getUser() {

		Cursor cursor = database.query(VPDHelper.TABLE_USER, userColumns, null,
				null, null, null, null);
		cursor.moveToFirst();
		// User user = new User(cursor.getInt(0), cursor.getString(1),
		// cursor.getString(2), cursor.getInt(3));
		cursor.moveToNext();

		return null;
	}

	/**
	 * Add a new item to user owned inventory, should be called after changing
	 * actual Inventory in activity
	 * 
	 * @param user
	 * @param item
	 * @param quantity
	 */
	public void addToInventory(User user, Item item, int quantity) {
		ContentValues values = new ContentValues();
		Cursor cursor = database.query(VPDHelper.TABLE_OWNED, ownedColumns,
				VPDHelper.OWNED_ITEM_ID + " = " + item.getItem_id(), null,
				null, null, null);
		if (cursor.moveToFirst()) {
			values.put(VPDHelper.OWNED_USER_ID, user.getUser_id());
			values.put(VPDHelper.OWNED_ITEM_ID, item.getItem_id());
			values.put(VPDHelper.OWNED_QUANTITY, quantity + cursor.getInt(2));
			database.update(
					VPDHelper.TABLE_OWNED,
					values,
					VPDHelper.OWNED_USER_ID + "=? AND "
							+ VPDHelper.OWNED_ITEM_ID + "=?",
					new String[] { String.valueOf(user.getUser_id()),
							String.valueOf(item.getItem_id()) });
		} else {
			values.put(VPDHelper.OWNED_USER_ID, user.getUser_id());
			values.put(VPDHelper.OWNED_ITEM_ID, item.getItem_id());
			values.put(VPDHelper.OWNED_QUANTITY, quantity);
			database.insert(VPDHelper.TABLE_OWNED, null, values);
		}

		cursor.close();
	}

	/**
	 * Get the inventory of a particular User
	 * 
	 * @param user
	 * @return inventory Inventory object or null if Table Owned does not have
	 *         record for that User
	 */
	public Inventory getUserInventory(User user) {
		Inventory inventory = new Inventory();

		Cursor cursor = database.query(VPDHelper.TABLE_OWNED, ownedColumns,
				null, null, null, null, null);
		Cursor c2;

		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				Item item = new Item();
				item.setItem_id(cursor.getInt(1));
				item.setQuantity(cursor.getInt(2));
				c2 = database.query(VPDHelper.TABLE_ITEM, null,
						VPDHelper.ITEM_ID + "=" + item.getItem_id(), null,
						null, null, null, null);
				if (c2.moveToFirst() == false) {
					return null;
				}
				item.setPrice(c2.getInt(1));
				item.setDescription(c2.getString(2));
				item.setType(Item.Type.valueOf(c2.getString(3)));
				item.setImpact(c2.getInt(4));
				item.setIllnessImpact(c2.getString(5));
				inventory.addItem(item);
				cursor.moveToNext();
			}

			return inventory;
		} else {
			return null;
		}
	}

	/**
	 * Get all existing items and put in a store
	 * 
	 * @return store
	 */
	public Store getItems() {
		Store store = new Store();

		Cursor cursor = database.query(VPDHelper.TABLE_ITEM, itemColumns, null,
				null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Item item = new Item();
			item.setItem_id(cursor.getInt(0));
			item.setPrice(cursor.getInt(1));
			item.setDescription(cursor.getString(2));
			item.setType(Item.Type.valueOf(cursor.getString(3)));
			item.setImpact(cursor.getInt(4));
			item.setIllnessImpact(cursor.getString(5));
			store.addItem(item);
			cursor.moveToNext();
		}
		return store;
	}

	public EventHandler makeEventHandler() {
		List<REvent> events = new ArrayList<REvent>();
		List<Interaction> inters = new ArrayList<Interaction>();
		List<Illness> ill = new ArrayList<Illness>();
		EventHandler handler;
		Cursor cursor = database.query(VPDHelper.TABLE_ITEM, itemColumns, null,
				null, null, null, null);
		Cursor c2 = database.query(VPDHelper.TABLE_INTERACTION,
				interactionColumns, null, null, null, null, null);
		Cursor c3 = database.query(VPDHelper.TABLE_ILLNESS, illnessColumns,
				null, null, null, null, null);

		// cursor.moveToFirst();
		if (cursor.moveToFirst() && c2.moveToFirst() && c3.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				REvent event = new REvent(cursor.getInt(0), cursor.getInt(1),
						cursor.getInt(2), cursor.getInt(3),
						cursor.getString(4), cursor.getString(5));
				events.add(event);
				cursor.moveToNext();
			}

			while (!c2.isAfterLast()) {
				Interaction inter = new Interaction(c2.getInt(0), c2.getInt(1),
						c2.getInt(2), c2.getInt(3), c2.getInt(4));
				inters.add(inter);
				c2.moveToNext();
			}

			while (!c3.isAfterLast()) {
				Illness illness = new Illness(c3.getString(0), c3.getInt(1),
						c3.getInt(2), c3.getString(3));
				ill.add(illness);
				c3.moveToNext();
			}

			handler = new EventHandler(events, inters, ill);
			return handler;
		}

		return null;

	}

	public List<Job> getJobs(Pet pet) {
		List<Job> jobs = new ArrayList<Job>();

		Cursor cursor = database.query(VPDHelper.TABLE_JOB, jobColumns, null,
				null, null, null, null);

		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				Job job = new Job();
				job.setId(cursor.getInt(0));
				job.setEarnings(cursor.getInt(1));
				job.setDescription(cursor.getString(3));
				jobs.add(job);
				cursor.moveToNext();
			}
			return jobs;
		}

		return null;
	}

}
