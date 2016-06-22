package com.torchacademy.maintenancemanagement.sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.torchacademy.maintenancemanagement.sqlite.model.User;

/**
 * Created by zeinab.serhan on 6/22/2016.
 */
public class DatabaseOps {

    private static DatabaseOps instance;
    private DatabaseHelper databaseHelper;

    private DatabaseOps(Context context) {
        databaseHelper = new DatabaseHelper(context,
                DatabaseHelper.DATABASE_NAME,
                null,
                DatabaseHelper.DATABASE_VERSION);
    }

    public static synchronized DatabaseOps getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseOps(context);
        }
        return instance;
    }



    //insert new user
    public long insertNewUser(User user) {
        SQLiteDatabase db =  databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( databaseHelper.USER_NAME, user.getName());
        // insert row
        long user_id = db.insert( databaseHelper.TABLE_USERS, null, values);
        db.close();
        return user_id;
    }


    //get users logged in
    public Boolean getCurrentUser() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + databaseHelper.TABLE_USERS + ";";
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.getCount() == 0) {
            c.close();
            closeDB(db);
            return false;
        }
        else {
            c.close();
            closeDB(db);
            return true;
        }
    }


    //close database
    public void closeDB( SQLiteDatabase db) {
       db= databaseHelper.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
