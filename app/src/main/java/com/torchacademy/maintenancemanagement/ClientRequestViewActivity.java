package com.torchacademy.maintenancemanagement;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.torchacademy.maintenancemanagement.models.ClientRequest;

public class ClientRequestViewActivity extends AppCompatActivity {

    private static final String TAG = ClientRequestViewActivity.class.getSimpleName();
    private RelativeLayout request_status;
    private ImageView imageView_request_status;
    private ImageView imageView_request_status1;
    private ImageView imageView_request_status2;
    private ImageView imageView_request_status4;
    private ImageView imageView_request_status3;
    private ImageView imageButton_open_request_status;
    private TextView textView_request_status;
    private TextView textView_period_request_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_request_view);

        setupViews();
        Intent intent = getIntent();
        ClientRequest clientRequest = intent.getParcelableExtra("request");
        Log.d(TAG, "onCreate: " + clientRequest.getName());



        color_view(clientRequest,imageView_request_status1,
                imageView_request_status2,
                imageView_request_status3,
                imageView_request_status4,
                imageView_request_status,
                textView_request_status,
                textView_period_request_status);






    }

    public static void color_view(ClientRequest clientRequest,ImageView imageView_request_status1,
                                  ImageView imageView_request_status2,
                                  ImageView imageView_request_status3,
                                  ImageView imageView_request_status4,
                                  ImageView imageView_request_status,
                                  TextView textView_request_status,
                                  TextView textView_period_request_status) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"" + clientRequest.getName() + "\" is " );
        switch (clientRequest.getStatus()){
            case "Pending":

                imageView_request_status1.setBackgroundColor(Color.parseColor("#ff0000"));


                imageView_request_status.setImageResource(R.drawable.ic_icon_pending_24dp);
                imageView_request_status.setColorFilter(Color.parseColor("#ff0000"));

                stringBuilder.append("Pending");
                break;
            case "Open":
                imageView_request_status.setColorFilter(Color.parseColor("#ff0000"));
                imageView_request_status2.setBackgroundColor(Color.parseColor("#ff0000"));

                stringBuilder.append("Open");
                break;
            case "Ongoing":
                imageView_request_status3.setBackgroundColor(Color.parseColor("#ffff00"));

                imageView_request_status.setImageResource(R.drawable.ic_tab_ongoing);
                imageView_request_status.setColorFilter(Color.parseColor("#ffff00"));

                stringBuilder.append("Ongoing");
                break;
            case "Completed":

                imageView_request_status4.setBackgroundColor(Color.parseColor("#00ff00"));


                imageView_request_status.setImageResource(R.drawable.ic_tab_completed);
                imageView_request_status.setColorFilter(Color.parseColor("#00ff00"));

                stringBuilder.append("Completed");
                break;
        }

        textView_request_status.setText(stringBuilder.toString());
        textView_period_request_status.setText(clientRequest.getTime());
    }

    private void setupViews() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        request_status =(RelativeLayout) findViewById(R.id.request_status);
        imageButton_open_request_status= (ImageView) request_status.findViewById(R.id.imageButton_open_request_status);
        imageView_request_status = (ImageView) request_status.findViewById(R.id.imageView_request_status);
        imageView_request_status1= (ImageView) request_status.findViewById(R.id.imageView_request_status1);
        imageView_request_status2= (ImageView) request_status.findViewById(R.id.imageView_request_status2);
        imageView_request_status3= (ImageView) request_status.findViewById(R.id.imageView_request_status3);
        imageView_request_status4= (ImageView) request_status.findViewById(R.id.imageView_request_status4);
        textView_request_status =(TextView)request_status.findViewById(R.id.textView_request_status);
        textView_period_request_status =(TextView)request_status.findViewById(R.id.textView_period_request_status);
        imageButton_open_request_status.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return true;
    }
}
