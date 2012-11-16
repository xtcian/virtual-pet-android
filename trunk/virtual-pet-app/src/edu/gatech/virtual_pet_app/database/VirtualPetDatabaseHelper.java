package edu.gatech.virtual_pet_app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class VirtualPetDatabaseHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "VirtualPet";

	// table names
	private static final String TABLE_USER = "User";
	private static final String TABLE_PET = "Pet";
	private static final String TABLE_ILLNESS = "Illness";
	private static final String TABLE_MOOD = "Mood";
	private static final String TABLE_RANDEVENT = "RandEvent";
	private static final String TABLE_EVENT = "Event";
	private static final String TABLE_INTERACTIONS = "Interactions";
	private static final String TABLE_INTERACTION = "Interaction";
	private static final String TABLE_ITEM = "Item";
	private static final String TABLE_CATEGORY = "Category";
	private static final String TABLE_OWNED = "Owned";
	private static final String TABLE_JOB = "Job";

	// User Table Columns names
	private static final String USER_ID = "ID";
	private static final String USER_NAME = "Name";
	private static final String USER_MONEY = "Money";

	// Pet Table Columns names
	private static final String PET_ID = "ID";
	private static final String PET_NAME = "Name";
	private static final String PET_AGE = "Age";
	private static final String PET_AGE_INC = "AgeIncrement";
	private static final String PET_WEIGHT = "Weight";
	private static final String PET_HEALTH = "Health";
	private static final String PET_HAPPINESS = "Happiness";
	private static final String PET_HUNGER = "Hunger";
	private static final String PET_SICKNESS = "Illness";
	private static final String PET_MOOD = "Mood";
	
	// Illness Table Columns names
	private static final String ILLNESS_NAME = "Name";
	private static final String ILLNESS_HAIMPACT = "HappinessImpact";
	private static final String ILLNESS_HEIMPACT = "HealthImpact";
	private static final String ILLNESS_HUIMPACT = "HungerImpact";
	private static final String ILLNESS_DESCRIPTION = "Description";
	
	// Mood Table Columns names
	private static final String MOOD_TYPE = "Type";
	private static final String MOOD_HAIMPACT = "HappinessImpact";
	private static final String MOOD_DESCRIPTION = "Description";
	
	// RandEvent Table Columns names
	private static final String REVENT_ID  = "ID";
	private static final String REVENT_HAIMPACT = "HappinessImpact";
	private static final String REVENT_HEIMPACT = "HealthImpact";
	private static final String REVENT_HUIMPACT = "HungerImpact";
	private static final String REVENT_ILLNESS = "Illness";
	private static final String REVENT_ITEM = "Item";
	private static final String REVENT_DESCRIPTION = "Description";
	
	// Event Table Columns names
	private static final String EVENT_PET_ID = "PetID";
	private static final String EVENT_RAND_ID = "RandID";
	private static final String EVENT_TIME = "Time";
	
	// Interactions Table Columns names
	private static final String INTERACTIONS_ID = "ID";
	private static final String INTERACTIONS_HAIMPACT = "HappinessImpact";
	private static final String INTERACTIONS_HEIMPACT = "HealthImpact";
	private static final String INTERACTIONS_HUIMPACT = "HungerImpact";
	
	// Interaction Table Columns names
	private static final String INTERACTION_PET_ID= "PetID";
	private static final String INTERACTION_INT_ID = "IntID";
	private static final String INTERACTION_TIME = "Time";
	private static final String INTERACTION_POST_HAPPINESS= "PostHappiness";
	private static final String INTERACTION_POST_HEALTH= "PostHealth";
	
	// Item Table Columns names
	private static final String ITEM_ID = "ID";
	private static final String ITEM_PRICE = "Price";
	private static final String ITEM_DESCRIPTION = "Description";
	
	// Category Table Columns names
	private static final String CATEGORY_ITEM_ID = "ItemID";
	private static final String CATEGORY_TYPE= "Type";
	private static final String CATEGORY_IMPACT= "Impact";
	private static final String CATEGORY_ATTRIBUTE= "Attribute";
	
	// Owned Table Columns names
	private static final String OWNED_PET_ID = "PetID";
	private static final String OWNED_ITEM_ID = "ItemID";
	private static final String OWNED_QUANTITY = "Quantity";
	
	// Job Table Columns names
	private static final String JOB_ID = "ID";
	private static final String JOB_EARNINGS = "Earnings";
	private static final String JOB_TYPE = "Type";
	private static final String JOB_DESCRIPTION = "Description";
	
	// create table queries here
	private static final String CREATE_USER_TABLE = "CREATE TABLE "
			+ TABLE_USER + "(" + USER_ID + " INTEGER PRIMARY KEY," + USER_NAME
			+ " TEXT," + USER_MONEY + " INTEGER" + ")";

	private static final String CREATE_PET_TABLE = "CREATE TABLE " + TABLE_PET + "(" + PET_ID + " INTEGER PRIMARY KEY,"
			+ PET_NAME + " TEXT, " + PET_AGE + " INTEGER, " + PET_AGE_INC + " INTEGER," + PET_WEIGHT + " DOUBLE," + PET_HAPPINESS + " INTEGER," 
			+ PET_HEALTH + " INTEGER," + PET_HUNGER + " INTEGER," + PET_SICKNESS + " TEXT,"+ PET_MOOD + " TEXT)";

	private static final String CREATE_ILLNESS_TABLE = "CREATE TABLE " + TABLE_ILLNESS + "(" + ILLNESS_NAME + " TEXT PRIMARY KEY," 
			+ ILLNESS_HAIMPACT + " INTEGER, " + ILLNESS_HEIMPACT+ " INTEGER," + ILLNESS_HUIMPACT + " INTEGER, " 
			+ ILLNESS_DESCRIPTION + " TEXT)";
	
	private static final String CREATE_MOOD_TABLE = "CREATE TABLE " + TABLE_MOOD + "(" + MOOD_TYPE + " TEXT PRIMARY KEY," + MOOD_HAIMPACT 
			+ " INTEGER, " + MOOD_DESCRIPTION + " TEXT)";
	
	private static final String CREATE_RANDEVENT_TABLE = "CREATE TABLE" + TABLE_RANDEVENT + "(" + REVENT_ID + " INTEGER PRIMARY KEY,"
			+ REVENT_HAIMPACT + " INTEGER," + REVENT_HEIMPACT + " INTEGER," + REVENT_HUIMPACT + " INTEGER,"
			+ REVENT_ILLNESS + " TEXT," + REVENT_ITEM + " TEXT," + REVENT_DESCRIPTION + " TEXT)";
	
	private static final String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_EVENT + "(" + EVENT_PET_ID + " INTEGER PRIMARY KEY, "
			+ EVENT_RAND_ID + " INTEGER PRIMARY KEY, " + EVENT_TIME + " DATETIME, "
			+ "FOREIGN KEY("+EVENT_PET_ID+") REFERENCES "+ TABLE_PET+"(" + PET_ID +"), "
			+ "FOREIGN KEY("+ EVENT_RAND_ID +") REFERENCES "+ TABLE_RANDEVENT+"(" + REVENT_ID +"))";
	
	private static final String CREATE_INTERACTIONS_TABLE = "CREATE TABLE " + TABLE_INTERACTIONS + "(" + INTERACTIONS_ID + " INTEGER PRIMARY KEY,"
			+ INTERACTIONS_HAIMPACT + " INTEGER," + INTERACTIONS_HEIMPACT + " INTEGER" + INTERACTIONS_HUIMPACT + " INTEGER)";
	
	private static final String CREATE_INTERACTION_TABLE = "CREATE TABLE " + TABLE_INTERACTION + "(" + INTERACTION_PET_ID 
			+ " INTEGER PRIMARY KEY, " + INTERACTION_INT_ID + " INTEGER PRIMARY KEY, " + INTERACTION_TIME + " DATETIME," 
			+ INTERACTION_POST_HAPPINESS + " INTEGER," + INTERACTION_POST_HEALTH + " INTEGER," 
			+ "FOREIGN KEY("+INTERACTION_PET_ID+") REFERENCES "+ TABLE_PET+"(" + PET_ID+")," 
			+ "FOREIGN KEY("+INTERACTION_INT_ID+") REFERENCES "+ TABLE_INTERACTIONS+"(" + INTERACTIONS_ID+"))";
	
	private static final String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_ITEM + "("+ITEM_ID+" INTEGER PRIMARY KEY, "
			+ ITEM_PRICE + " INTEGER," + ITEM_DESCRIPTION + " TEXT)";
	
	private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "(" 
			+ CATEGORY_ITEM_ID + " INTEGER PRIMARY KEY,"+ CATEGORY_TYPE + " TEXT PRIMARY KEY," 
			+ CATEGORY_IMPACT +" INTEGER," + CATEGORY_ATTRIBUTE + " TEXT," 
			+ "FOREIGN KEY("+CATEGORY_ITEM_ID+") REFERENCES "+ TABLE_ITEM+"(" + ITEM_ID+"))";
	
	private static final String CREATE_OWNED_TABLE = "CREATE TABLE " + TABLE_OWNED + "(" + OWNED_PET_ID 
			+ " INTEGER PRIMARY KEY," + OWNED_ITEM_ID + " INTEGER PRIMARY KEY," + OWNED_QUANTITY + " INTEGER, "
			+ "FOREIGN KEY("+OWNED_PET_ID+") REFERENCES "+ TABLE_PET+"(" + PET_ID+"))";
	
	private static final String CREATE_JOB_TABLE = "CREATE TABLE " + TABLE_JOB + "(" + JOB_ID 
			+ " INTEGER PRIMARY KEY," + JOB_EARNINGS + " INTEGER," + JOB_TYPE + " TEXT, " 
			+ JOB_DESCRIPTION + " TEXT)";

	public VirtualPetDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(CREATE_USER_TABLE);
		db.execSQL(CREATE_PET_TABLE);
		db.execSQL(CREATE_ILLNESS_TABLE);
		db.execSQL(CREATE_MOOD_TABLE);
		db.execSQL(CREATE_RANDEVENT_TABLE);
		db.execSQL(CREATE_EVENT_TABLE);
		db.execSQL(CREATE_INTERACTIONS_TABLE);
		db.execSQL(CREATE_INTERACTION_TABLE);
		db.execSQL(CREATE_ITEM_TABLE);
		db.execSQL(CREATE_CATEGORY_TABLE);
		db.execSQL(CREATE_OWNED_TABLE);
		db.execSQL(CREATE_JOB_TABLE);
		
	}

	// Upgrading database, this happens when you change the version number
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(VirtualPetDatabaseHelper.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PET);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ILLNESS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOOD);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANDEVENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INTERACTIONS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INTERACTION);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_OWNED);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);

		// Create tables again
		onCreate(db);
	}
}
