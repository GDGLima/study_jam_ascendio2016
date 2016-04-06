package com.carlospinan.playme.fragments;

import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlospinan.playme.R;
import com.carlospinan.playme.callback.OnTaskListener;
import com.carlospinan.playme.helpers.CustomAsyncTask;
import com.carlospinan.playme.helpers.Globals;
import com.carlospinan.playme.helpers.Helper;
import com.carlospinan.playme.models.AudioModel;

import java.io.IOException;

/**
 * @author Carlos Piñan
 */
public class DetailFragment extends Fragment implements OnTaskListener<Bitmap> {

    private static final int[] AUDIO_DRAWABLE_STATE = {android.R.drawable.ic_media_play, android.R.drawable.ic_media_pause};

    private boolean isPlaying;
    private AudioModel audioModel;
    private ImageView audioImageView;
    private ImageButton audioButton;
    private TextView audioTitleTextView, audioDescriptionTextView;
    private MediaPlayer mediaPlayer;
    private CustomAsyncTask<Bitmap> customAsyncTask;

    public static DetailFragment newInstance(AudioModel audioModel) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(Globals.AUDIO_KEY, audioModel);
        detailFragment.setArguments(arguments);
        return detailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(Globals.AUDIO_KEY)) {
            audioModel = (AudioModel) getArguments().getSerializable(Globals.AUDIO_KEY);
        } else {
            throw new IllegalArgumentException("Audio model not in the arguments.");
        }
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
        isPlaying = false;
        customAsyncTask = new CustomAsyncTask<>(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        audioImageView = (ImageView) view.findViewById(R.id.audioImageView);
        audioButton = (ImageButton) view.findViewById(R.id.audioButton);
        audioTitleTextView = (TextView) view.findViewById(R.id.audioTitleTextView);
        audioDescriptionTextView = (TextView) view.findViewById(R.id.audioDescriptionTextView);
        audioTitleTextView.setText(audioModel.getTitle());
        audioDescriptionTextView.setText(audioModel.getDescription());
        audioButton.setEnabled(false);
        mediaPlayer = Helper.getMediaPlayer(getActivity(), audioModel.getAudio());
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                isPlaying = true;
                audioButton.setEnabled(true);
                updateAudioButtonDrawable();
                mp.start();
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                isPlaying = false;
                updateAudioButtonDrawable();
            }
        });
        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (isPlaying) {
                        mediaPlayer.stop();
                    } else {
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    isPlaying = !isPlaying;
                    updateAudioButtonDrawable();
                }
            }
        });
        customAsyncTask.execute();
        return view;
    }

    private void updateAudioButtonDrawable() {
        if (isPlaying) {
            audioButton.setImageResource(AUDIO_DRAWABLE_STATE[1]);
        } else {
            audioButton.setImageResource(AUDIO_DRAWABLE_STATE[0]);
        }
    }

    @Override
    public void onPause() {
        if (customAsyncTask != null) {
            customAsyncTask.cancel(true);
        }
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            } catch (IllegalStateException e) {

            }
        }
        super.onPause();
    }

    @Override
    public void onInit() { /* UNUSED*/ }

    @Override
    public Bitmap onCall() {
        return Helper.getBitmapFromAsset(getActivity(), audioModel.getBitmap());
    }

    @Override
    public void onSuccess(Bitmap result) {
        audioImageView.setVisibility(View.VISIBLE);
        audioImageView.setImageBitmap(result);
    }

    @Override
    public void onFailed() {
        audioImageView.setVisibility(View.GONE);
    }

    @Override
    public void onCancelled() { /* UNUSED */ }
}
