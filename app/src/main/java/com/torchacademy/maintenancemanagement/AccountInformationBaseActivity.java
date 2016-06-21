package com.torchacademy.maintenancemanagement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

abstract class AccountInformationBaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    FloatingActionButton fab_editProfile;
    String userName;
    Button button_customProfileAction;
    String ID;
    ViewStub viewStub_profileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information_base);

        setupViews();

    }

    private void setupViews() {
        setupTitle(userName, ID);
        viewStub_profileContent = (ViewStub) findViewById(R.id.viewStub_profileContent);
        button_customProfileAction=(Button) findViewById(R.id.button_customProfileAction);
        // setup custom content layout
        setContentLayout();

        // setup FAB
        fab_editProfile = (FloatingActionButton) findViewById(R.id.fab_editProfile);
        fab_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEditProfileActivity();
            }
        });
        setCustomButtonAction();

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
    /* Implement the following for children
    viewStub_profileContent.setLayoutResource(R.layout.custom_content_account_information);
    View inflated = viewStub_profileContent.inflate();
     */
    abstract void setContentLayout();

    abstract void setCustomButtonAction();


}
