package com.torchacademy.maintenancemanagement.pojos;

import android.media.MediaPlayer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by riad.rifai on 6/22/2016.
 */
public class VoiceNote {
    private String filePath;

    //File name should have included the recording name, NOT USED FOR NOW
    private String fileName;

    private long duration;

    public VoiceNote(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }



    /*
    Returns a string of the formatted time
    ex: mm:ss
     */
    public String convertTimeToString() {

        String formattedTime = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));

        return formattedTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

}
