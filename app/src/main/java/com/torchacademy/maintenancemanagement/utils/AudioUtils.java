package com.torchacademy.maintenancemanagement.utils;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;

import java.io.IOException;

/**
 * Created by riad.rifai on 6/22/2016.
 */

/*
This class initializes the recorder once.
It's a static tool that allows you to record anywhere in the project
Ex: AudioUtils.startRecording();
 */
public class AudioUtils {

    //Fields for recorder
    private static MediaRecorder mediaRecorder;
    private static String outputFile = null;
    private static boolean canRecord = true;

    //for file name and number of recorded audios
    private static int counter = 0;

    //Fields for media player
    private static MediaPlayer mediaPlayer;



    //private initializer for recorder
    private static void initializeRecorder () {
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording" + counter + ".mp3";
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(outputFile);
    }

    //private initializer for media player
    //media player single instance
    private static void initializePlayer(String filePath){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
        } catch (IOException e) {

        }
    }

    public static String getFilePath() {
        return outputFile;
    }

    public static int getCounter() {
        return counter;
    }

    //Initialized the media recorder once and prepares it
    public static void startRecording(){

        if(mediaRecorder == null)
            initializeRecorder();

        canRecord = false;
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    //Stops recording and releases the recorder, then increments the counter
    public static void stopRecording(){
        canRecord = true;
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        counter++;
    }


    /*
    Initializes the media player if null
    And starts playing
     */
    public static void startPlaying(String filePath){
        if(mediaPlayer == null)
            initializePlayer(filePath);

        mediaPlayer.start();
    }

    /*
    Pause the media player
     */
    public static void pausePlaying(){
        mediaPlayer.pause();
    }

    /*
    Release is used when the media is done playing/stopped
     */
    public static void releaseMediaPlayer() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static boolean isCanRecord() {
        return canRecord;
    }
}
