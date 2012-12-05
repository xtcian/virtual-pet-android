package edu.gatech.virtual_pet_app.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class PDSource
{
	private SQLiteDatabase database;
	private VPDHelper dbHelper;
	
	private String[] userCollumns = {VPDHelper.USER_ID, VPDHelper.USER_NAME, VPDHelper.USER_PASSWORD, VPDHelper.USER_MONEY};
	private String[] petCollumns = {VPDHelper.PET_ID, VPDHelper.PET_NAME, VPDHelper.PET_AGE, VPDHelper.PET_AGE_INC, VPDHelper.PET_WEIGHT, VPDHelper.PET_HEALTH, VPDHelper.PET_HAPPINESS, VPDHelper.PET_HUNGER, VPDHelper.PET_SICKNESS, VPDHelper.PET_MOOD};
	private String[] illnessCollumns = {VPDHelper.ILLNESS_NAME, VPDHelper.ILLNESS_HAIMPACT, VPDHelper.ILLNESS_HEIMPACT, VPDHelper.ILLNESS_HUIMPACT, VPDHelper.ILLNESS_DESCRIPTION};
	private String[] moodCollumns = {VPDHelper.MOOD_TYPE, VPDHelper.MOOD_HAIMPACT, VPDHelper.MOOD_DESCRIPTION};
	private String[] reventCollumns = {VPDHelper.REVENT_ID, VPDHelper.REVENT_HAIMPACT, VPDHelper.REVENT_HEIMPACT, VPDHelper.REVENT_HUIMPACT, VPDHelper.REVENT_ILLNESS, VPDHelper.REVENT_ITEM, VPDHelper.REVENT_DESCRIPTION};
	private String[] eventCollumgs = {VPDHelper.EVENT_PET_ID, VPDHelper.EVENT_RAND_ID, VPDHelper.EVENT_TIME};
	private String[] interactionCollumns = {VPDHelper.INTERACTION_PET_ID, VPDHelper.INTERACTION_TIME, VPDHelper.INTERACTION_POST_HAPPINESS, VPDHelper.INTERACTION_POST_HEALTH, VPDHelper.INTERACTION_POST_HUNGER};
	private String[] jobCollumns = {VPDHelper.JOB_ID, VPDHelper.JOB_EARNINGS, VPDHelper.JOB_TYPE, VPDHelper.JOB_DESCRIPTION};
	private String[] ownedCollumns = {VPDHelper.OWNED_USER_ID, VPDHelper.OWNED_ITEM_ID, VPDHelper.OWNED_QUANTITY};
	private String[] itemCollumns ={VPDHelper.ITEM_ID, VPDHelper.ITEM_PRICE, VPDHelper.ITEM_DESCRIPTION, VPDHelper.ITEM_TYPE, VPDHelper.ITEM_IMPACT, VPDHelper.ITEM_ATTRIBUTE};
	
	public PDSource(Context context)
	{
		dbHelper = new VPDHelper(context);
	}
	
	public void open() throws SQLException
	{
		database = dbHelper.getWritableDatabase();
	}
	
	public void close()
	{
		dbHelper.close();
	}
	
	//---------------------------------------------------------------
	public int addPet()
	{
		ContentValues values = new ContentValues();
		values.put();
		
		return 0;
	}
	public void removePet(Pet pet)
	{
		long id = pet.getId();
		database.delete(VPDHelper.TABLE_PET, VPDHelper.PET_ID + "=" + id, null);
	}
	
	public void feedEvent(int post)
	{
	//	db.execSQL("INSERT INTO Interaction VALUES("");
	}
	public void playEvent(int post)
	{
		//insert interaction
	}
	public void pushPet(Pet pet)
	{
		
	}
	public void pushUser()
	{
		
	}
	public void pushOwned()
	{
		//add the bought items
	}
	public void updateOwned(Item item, int newQuantity)
	{

	}
	public List<Item> getItems()
	{
		List<Item> items = new ArrayList<Item>();
		
		Cursor cursor = database.query(VPDHelper.TABLE_ITEM, itemCollumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while(!cursor.isAfterLast())
		{
			Item item = new Item();
			item.setItem_id(cursor.getInt(0));
			item.setPrice(cursor.getInt(1));
			item.setDescription(cursor.getString(2));
			item.setType(Item.Type.valueOf(cursor.getString(3)));
			item.setImpact(cursor.getInt(4));
			item.setIllnessImpact(cursor.getString(5));
			items.add(item);
			cursor.moveToNext();
		}
		
		return items;
	
	}

	public void getRandomEvents()
	{
		List<REvent> events = new ArrayList<REvent>();
		EventHandler handler;
		Cursor cursor = database.query(VPDHelper.TABLE_ITEM, itemCollumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while(!cursor.isAfterLast())
		{
			REvent event = new REvent(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5));
			events.add(event);
			cursor.moveToNext();
		}
		handler = new EventHandler(events);
		return ;
	
	}
	
	public List<Job> getJobs(Pet pet)
	{ 
		List<Job> jobs = new ArrayList<Job>();
		
		Cursor cursor = database.query(VPDHelper.TABLE_JOB, jobCollumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while(!cursor.isAfterLast())
		{
			Job job = new Job();
			job.setJob_id(cursor.getInt(0));
			job.setPrice(cursor.getInt(1));
			job.setDescription(cursor.getString(3));
			jobs.add(job);
			cursor.moveToNext();
		}
		
		return jobs;
		
	}
	
}
