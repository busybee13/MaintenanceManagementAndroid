package com.torchacademy.maintenancemanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.torchacademy.maintenancemanagement.Adapter.AudioRecyclerAdapter;
import com.torchacademy.maintenancemanagement.pojos.VoiceNote;
import com.torchacademy.maintenancemanagement.utils.AudioUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SendMessageActivity extends AppCompatActivity {

    private Toolbar message_toolbar;
    private EditText edit_text_recipient;
    private ImageButton image_button_add_recipient;
    private EditText edit_text_subject;
    private EditText edit_text_message;
    private ImageButton image_button_add_image;
    private ImageButton image_button_add_voice_note;
    private RecyclerView recycler_voice;
    private AudioRecyclerAdapter audioRecyclerAdapter;
    private List<VoiceNote> audioList = new ArrayList<>();


    //List for elements inside contacts dialog
    List<CharSequence> contactDialogElements = new ArrayList<>();


    private Chronometer chronometer_audio_record;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_activity);

        setUpViews();
        message_toolbar.setTitle("New Message");
        message_toolbar.setNavigationIcon(R.drawable.ic_home_icon);

        //Fills the contacts dialog with dumb data
        addElements();



        audioRecyclerAdapter = new AudioRecyclerAdapter(audioList);

        //Recycler view adapter and layout manager
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.HORIZONTAL, false);

        recycler_voice.setLayoutManager(mLayoutManager);
        recycler_voice.setItemAnimator(new DefaultItemAnimator());
        recycler_voice.setAdapter(audioRecyclerAdapter);


        image_button_add_voice_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AudioUtils.isCanRecord()) {
                    //Returns the chronometer to its initial location
                    chronometer_audio_record.animate().translationX(0);
                    image_button_add_voice_note.setBackgroundColor(ContextCompat.getColor(
                            v.getContext(), R.color.buttonClicked));
                    chronometer_audio_record.setVisibility(View.VISIBLE);

                    //reset timer to 0
                    chronometer_audio_record.setBase(SystemClock.elapsedRealtime());
                    chronometer_audio_record.start();
                    AudioUtils.startRecording();
                } else {
                    AudioUtils.stopRecording();
                    chronometer_audio_record.stop();
                    VoiceNote recordedVn = new VoiceNote(AudioUtils.getFilePath(),
                            String.valueOf(AudioUtils.getCounter()));

                    chronometer_audio_record.animate().alpha(0.0f)
                            .translationX(chronometer_audio_record.getWidth())
                            .setDuration(350);

                    chronometer_audio_record.setVisibility(View.GONE);

                    image_button_add_voice_note.setBackgroundColor(ContextCompat.getColor(
                            v.getContext(), R.color.colorPrimary));

                    //This gives the recorded audio its duration
                    recordedVn.setDuration(SystemClock.elapsedRealtime() -
                            chronometer_audio_record.getBase());

                    //Add to index 0 so the recycler adapter add it at the beginning
                    audioList.add(0, recordedVn);

                    //Update item 0(inserted item)
                    audioRecyclerAdapter.notifyItemInserted(0);

                }
            }
        });



        /*
            On click of add contacts button
            Fills up the dialog and pops it up
         */

        image_button_add_recipient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize  readable sequence of char values/contacts/dummy data
                final CharSequence[] dialogList = SendMessageActivity.this
                        .contactDialogElements
                        .toArray(new CharSequence[SendMessageActivity
                                .this.contactDialogElements.size()]);

                //Pops up the alert dialog
                final AlertDialog.Builder builderDialog =
                        new AlertDialog.Builder(SendMessageActivity.this);

                builderDialog.setTitle("Select Contact");
                int count = dialogList.length;

                //Array of checked contacts inside the dialog
                boolean[] is_checked = new boolean[count];

                //For multiple checks
                builderDialog.setMultiChoiceItems(dialogList, is_checked,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton, boolean isChecked) {
                            }
                        });

                /*
                Create OK button and handle its event.
                Creates a string builder of all the elements that were chosen inside the
                alert dialog
                 */
                builderDialog.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                ListView list = ((AlertDialog) dialog).getListView();
                                // make selected item in the comma separated string
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 0; i < list.getCount(); i++) {
                                    boolean checked = list.isItemChecked(i);

                                    if (checked) {
                                        if (stringBuilder.length() > 0) stringBuilder.append(",");
                                        stringBuilder.append(list.getItemAtPosition(i));
                                    }
                                }

                        /*Check string builder is empty or not. If string builder is not empty.
                          It will toast on the screen.
                         */
                                if (stringBuilder.toString().trim().equals("")) {
                                    stringBuilder.setLength(0);
                                    Toast.makeText(SendMessageActivity.this,
                                            "No contact was chosen!",
                                            Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(SendMessageActivity.this,
                                            stringBuilder.toString(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                /*
                Create a cancel button and handle its event
                 */
                builderDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SendMessageActivity.this,
                                        "Cancel button was Clicked",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                //Show the dialog
                AlertDialog alert = builderDialog.create();
                alert.show();
            }
        });
    }


    /*
    Dummy data inside the list of contacts
     */
    private void addElements(){
        for (int i = 0; i < 20; i++) {
            contactDialogElements.add("test " + i);  // Add the item in the list
        }
    }

    private void setUpViews() {
        message_toolbar = (Toolbar) findViewById(R.id.message_toolbar);
        edit_text_recipient = (EditText) findViewById(R.id.edit_text_recipient);
        image_button_add_recipient = (ImageButton) findViewById(R.id.image_button_add_recipient);
        edit_text_subject = (EditText) findViewById(R.id.edit_text_subject);
        edit_text_message = (EditText) findViewById(R.id.edit_text_message);
        image_button_add_image = (ImageButton) findViewById(R.id.image_button_add_image);
        image_button_add_voice_note = (ImageButton) findViewById(R.id.image_button_add_voice_note);
        recycler_voice = (RecyclerView) findViewById(R.id.recycler_voice);
        chronometer_audio_record = (Chronometer) findViewById(R.id.chronometer_audio_record);
    }


}
