package com.torchacademy.maintenancemanagement;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mahmoud.elferekh on 6/21/2016.
 */
public class ValidationActivity extends AppCompatActivity {
    private int random;
    private EditText verificationCode;
    private Button verify;
    private int check;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {


            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            getSupportActionBar().hide();

        }

        setContentView(R.layout.activity_validation);
        sendValidationCode();

        findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verificationCode = (EditText) findViewById(R.id.editText_validation);
                if (!verificationCode.getText().toString().trim().isEmpty()) {
                    if (Integer.parseInt(verificationCode.getText().toString()) == random) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Verification Code", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        findViewById(R.id.textView_text4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendValidationCode();
            }
        });
    }

    private void sendValidationCode() {
        random = (int)(Math.random()*1000);
        Toast.makeText(getApplicationContext(), ""+random,Toast.LENGTH_LONG).show();
    }
}
