package com.torchacademy.maintenancemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import sqlite.helper.DataBaseHelper;
import sqlite.model.User;

/**
 * Created by zeinab.serhan on 6/21/2016.
 */
public class ChooserActivity extends Activity {
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DataBaseHelper(getApplicationContext());

        //Checking if user is Logged in
        CheckUser();


        //Close db
        db.CloseDB();
        }

    private void CheckUser() {
        if (!db.getCurrentUser()) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        else
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}
