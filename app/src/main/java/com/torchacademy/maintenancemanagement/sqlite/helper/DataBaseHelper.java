package com.torchacademy.maintenancemanagement.sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.torchacademy.maintenancemanagement.sqlite.model.User;

/**
 * Created by zeinab.serhan on 6/21/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Version
    public static final String DATABASE_NAME = "Social";

    // Table Names
    public static final String TABLE_USERS = "Users";

    // Users Table - column names
    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";


    // Table Create Statements
    public static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + TABLE_USERS + "(" + USER_ID + " INTEGER PRIMARY KEY," +USER_NAME
            + " TEXT" + ")";

    public DatabaseHelper(Context context,
                              String name,
                              SQLiteDatabase.CursorFactory factory,
                              int version) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // create new tables
        onCreate(db);
    }
}
