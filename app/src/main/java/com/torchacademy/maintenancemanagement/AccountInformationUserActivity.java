package com.torchacademy.maintenancemanagement;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by omar.elmasri on 6/21/2016.
 */
public class AccountInformationUserActivity extends AccountInformationBaseActivity {
    private View inflated;

    @Override
    void setContentLayout() {
        viewStub_profileContent.setLayoutResource(R.layout.content_account_information_user);
        inflated = viewStub_profileContent.inflate();
    }

    @Override
    void setCustomButtonAction() {
        Drawable plusDrawable = getBaseContext().getResources().getDrawable( R.drawable.ic_add_black_24dp );

        button_customProfileAction.setCompoundDrawables(plusDrawable,null,null,null);
        button_customProfileAction.setText("Add Property");

        button_customProfileAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
