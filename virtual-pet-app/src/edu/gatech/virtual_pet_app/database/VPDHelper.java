package edu.gatech.virtual_pet_app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class VPDHelper{ //extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	public static final int DATABASE_VERSION = 1;

	// Database Name
	public static final String DATABASE_NAME = "VirtualPet";

	// table names
	public static final String TABLE_USER = "User";
	public static final String TABLE_PET = "Pet";
	public static final String TABLE_ILLNESS = "Illness";
	public static final String TABLE_MOOD = "Mood";
	public static final String TABLE_RANDEVENT = "RandEvent";
	public static final String TABLE_EVENT = "Event";
	public static final String TABLE_INTERACTION = "Interaction";
	public static final String TABLE_ITEM = "Item";
	public static final String TABLE_CATEGORY = "Category";
	public static final String TABLE_OWNED = "Owned";
	public static final String TABLE_JOB = "Job";

	// User Table Columns names
	public static final String USER_ID = "ID";
	public static final String USER_NAME = "Name";
	public static final String USER_PASSWORD = "Password";
	public static final String USER_MONEY = "Money";

	// Pet Table Columns names
	public static final String PET_ID = "ID";
	public static final String PET_NAME = "Name";
	public static final String PET_AGE = "Age";
	public static final String PET_AGE_INC = "AgeIncrement";
	public static final String PET_WEIGHT = "Weight";
	public static final String PET_HEALTH = "Health";
	public static final String PET_HAPPINESS = "Happiness";
	public static final String PET_HUNGER = "Hunger";
	public static final String PET_SICKNESS = "Illness";
	public static final String PET_MOOD = "Mood";
	
	// Illness Table Columns names
	public static final String ILLNESS_NAME = "Name";
	public static final String ILLNESS_HAIMPACT = "HappinessImpact";
	public static final String ILLNESS_HEIMPACT = "HealthImpact";
	public static final String ILLNESS_HUIMPACT = "HungerImpact";
	public static final String ILLNESS_DESCRIPTION = "Description";
	
	// Mood Table Columns names
	public static final String MOOD_TYPE = "Type";
	public static final String MOOD_HAIMPACT = "HappinessImpact";
	public static final String MOOD_DESCRIPTION = "Description";
	
	// RandEvent Table Columns names
	public static final String REVENT_ID  = "ID";
	public static final String REVENT_HAIMPACT = "HappinessImpact";
	public static final String REVENT_HEIMPACT = "HealthImpact";
	public static final String REVENT_HUIMPACT = "HungerImpact";
	public static final String REVENT_ILLNESS = "Illness";
	public static final String REVENT_ITEM = "Item";
	public static final String REVENT_DESCRIPTION = "Description";
	
	// Event Table Columns names
	public static final String EVENT_PET_ID = "PetID";
	public static final String EVENT_RAND_ID = "RandID";
	public static final String EVENT_TIME = "Time";
	
	
	// Interaction Table Columns names
	public static final String INTERACTION_PET_ID= "PetID";
	public static final String INTERACTION_TIME = "Time";
	public static final String INTERACTION_POST_HAPPINESS= "PostHappiness";
	public static final String INTERACTION_POST_HEALTH= "PostHealth";
	public static final String INTERACTION_POST_HUNGER= "PostHunger";
	
	// Item Table Columns names
	public static final String ITEM_ID = "ID";
	public static final String ITEM_PRICE = "Price";
	public static final String ITEM_DESCRIPTION = "Description";
	public static final String ITEM_TYPE= "Type";
	public static final String ITEM_IMPACT= "Impact";
	public static final String ITEM_ATTRIBUTE = "Attribute";
	
	// Owned Table Columns names
	public static final String OWNED_USER_ID = "UserID";
	public static final String OWNED_ITEM_ID = "ItemID";
	public static final String OWNED_QUANTITY = "Quantity";
	
	// Job Table Columns names
	public static final String JOB_ID = "ID";
	public static final String JOB_EARNINGS = "Earnings";
	public static final String JOB_TYPE = "Type";
	public static final String JOB_DESCRIPTION = "Description";
	
	// create table queries here
	public static final String CREATE_USER_TABLE = "CREATE TABLE "
			+ TABLE_USER + "(" + USER_ID + " INTEGER PRIMARY KEY," + USER_NAME
			+ " TEXT,"  + USER_PASSWORD	+ " TEXT," + USER_MONEY + " INTEGER" + ")";

	public static final String CREATE_PET_TABLE = "CREATE TABLE " + TABLE_PET + "(" + PET_ID + " INTEGER PRIMARY KEY,"
			+ PET_NAME + " TEXT, " + PET_AGE + " INTEGER, " + PET_AGE_INC + " INTEGER," + PET_WEIGHT + " DOUBLE," + PET_HAPPINESS + " INTEGER," 
			+ PET_HEALTH + " INTEGER," + PET_HUNGER + " INTEGER," + PET_SICKNESS + " TEXT,"+ PET_MOOD + " TEXT)";

	public static final String CREATE_ILLNESS_TABLE = "CREATE TABLE " + TABLE_ILLNESS + "(" + ILLNESS_NAME + " TEXT PRIMARY KEY," 
			+ ILLNESS_HAIMPACT + " INTEGER, " + ILLNESS_HEIMPACT+ " INTEGER," + ILLNESS_HUIMPACT + " INTEGER, " 
			+ ILLNESS_DESCRIPTION + " TEXT)";
	
	public static final String CREATE_MOOD_TABLE = "CREATE TABLE " + TABLE_MOOD + "(" + MOOD_TYPE + " TEXT PRIMARY KEY," + MOOD_HAIMPACT 
			+ " INTEGER, " + MOOD_DESCRIPTION + " TEXT)";
	
	public static final String CREATE_RANDEVENT_TABLE = "CREATE TABLE" + TABLE_RANDEVENT + "(" + REVENT_ID + " INTEGER PRIMARY KEY,"
			+ REVENT_HAIMPACT + " INTEGER," + REVENT_HEIMPACT + " INTEGER," + REVENT_HUIMPACT + " INTEGER,"
			+ REVENT_ILLNESS + " TEXT," + REVENT_ITEM + " TEXT," + REVENT_DESCRIPTION + " TEXT)";
	
	public static final String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_EVENT + "(" + EVENT_PET_ID + " INTEGER PRIMARY KEY, "
			+ EVENT_RAND_ID + " INTEGER PRIMARY KEY, " + EVENT_TIME + " DATETIME, "
			+ "FOREIGN KEY("+EVENT_PET_ID+") REFERENCES "+ TABLE_PET+"(" + PET_ID +"), "
			+ "FOREIGN KEY("+ EVENT_RAND_ID +") REFERENCES "+ TABLE_RANDEVENT+"(" + REVENT_ID +"))";
	
	public static final String CREATE_INTERACTION_TABLE = "CREATE TABLE " + TABLE_INTERACTION + "(" + INTERACTION_PET_ID 
			+ " INTEGER PRIMARY KEY, " + INTERACTION_TIME + " DATETIME," 
			+ INTERACTION_POST_HAPPINESS + " INTEGER," + INTERACTION_POST_HEALTH + " INTEGER,"  + INTERACTION_POST_HUNGER + " INTEGER," 
			+ "FOREIGN KEY("+INTERACTION_PET_ID+") REFERENCES "+ TABLE_PET+"(" + PET_ID+"))";
	
	public static final String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_ITEM + "("+ITEM_ID+" INTEGER PRIMARY KEY, "
			+ ITEM_PRICE + " INTEGER," + ITEM_DESCRIPTION + " TEXT, " + ITEM_TYPE + "String, " + ITEM_IMPACT + " INTEGER, " + ITEM_ATTRIBUTE + "TEXT )";
	
	public static final String CREATE_OWNED_TABLE = "CREATE TABLE " + TABLE_OWNED + "(" + OWNED_USER_ID 
			+ " INTEGER PRIMARY KEY," + OWNED_ITEM_ID + " INTEGER PRIMARY KEY," + OWNED_QUANTITY + " INTEGER, "
			+ "FOREIGN KEY("+ OWNED_USER_ID +") REFERENCES "+ TABLE_PET+"(" + USER_ID+"))";
	
	public static final String CREATE_JOB_TABLE = "CREATE TABLE " + TABLE_JOB + "(" + JOB_ID 
			+ " INTEGER PRIMARY KEY," + JOB_EARNINGS + " INTEGER," + JOB_TYPE + " TEXT, " 
			+ JOB_DESCRIPTION + " TEXT)";

	public VPDHelper(Context context) {
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
		db.execSQL(CREATE_INTERACTION_TABLE);
		db.execSQL(CREATE_ITEM_TABLE);
		db.execSQL(CREATE_OWNED_TABLE);
		db.execSQL(CREATE_JOB_TABLE);
		
	}

	// Upgrading database, this happens when you change the version number
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(VPDHelper.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PET);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ILLNESS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOOD);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANDEVENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INTERACTION);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_OWNED);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);

		// Create tables again
		onCreate(db);
	}
	
}



