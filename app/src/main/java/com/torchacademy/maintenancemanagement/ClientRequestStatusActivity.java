package com.torchacademy.maintenancemanagement;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.torchacademy.maintenancemanagement.adapters.RequestAdapter;

public class ClientRequestStatusActivity extends AppCompatActivity {

    private ViewPager viewPager_request_status;
    private TabLayout tabLayout_request_status;
    private String TAG = ClientRequestStatusActivity.class.getSimpleName();

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
        viewPager_request_status.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout_request_status));

        tabLayout_request_status.setupWithViewPager(viewPager_request_status);

                setupTabLayout();

    }

    private void setupTabLayout() {
        RelativeLayout tab1 = (RelativeLayout) LayoutInflater
                .from(ClientRequestStatusActivity.this)
                .inflate(R.layout.request_tab_layout,null);

        RelativeLayout tab2 = (RelativeLayout) LayoutInflater
                .from(ClientRequestStatusActivity.this)
                .inflate(R.layout.request_tab_layout,null);

        RelativeLayout tab3 = (RelativeLayout) LayoutInflater
                .from(ClientRequestStatusActivity.this)
                .inflate(R.layout.request_tab_layout,null);

        RelativeLayout tab4 = (RelativeLayout) LayoutInflater
                .from(ClientRequestStatusActivity.this)
                .inflate(R.layout.request_tab_layout, null, false);

        ImageView imageView = (ImageView) tab1.findViewById(R.id.imageView_tab_picture);
        imageView.setImageResource(R.drawable.ic_all_requests);

        TextView textView = (TextView) tab1.findViewById(R.id.textView_tab_name);
        textView.setText("All Requests");

        imageView = (ImageView) tab2.findViewById(R.id.imageView_tab_picture);
        imageView.setImageResource(R.drawable.ic_tab_pending);

        textView = (TextView) tab2.findViewById(R.id.textView_tab_name);
        textView.setText("Pending");

        imageView = (ImageView) tab3.findViewById(R.id.imageView_tab_picture);
        imageView.setImageResource(R.drawable.ic_tab_ongoing);

        textView = (TextView) tab3.findViewById(R.id.textView_tab_name);
        textView.setText("Ongoing");

        imageView = (ImageView) tab4.findViewById(R.id.imageView_tab_picture);
        imageView.setImageResource(R.drawable.ic_tab_completed);

        textView = (TextView) tab4.findViewById(R.id.textView_tab_name);
        textView.setText("Completed");

        Log.d(TAG, "setupTabLayout: " + ((TextView) tab1.findViewById(R.id.textView_tab_name)).getText());
        tabLayout_request_status.getTabAt(0).setCustomView(tab1);
        tabLayout_request_status.getTabAt(1).setCustomView(tab2);
        tabLayout_request_status.getTabAt(2).setCustomView(tab3);
        tabLayout_request_status.getTabAt(3).setCustomView(tab4);

        tabLayout_request_status.getTabAt(0)
                .getCustomView()
                .setBackgroundColor(Color.parseColor("#3f51b5"));


        tabLayout_request_status.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().setBackgroundColor(Color.parseColor("#3f51b5"));
                viewPager_request_status.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().setBackgroundColor(Color.parseColor("#a3a3a3"));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
