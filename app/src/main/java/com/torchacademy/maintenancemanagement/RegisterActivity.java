package com.torchacademy.maintenancemanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neam.farroukh on 6/20/2016.
 */
public class RegisterActivity extends AppCompatActivity {
    Spinner spinner_building;
    List<String> building_lables;
    List<String> floor_lables;
    Spinner spinner_floor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setUpViews();
        building_lables = new ArrayList<>();
        floor_lables = new ArrayList<>();
        building_lables.add("Building Name");
        building_lables.add("Building 1");
        building_lables.add("Building 2");


        floor_lables.add("Floor #");
        floor_lables.add("Floor one");
        floor_lables.add("Floor two");
        loadSpinnerData();


    }

    private void loadSpinnerData() {

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, R.id.textview_spinner_item, building_lables);

        //Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);

        // attaching data adapter to spinner
        spinner_building.setAdapter(dataAdapter);


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, R.id.textview_spinner_item, floor_lables);

        //Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(R.layout.spinner_item);

        // attaching data adapter to spinner
        spinner_floor.setAdapter(dataAdapter2);
        ;
       /* final ArrayAdapter<String> adapter1 = new CustomizedSpinnerAdapter(
                RegisterActivity.this, android.R.layout.simple_spinner_item,
                building_lables);
        spinner_building.setAdapter(adapter1);*/
    }

    private void setUpViews() {
        spinner_building = (Spinner) findViewById(R.id.spinner_building);
        spinner_floor = (Spinner) findViewById(R.id.spinner_floor);

    }
}
