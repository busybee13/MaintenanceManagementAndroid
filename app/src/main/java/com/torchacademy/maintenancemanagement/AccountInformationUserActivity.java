package com.torchacademy.maintenancemanagement;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by omar.elmasri on 6/21/2016.
 */
public class AccountInformationUserActivity extends AccountInformationBaseActivity {
    private View inflated;
    private TextView textView_buildingName;
    private TextView textView_aptNumber;

    @Override
    void setContentLayout() {
        viewStub_profileContent.setLayoutResource(R.layout.content_account_information_user);
        inflated = viewStub_profileContent.inflate();
        textView_buildingName = (TextView) findViewById(R.id.textView_buildingName);
        textView_aptNumber = (TextView) findViewById(R.id.textView_aptNumber);
    }

    @Override
    void setCustomButtonAction() {
        button_customProfileAction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_add_white_24dp,0,0,0);
        button_customProfileAction.setText("Add Property");

        button_customProfileAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
}
