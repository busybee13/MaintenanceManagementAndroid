package com.torchacademy.maintenancemanagement;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ibrahim.alkasti on 6/21/2016.
 */
public class AccountInformationExpertActivity extends AccountInformationBaseActivity {

    private TextView textView_technicianTypeValue;
    private TextView textView_locationValue;
    private TextView textView_availabilityValue;

    @Override
    void setContentLayout() {
        // Inflate the Expert Content layout into the stub
        viewStub_profileContent.setLayoutResource(R.layout.content_account_information_expert);
        viewStub_profileContent.inflate();
        textView_technicianTypeValue = (TextView) findViewById(R.id.textView_technicianTypeValue);
        textView_locationValue = (TextView) findViewById(R.id.textView_locationValue);
        textView_availabilityValue = (TextView) findViewById(R.id.textView_availabilityValue);
        setValues();
    }

    /**
     * Customize the action button for the expert's "Off Duty" function
     */
    @Override
    void setCustomButtonAction() {
        button_customProfileAction.setText("Off Duty");
        button_customProfileAction.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_menu_close_clear_cancel,0,0,0);
        button_customProfileAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do off duty action
            }
        });
    }

    void setValues() {
        textView_availabilityValue.setText("dummy availability");
        textView_locationValue.setText("dummy location");
        textView_technicianTypeValue.setText("dummy type");

    }
}
