package com.torchacademy.maintenancemanagement.Adapter;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.torchacademy.maintenancemanagement.R;
import com.torchacademy.maintenancemanagement.pojos.VoiceNote;
import com.torchacademy.maintenancemanagement.utils.AudioUtils;

import java.util.List;

/**
 * Created by riad.rifai on 6/22/2016.
 */
public class AudioRecyclerAdapter extends RecyclerView.Adapter<AudioRecyclerAdapter.MyViewHolder> {

    private List<VoiceNote> audioList;
    private boolean isPlaying = false;

    public AudioRecyclerAdapter(List<VoiceNote> audioList) {
        this.audioList = audioList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.audio_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final VoiceNote voiceNote = audioList.get(holder.getAdapterPosition());
        holder.audioDuration.setText(voiceNote.convertTimeToString());

        /*
        On Click Listener for pausing and playing the recorded voice note
        */
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                //If the audio is playing, pause it and change the background
                if(isPlaying) {
                    AudioUtils.pausePlaying();
                    isPlaying = false;
                    holder.imageButton.setBackgroundColor(ContextCompat.getColor(v.getContext(),
                            R.color.colorPrimary));
                } else {
                    //Here, start playing the audio on click and change background
                    //Single instance of media player/start playing
                    AudioUtils.startPlaying(voiceNote.getFilePath());
                    holder.imageButton.setBackgroundColor(ContextCompat.getColor(v.getContext(),
                            R.color.buttonClicked));
                    isPlaying = true;

                    /*
                    On Completion listener, in case the audio is playing and it finished, we must
                    release the media player set it to null and update the background
                     */
                    AudioUtils.getMediaPlayer().setOnCompletionListener(
                            new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            holder.imageButton.setBackgroundColor(ContextCompat.getColor(
                                    v.getContext(), R.color.colorPrimary));
                            isPlaying = false;
                            AudioUtils.releaseMediaPlayer();
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return audioList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView audioDuration;
        public ImageButton imageButton;

        public MyViewHolder(View view) {
            super(view);
            audioDuration = (TextView) view.findViewById(R.id.text_view_duration);
            imageButton = (ImageButton)view.findViewById(R.id.image_button_voice_note);
        }
    }
}
