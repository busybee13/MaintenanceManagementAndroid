package com.torchacademy.maintenancemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class ClientPanel extends AppCompatActivity {

    private Button button_newRequest;
    private Button button_accountInfo;
    private Button button_requestStatus;
    private Button button_newMessage;
    private Button button_inbox;
    private Toolbar panel_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_panel);

        setUpViews();
        panel_toolbar.setTitle("My Home");
        panel_toolbar.setNavigationIcon(R.drawable.ic_account_info);

        button_newMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientPanel.this, SendMessageActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setUpViews() {
        button_newRequest = (Button) findViewById(R.id.button_newRequest);
        button_accountInfo = (Button) findViewById(R.id.button_accountInfo);
        button_requestStatus = (Button) findViewById(R.id.button_requestStatus);
        button_newMessage = (Button) findViewById(R.id.button_newMessage);
        button_inbox = (Button) findViewById(R.id.button_inbox);
        panel_toolbar = (Toolbar) findViewById(R.id.panel_toolbar);

    }


}
