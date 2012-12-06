package edu.gatech.virtual_pet_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class VPDHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	public static final int DATABASE_VERSION = 3;

	// Database Name
	public static final String DATABASE_NAME = "VirtualPet.db";

	// table names
	public static final String TABLE_USER = "User";
	public static final String TABLE_PET = "Pet";
	public static final String TABLE_ILLNESS = "Illness";
	public static final String TABLE_MOOD = "Mood";
	public static final String TABLE_RANDEVENT = "RandEvent";
	public static final String TABLE_EVENT = "Event";
	public static final String TABLE_INTERACTION = "Interaction";
	public static final String TABLE_ITEM = "Item";
	public static final String TABLE_OWNED = "Owned";
	public static final String TABLE_JOB = "Job";

	// User Table Columns names
	public static final String USER_ID = "_id";
	public static final String USER_NAME = "Name";
	public static final String USER_PASSWORD = "Password";
	public static final String USER_MONEY = "Money";
	public static final String USER_PET = "pet_id";

	// Pet Table Columns names
	public static final String PET_ID = "pet_id";
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
	public static final String ILLNESS_DESCRIPTION = "Description";

	// RandEvent Table Columns names
	public static final String REVENT_ID = "_id";
	public static final String REVENT_HAIMPACT = "HappinessImpact";
	public static final String REVENT_HEIMPACT = "HealthImpact";
	public static final String REVENT_HUIMPACT = "HungerImpact";
	public static final String REVENT_ILLNESS = "Illness";
	public static final String REVENT_ITEM = "Item";
	public static final String REVENT_DESCRIPTION = "Description";

	// Event Table Columns names
	public static final String EVENT_PET_ID = "pet_id";
	public static final String EVENT_RAND_ID = "rand_id";
	public static final String EVENT_TIME = "time";

	// Interaction Table Columns names
	public static final String INTERACTION_PET_ID = "pet_id";
	public static final String INTERACTION_TIME = "time";
	public static final String INTERACTION_POST_HAPPINESS = "PostHappiness";
	public static final String INTERACTION_POST_HEALTH = "PostHealth";
	public static final String INTERACTION_POST_HUNGER = "PostHunger";

	// Item Table Columns names
	public static final String ITEM_ID = "item_id";
	public static final String ITEM_PRICE = "Price";
	public static final String ITEM_DESCRIPTION = "Description";
	public static final String ITEM_TYPE = "Type";
	public static final String ITEM_IMPACT = "Impact";
	public static final String ITEM_ATTRIBUTE = "Attribute";

	// Owned Table Columns names
	public static final String OWNED_USER_ID = "user_id";
	public static final String OWNED_ITEM_ID = "item_id";
	public static final String OWNED_QUANTITY = "quantity";

	// Job Table Columns names
	public static final String JOB_ID = "job_id";
	public static final String JOB_EARNINGS = "earnings";
	public static final String JOB_DESCRIPTION = "description";

	// create table queries here
	public static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER
			+ "(" + USER_ID + " INTEGER PRIMARY KEY," + USER_NAME + " TEXT,"
			+ USER_PASSWORD + " TEXT," + USER_MONEY + " INTEGER, " + USER_PET
			+ " INTEGER" + ")";

	public static final String CREATE_PET_TABLE = "CREATE TABLE " + TABLE_PET
			+ "(" + PET_ID + " INTEGER PRIMARY KEY," + PET_NAME + " TEXT, "
			+ PET_AGE + " INTEGER, " + PET_AGE_INC + " INTEGER," + PET_WEIGHT
			+ " DOUBLE," + PET_HAPPINESS + " INTEGER," + PET_HEALTH
			+ " INTEGER," + PET_HUNGER + " INTEGER," + PET_SICKNESS + " TEXT,"
			+ PET_MOOD + " TEXT)";

	public static final String CREATE_ILLNESS_TABLE = "CREATE TABLE "
			+ TABLE_ILLNESS + "(" + ILLNESS_NAME + " TEXT PRIMARY KEY,"
			+ ILLNESS_HAIMPACT + " INTEGER, " + ILLNESS_HEIMPACT + " INTEGER, "
			+ ILLNESS_DESCRIPTION + " TEXT)";

	public static final String CREATE_RANDEVENT_TABLE = "CREATE TABLE "
			+ TABLE_RANDEVENT + "(" + REVENT_ID + " INTEGER PRIMARY KEY,"
			+ REVENT_HAIMPACT + " INTEGER," + REVENT_HEIMPACT + " INTEGER,"
			+ REVENT_HUIMPACT + " INTEGER," + REVENT_ILLNESS + " TEXT,"
			+ REVENT_ITEM + " TEXT," + REVENT_DESCRIPTION + " TEXT)";

	public static final String CREATE_EVENT_TABLE = "CREATE TABLE "
			+ TABLE_EVENT + "(" + EVENT_PET_ID + " INTEGER, " + EVENT_RAND_ID
			+ " INTEGER, " + EVENT_TIME + " DATETIME, PRIMARY KEY("
			+ EVENT_PET_ID + " , " + EVENT_RAND_ID + " ), " + "FOREIGN KEY("
			+ EVENT_PET_ID + ") REFERENCES " + TABLE_PET + "(" + PET_ID
			+ "),  " + "FOREIGN KEY(" + EVENT_RAND_ID + ") REFERENCES "
			+ TABLE_RANDEVENT + "(" + REVENT_ID + "))";

	public static final String CREATE_INTERACTION_TABLE = "CREATE TABLE "
			+ TABLE_INTERACTION + "(" + INTERACTION_PET_ID
			+ " INTEGER PRIMARY KEY, " + INTERACTION_TIME + " DATETIME,"
			+ INTERACTION_POST_HAPPINESS + " INTEGER,"
			+ INTERACTION_POST_HEALTH + " INTEGER," + INTERACTION_POST_HUNGER
			+ " INTEGER," + "FOREIGN KEY(" + INTERACTION_PET_ID
			+ ") REFERENCES " + TABLE_PET + "(" + PET_ID + "))";

	public static final String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_ITEM
			+ "(" + ITEM_ID + " INTEGER PRIMARY KEY, " + ITEM_PRICE
			+ " INTEGER," + ITEM_DESCRIPTION + " TEXT, " + ITEM_TYPE
			+ " TEXT, " + ITEM_IMPACT + " INTEGER, " + ITEM_ATTRIBUTE
			+ " TEXT )";

	public static final String CREATE_OWNED_TABLE = "CREATE TABLE "
			+ TABLE_OWNED + "(" + OWNED_USER_ID + " INTEGER," + OWNED_ITEM_ID
			+ " INTEGER," + OWNED_QUANTITY + " INTEGER, PRIMARY KEY( "
			+ OWNED_USER_ID + " , " + OWNED_ITEM_ID + " ), " + "FOREIGN KEY("
			+ OWNED_USER_ID + ") REFERENCES " + TABLE_PET + "(" + USER_ID
			+ "))";

	public static final String CREATE_JOB_TABLE = "CREATE TABLE " + TABLE_JOB
			+ "(" + JOB_ID + " INTEGER PRIMARY KEY," + JOB_EARNINGS
			+ " INTEGER," + JOB_DESCRIPTION + " TEXT)";
	
	//populate User and Pet
	public static ContentValues TEST_USER = new ContentValues();
	public static ContentValues TEST_PET = new ContentValues();
	
	//populate Illness table
	public static ContentValues ILLNESS1 = new ContentValues();
	public static ContentValues ILLNESS2 = new ContentValues();
	public static ContentValues ILLNESS3 = new ContentValues();
	public static ContentValues ILLNESS4 = new ContentValues();
	//populate REvent table
	public static ContentValues REVENT1 = new ContentValues();
	public static ContentValues REVENT2 = new ContentValues();
	public static ContentValues REVENT3 = new ContentValues();
	public static ContentValues REVENT4 = new ContentValues();
	public static ContentValues REVENT5 = new ContentValues();
	//populate Item table
	public static ContentValues ITEM1 = new ContentValues();
	public static ContentValues ITEM2 = new ContentValues();
	public static ContentValues ITEM3 = new ContentValues();
	public static ContentValues ITEM4 = new ContentValues();
//	public static ContentValues ITEM5 = new ContentValues();
//	public static ContentValues ITEM6 = new ContentValues();
//	public static ContentValues ITEM7 = new ContentValues();
//	public static ContentValues ITEM8 = new ContentValues();
//	public static ContentValues ITEM9 = new ContentValues();
//	public static ContentValues ITEM10 = new ContentValues();
//	public static ContentValues ITEM11 = new ContentValues();
//	public static ContentValues ITEM12 = new ContentValues();
	//populate Job table
	public static ContentValues JOB1 = new ContentValues();
	public static ContentValues JOB2 = new ContentValues();
	public static ContentValues JOB3 = new ContentValues();

	public VPDHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(CREATE_USER_TABLE);
		db.execSQL(CREATE_PET_TABLE);
		db.execSQL(CREATE_ILLNESS_TABLE);
		db.execSQL(CREATE_RANDEVENT_TABLE);
		db.execSQL(CREATE_EVENT_TABLE);
		db.execSQL(CREATE_INTERACTION_TABLE);
		db.execSQL(CREATE_ITEM_TABLE);
		db.execSQL(CREATE_OWNED_TABLE);
		db.execSQL(CREATE_JOB_TABLE);
		
		populateTestUserPet();
		populateIllnessTable();
		populateREventTable();
		populateItemTable();
		populateJobTable();
		
		db.insert(TABLE_ILLNESS, null, ILLNESS1);
		db.insert(TABLE_ILLNESS, null, ILLNESS2);
		db.insert(TABLE_ILLNESS, null, ILLNESS3);
		db.insert(TABLE_ILLNESS, null, ILLNESS4);
		
		db.insert(TABLE_RANDEVENT, null, REVENT1);
		db.insert(TABLE_RANDEVENT, null, REVENT2);
		db.insert(TABLE_RANDEVENT, null, REVENT3);
		db.insert(TABLE_RANDEVENT, null, REVENT4);
		db.insert(TABLE_RANDEVENT, null, REVENT5);
		
		db.insert(TABLE_ITEM, null, ITEM1);
		db.insert(TABLE_ITEM, null, ITEM2);
		db.insert(TABLE_ITEM, null, ITEM3);
		db.insert(TABLE_ITEM, null, ITEM4);
//		db.insert(TABLE_ITEM, null, ITEM5);
//		db.insert(TABLE_ITEM, null, ITEM6);
//		db.insert(TABLE_ITEM, null, ITEM7);
//		db.insert(TABLE_ITEM, null, ITEM8);
//		db.insert(TABLE_ITEM, null, ITEM9);
//		db.insert(TABLE_ITEM, null, ITEM10);
//		db.insert(TABLE_ITEM, null, ITEM11);
//		db.insert(TABLE_ITEM, null, ITEM12);
		
		db.insert(TABLE_JOB, null, JOB1);
		db.insert(TABLE_JOB, null, JOB2);
		db.insert(TABLE_JOB, null, JOB3);
		
		db.insert(TABLE_USER, null, TEST_USER);
		db.insert(TABLE_PET, null, TEST_PET);
		

	}

	

	// Upgrading database, this happens when you change the version number
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(VPDHelper.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PET);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ILLNESS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANDEVENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INTERACTION);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_OWNED);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);

		// Create tables again
		onCreate(db);
	}
	
	private void populateTestUserPet() {
		TEST_USER.put(USER_ID,0);
		TEST_USER.put(USER_NAME, "test_user");
		TEST_USER.put(USER_PASSWORD, "test");
		TEST_USER.put(USER_MONEY, 100);
		TEST_USER.put(USER_PET, 0);
		TEST_PET.put(PET_ID, 0);
		TEST_PET.put(PET_NAME, "Meowy");
		TEST_PET.put(PET_AGE, 0);
		TEST_PET.put(PET_AGE_INC, 1);
		TEST_PET.put(PET_WEIGHT, 10);
		TEST_PET.put(PET_HEALTH, 100);
		TEST_PET.put(PET_HUNGER, 50);
		TEST_PET.put(PET_HAPPINESS, 100);
		TEST_PET.putNull(PET_SICKNESS);
		TEST_PET.put(PET_MOOD, "FRIENDLY");
		
	}
	
	private void populateIllnessTable(){
		ILLNESS1.put(ILLNESS_NAME, "Flu");
		ILLNESS1.put(ILLNESS_HAIMPACT, -1);
		ILLNESS1.put(ILLNESS_HEIMPACT, -1);
		ILLNESS1.put(ILLNESS_DESCRIPTION, "Sneezing and coughing!");
		ILLNESS2.put(ILLNESS_NAME, "Fever");
		ILLNESS2.put(ILLNESS_HAIMPACT, -5);
		ILLNESS2.put(ILLNESS_HEIMPACT, -5);
		ILLNESS2.put(ILLNESS_DESCRIPTION, "Burning and shivering!");
		ILLNESS3.put(ILLNESS_NAME, "Cancer");
		ILLNESS3.put(ILLNESS_HAIMPACT, -10);
		ILLNESS3.put(ILLNESS_HEIMPACT, -10);
		ILLNESS3.put(ILLNESS_DESCRIPTION, "Seems fine, but really?");
		ILLNESS4.put(ILLNESS_NAME, "Bruise");
		ILLNESS4.put(ILLNESS_HAIMPACT, -10);
		ILLNESS4.put(ILLNESS_HEIMPACT, -3);
		ILLNESS4.put(ILLNESS_DESCRIPTION, "Ouch! It's bleeding!");
	}
	private void populateREventTable(){
		REVENT1.put(REVENT_ID, 0);
		REVENT1.put(REVENT_HAIMPACT, 2);
		REVENT1.put(REVENT_HEIMPACT, 0);
		REVENT1.put(REVENT_HUIMPACT, 0);
		REVENT1.putNull(REVENT_ILLNESS);
		REVENT1.putNull(REVENT_ITEM);
		REVENT1.put(REVENT_DESCRIPTION, "Thinking about you, and happy");
		REVENT2.put(REVENT_ID, 1);
		REVENT2.put(REVENT_HAIMPACT, 0);
		REVENT2.put(REVENT_HEIMPACT, 0);
		REVENT2.put(REVENT_HUIMPACT, 0);
		REVENT2.put(REVENT_ILLNESS, "Bruise");
		REVENT2.putNull(REVENT_ITEM);
		REVENT2.put(REVENT_DESCRIPTION, "Tripped by a rock, ouch!");
		REVENT3.put(REVENT_ID, 2);
		REVENT3.put(REVENT_HAIMPACT, 10);
		REVENT3.put(REVENT_HEIMPACT, 2);
		REVENT3.put(REVENT_HUIMPACT, 0);
		REVENT3.putNull(REVENT_ILLNESS);
		REVENT3.putNull(REVENT_ITEM);
		REVENT3.put(REVENT_DESCRIPTION, "Saw a pretty flower, awwww");
		REVENT4.put(REVENT_ID, 3);
		REVENT4.put(REVENT_HAIMPACT, 15);
		REVENT4.put(REVENT_HEIMPACT, 0);
		REVENT4.put(REVENT_HUIMPACT, 0);
		REVENT4.putNull(REVENT_ILLNESS);
		REVENT4.put(REVENT_ITEM,"balloon");
		REVENT4.put(REVENT_DESCRIPTION, "Found a balloon!");
		REVENT5.put(REVENT_ID, 4);
		REVENT5.put(REVENT_HAIMPACT, 0);
		REVENT5.put(REVENT_HEIMPACT, 0);
		REVENT5.put(REVENT_HUIMPACT, -5);
		REVENT5.putNull(REVENT_ILLNESS);
		REVENT5.putNull(REVENT_ITEM);
		REVENT5.put(REVENT_DESCRIPTION, "Chased after a butterfly for 2 miles..");
	}
	
	private void populateItemTable(){
		ITEM1.put(ITEM_ID, 0);
		ITEM1.put(ITEM_PRICE, 1);
		ITEM1.put(ITEM_DESCRIPTION, "balloon");
		ITEM1.put(ITEM_TYPE, "TOY");
		ITEM1.put(ITEM_IMPACT, 15);
		ITEM1.putNull(ITEM_ATTRIBUTE);
		ITEM2.put(ITEM_ID, 1);
		ITEM2.put(ITEM_PRICE, 2);
		ITEM2.put(ITEM_DESCRIPTION, "snack");
		ITEM2.put(ITEM_TYPE, "FOOD");
		ITEM2.put(ITEM_IMPACT, 10);
		ITEM2.putNull(ITEM_ATTRIBUTE);
		ITEM3.put(ITEM_ID, 2);
		ITEM3.put(ITEM_PRICE, 10);
		ITEM3.put(ITEM_DESCRIPTION, "flu shot");
		ITEM3.put(ITEM_TYPE, "MEDICINE");
		ITEM3.put(ITEM_IMPACT, 1);
		ITEM3.put(ITEM_ATTRIBUTE,"illness");
		ITEM4.put(ITEM_ID, 3);
		ITEM4.put(ITEM_PRICE, 50);
		ITEM4.put(ITEM_DESCRIPTION, "vacation to Hawaii");
		ITEM4.put(ITEM_TYPE, "TOY");
		ITEM4.put(ITEM_IMPACT, 50);
		ITEM4.putNull(ITEM_ATTRIBUTE);
	}
	
	private void populateJobTable(){
		JOB1.put(JOB_ID, 0);
		JOB1.put(JOB_EARNINGS, 5);
		JOB1.put(JOB_DESCRIPTION, "Clean the room");
		JOB2.put(JOB_ID, 1);
		JOB2.put(JOB_EARNINGS, 15);
		JOB2.put(JOB_DESCRIPTION, "Mow the lawn");
		JOB3.put(JOB_ID, 2);
		JOB3.put(JOB_EARNINGS, 100);
		JOB3.put(JOB_DESCRIPTION, "Make an Android app");
	}
	

}
