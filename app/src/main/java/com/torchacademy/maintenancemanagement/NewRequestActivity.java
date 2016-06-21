package com.torchacademy.maintenancemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class NewRequestActivity extends AppCompatActivity {

    Toolbar toolbar;

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
}
