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
	private String[] interactionCollumns = {VPDHelper.INTERACTION_PET_ID, VPDHelper.INTERACTION_INT_ID, VPDHelper.INTERACTION_TIME, VPDHelper.INTERACTION_POST_HAPPINESS, VPDHelper.INTERACTION_POST_HEALTH, VPDHelper.INTERACTION_POST_HUNGER};
	private String[] jobCollumns = {VPDHelper.JOB_ID, VPDHelper.JOB_EARNINGS, VPDHelper.JOB_TYPE, VPDHelper.JOB_DESCRIPTION};
	private String[] ownedCollumns = {VPDHelper.OWNED_USER_ID, VPDHelper.OWNED_ITEM_ID, VPDHelper.OWNED_QUANTITY};
	private String[] categoryCollumns = {VPDHelper.CATEGORY_ITEM_ID, VPDHelper.CATEGORY_TYPE, VPDHelper.CATEGORY_IMPACT, VPDHelper.CATEGORY_ATTRIBUTE};
	private String[] itemCollumns ={VPDHelper.ITEM_ID, VPDHelper.ITEM_PRICE, VPDHelper.ITEM_DESCRIPTION};
	
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
	public void getItems()
	{
		
	}
	public void calculateMood(Pet pet)
	{
		//grab interactions and determine how "well cared for" the pet is. feeding/playing
	}
	public void calculateHunger(Pet pet)
	{
		
	}
	public void changeWeight(Pet pet)
	{
		//analyze history of feedinig. determine if commonly under or overfed. add weight accordingly
	}
	public void getRandomEvent()
	{
		
	}
	public void getJobs(Pet pet)
	{
		//where type = pet.getType
	}
	public void removePet(Pet pet)
	{
		
	}
	
}
