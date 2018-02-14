package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.waitlist.data.WaitlistContract.*;


// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper{

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    private final static String DATABASE_NAME = "waitlist.db";

    // TODO (3) Create a static final int called DATABASE_VERSION and set it to 1
    private final static int DATABASE_VERSION = 1;

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    // TODO (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
        CREATE TABLE table_name (
            column1 datatype,
            column2 datatype,
   .        ...
        );          */
        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
       final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + WaitlistEntry.TABLE_NAME + " (" +
               WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
               WaitlistEntry.COLUMN_GUEST_NAME + " TEXT NOT NULL, " +
               WaitlistEntry.COLUMN_PARTY_SIZE + " INTEGER NOT NULL, " +
               WaitlistEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
               "); ";
        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // TODO (8) Override the onUpgrade method

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped
        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


}