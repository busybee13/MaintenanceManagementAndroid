package sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sqlite.model.User;

/**
 * Created by zeinab.serhan on 6/21/2016.
 */
public class DataBaseHelper  extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Version
    private static final String DATABASE_NAME = "Social";

    // Table Names
    private static final String TABLE_USERS = "Users";

    // Users Table - column names
    private static final String USER_NAME = "user_name";
    private static final String USER_ID = "user_id";


    // Table Create Statements
    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + TABLE_USERS + "(" + USER_ID + " INTEGER PRIMARY KEY," +USER_NAME
            + " TEXT" + ")";

    public DataBaseHelper(Context context) {
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


    public long createUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());
        // insert row
        long user_id = db.insert(TABLE_USERS, null, values);
        return user_id;
    }

    //get users logged in
    public Boolean getCurrentUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_USERS + ";";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.getCount() == 0) {
            return false;
        }
        else {
            return true;
        }
    }


    //close db
    public void CloseDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
