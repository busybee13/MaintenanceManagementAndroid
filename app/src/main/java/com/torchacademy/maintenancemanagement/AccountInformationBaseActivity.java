package com.torchacademy.maintenancemanagement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

abstract class AccountInformationBaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    FloatingActionButton fab_editProfile;
    String userName;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information_base);

        setupViews();

    }

    private void setupViews() {
        setupTitle(userName, ID);
        // setup FAB
        fab_editProfile = (FloatingActionButton) findViewById(R.id.fab_editProfile);
        fab_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEditProfileActivity();
            }
        });

    }

    private void setupTitle(String fullName, String ID){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(fullName);
        getSupportActionBar().setSubtitle(ID);
    }



    private void setupProfilePicture(){

    }

    private void goToEditProfileActivity(){

    }
    abstract void setContentLayout();

    abstract void setCustomButtonAction();


}
