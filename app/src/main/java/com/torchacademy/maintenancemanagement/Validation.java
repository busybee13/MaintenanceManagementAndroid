package com.torchacademy.maintenancemanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mahmoud.elferekh on 6/21/2016.
 */
public class Validation extends AppCompatActivity {
    private int random;
    private EditText verificationCode;
    private Button verify;
    private int check;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        random = (int)(Math.random()*1000);
        Toast.makeText(getApplicationContext(), ""+random,Toast.LENGTH_LONG).show();
        findViewById(R.id.button_verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verificationCode = (EditText) findViewById(R.id.editText_verificationCode);
                if (!verificationCode.getText().toString().trim().isEmpty()) {
                    if (Integer.parseInt(verificationCode.getText().toString()) == random) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Verification Code", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
}
