package com.torchacademy.maintenancemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.torchacademy.maintenancemanagement.sqlite.helper.DatabaseHelper;
import com.torchacademy.maintenancemanagement.sqlite.helper.DatabaseOps;

/**
 * Created by zeinab.serhan on 6/21/2016.
 */
public class ChooserActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Checking if user is Logged in
        CheckUser();
    }

    private void CheckUser() {
        if (!DatabaseOps.getInstance(this)
                .getCurrentUser()) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        else
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}
