package com.torchacademy.maintenancemanagement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

/**
 * Created by omar.beyhum on 6/20/2016.
 * Abstract class from which the Expert and User Account Info. activities inherit from.
 * This class is in charge of inflating the base activity layout to setup common views such as title,
 * ID, profile picture, edit settings, etc...
 * Children of this class must setup their own custom content through the ViewStub, found in
 * content_account_information_base.xml, which is included in the base activity layout
 */
abstract class AccountInformationBaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    FloatingActionButton fab_editProfile;
    String userName = "OB";
    String ID = "1";
    Button button_customProfileAction;
    ViewStub viewStub_profileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information_base);

        setupViews();

    }

    private void setupViews() {
        setupTitle(userName, ID);
        viewStub_profileContent = (ViewStub) findViewById(R.id.viewStub_customContent);
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
        toolbar = (Toolbar) findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(fullName);
        getSupportActionBar().setSubtitle("jhurhur");
        toolbar.setSubtitle("nhfnhfr");
    }



    // Glide singleton required for implementation
    private void setupProfilePicture(){

    }

    // Edit Profile task, model and APIs required for implementation
    private void goToEditProfileActivity(){

    }
    /*
     */

    /**
     * Abstract class; Implement the following for children
     * viewStub_profileContent.setLayoutResource(R.layout.custom_content_account_information);
     * View inflated = viewStub_profileContent.inflate();
     */
    abstract void setContentLayout();

    /**
     * Abstract class, Customize button action for each child activity
     */
    abstract void setCustomButtonAction();


}
