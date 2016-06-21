package com.torchacademy.maintenancemanagement;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ExpertPanelActivity extends AppCompatActivity {

    private TextView textView_incoming_requests_notification;
    private TextView textView_my_requests_notification;
    private TextView textView_inbox_notification;

    private int incomingRequestsCounter = 0;
    private int myRequestsCounter = 0;
    private int inboxCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_panel);

        getSupportActionBar().setTitle("My Home");

        setupViews();
    }

    @Override
    protected void onStart() {
        super.onStart();

        resetCounters();
    }

    /**
     * Omar Halabi and Ahmad Masri
     */
    private void setupViews() {
        textView_incoming_requests_notification = (TextView)
                findViewById(R.id.textView_incoming_requests_notification);

        textView_incoming_requests_notification.setVisibility(View.GONE);

        textView_my_requests_notification = (TextView)
                findViewById(R.id.textView_my_requests_notification);

        textView_my_requests_notification.setVisibility(View.GONE);

        textView_inbox_notification = (TextView) findViewById(R.id.textView_inbox_notification);

        textView_inbox_notification.setVisibility(View.GONE);

    }

    /**
     * Omar Halabi and Ahmad Masri
     */
    private void resetCounters() {

        // TODO: 6/21/2016 Implement this method

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);


    }
}
