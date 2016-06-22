package com.torchacademy.maintenancemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class NewRequestActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button button_urgent;
    boolean button_urgent_toggled;

    private Spinner spinner_propertyList;
    ArrayList<String> propertyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);
        setupViews();
    }

    private void setupViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_request);
        setSupportActionBar(toolbar);

        button_urgent = (Button) findViewById(R.id.button_urgent);
        button_urgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUrgentButtonClick();
            }
        });
        populatePropertyList();
        spinner_propertyList=(Spinner)findViewById(R.id.spinner_propertyList);


        spinner_propertyList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,propertyList));
    }

    private void populatePropertyList(){
        propertyList = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            propertyList.add("Property " + i);
        }
    }

    private void onUrgentButtonClick(){
        if(!button_urgent_toggled){
            button_urgent.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            button_urgent.setTextColor(getResources().getColor(android.R.color.white));
            button_urgent_toggled = true;
        }else{
            button_urgent.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            button_urgent.setTextColor(getResources().getColor(R.color.colorPrimary));
            button_urgent_toggled = false;
        }



    }
}
