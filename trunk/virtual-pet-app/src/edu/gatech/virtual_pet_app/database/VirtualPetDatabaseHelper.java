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
	private static final String USER_ID = "id";
	private static final String USER_NAME = "name";
	private static final String USER_MONEY = "money";

	// Pet Table Columns names
	private static final String PET_ID = "id";
	private static final String PET_NAME = "name";

	// Illness Table Columns names

	// Mood Table Columns names

	// RandEvent Table Columns names

	// Event Table Columns names

	// Interactions Table Columns names

	// Interaction Table Columns names

	// Item Table Columns names

	// Category Table Columns names

	// Owned Table Columns names

	// Job Table Columns names

	// create table queries here
	private static final String CREATE_USER_TABLE = "CREATE TABLE "
			+ TABLE_USER + "(" + USER_ID + " INTEGER PRIMARY KEY," + USER_NAME
			+ " TEXT," + USER_MONEY + " INTEGER" + ")";
	// to-do: create other tables here
	private static final String CREATE_PET_TABLE = "";
	private static final String CREATE_ILLNESS_TABLE = "";
	private static final String CREATE_MOOD_TABLE = "";
	private static final String CREATE_RANDEVENT_TABLE = "";
	private static final String CREATE_EVENT_TABLE = "";
	private static final String CREATE_INTERACTIONS_TABLE = "";
	private static final String CREATE_INTERACTION_TABLE = "";
	private static final String CREATE_ITEM_TABLE = "";
	private static final String CREATE_CATEGORY_TABLE = "";
	private static final String CREATE_OWNED_TABLE = "";
	private static final String CREATE_JOB_TABLE = "";

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
