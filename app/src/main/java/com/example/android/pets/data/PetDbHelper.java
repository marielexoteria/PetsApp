package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Contract class to connect to the SQLite db "pets" and enable CRUD actions
import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    //Name of the database
    private final static String DATABASE_NAME = "shelter.db";

    //Database version. If you change the db schema, you must increment the db version
    private final static int DATABASE_VERSION = 1;

    //Creating the constructor
    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    //CREATE TABLE pets (_id INTEGER, name TEXT, breed TEXT, gender INTEGER, weight INTEGER);
    /*
     * CREATE TABLE pets (
     * PetEntry._ID INTEGER PRIMARY KEY AUTOINCREMENT,
     * PetEntry.COLUMN_PET_NAME TEXT NOT NULL,
     * PetEntry.COLUMN_PET_BREED TEXT,
     * PetEntry.COLUMN_PET_GENDER INTEGER NOT NULL,
     * PetEntry.COLUMN_PET_WEIGHT INTEGER NOT NULL);
     */

    @Override
    public void onCreate(SQLiteDatabase db) {

        //String to create the table using the constants from the PetContract class
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + "("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_BREED + " TEXT, "
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0)";

        //Create the table
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
