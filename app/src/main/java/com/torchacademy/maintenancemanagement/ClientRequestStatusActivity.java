package com.torchacademy.maintenancemanagement;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ClientRequestStatusActivity extends AppCompatActivity {

    private ViewPager viewPager_request_status;
    private TabLayout tabLayout_request_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_request_status);

        setupViews();

    }

    private void setupViews() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar);

        View view = actionBar.getCustomView();
        TextView textView_title = (TextView) view.findViewById(R.id.textView_title);
        textView_title.setText("My Requests");

        tabLayout_request_status = (TabLayout) findViewById(R.id.tabLayout_request_status);

        viewPager_request_status = (ViewPager) findViewById(R.id.viewPager_request_status);

        viewPager_request_status.setAdapter(new RequestAdapter(getSupportFragmentManager()));
    }
}
