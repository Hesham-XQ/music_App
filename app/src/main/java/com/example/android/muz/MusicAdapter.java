package com.example.android.muz;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by SAMO on 3/1/2018.
 */


public class MusicAdapter extends ArrayAdapter {
    private MediaPlayer mp;
    private AudioManager mAudioManager;
    private int mColorResourceId;

    public MusicAdapter(Context context, ArrayList<Music> pMusic, int colorResourceID) {
        super(context, 0, pMusic);
        mColorResourceId = colorResourceID;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Music my_music = (Music) getItem(position);
        TextView songTitle = (TextView) listItemView.findViewById(R.id.song);
        songTitle.setText(my_music.getSong());
        TextView artistTitle = (TextView) listItemView.findViewById(R.id.artist);
        artistTitle.setText(my_music.getArtist());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(my_music.getMimgResourceId());

        View textContainer = listItemView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        final ImageView play = (ImageView) listItemView.findViewById(R.id.play);
        ImageView restart = (ImageView) listItemView.findViewById(R.id.restart);
        ImageView stop = (ImageView) listItemView.findViewById(R.id.stop);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mp == null) {
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        mp = MediaPlayer.create(getContext(), my_music.getResourceid());

                        mp.start();
                        play.setImageResource(R.drawable.ic_pause);
                    }
                    mp.setOnCompletionListener(mCompletionListener);


                } else if (mp != null) {
                    if (mp.isPlaying()) {
                        mp.pause();
                        play.setImageResource(R.drawable.ic_play_arrow);
                        Toast.makeText(getContext(), R.string.paused, Toast.LENGTH_SHORT).show();
                    } else {
                        int length = mp.getCurrentPosition();
                        mp.seekTo(length);
                        mp.start();
                        play.setImageResource(R.drawable.ic_pause);
                        Toast.makeText(getContext(), R.string.playing, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Song Restart", Toast.LENGTH_SHORT).show();
                if (mp != null) {
                    mp.seekTo(0);
                    mp.start();
                    play.setImageResource(R.drawable.ic_pause);
                }

                if (mp == null) {
                    mp = MediaPlayer.create(getContext(), my_music.getResourceid());
                    mp.start();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), R.string.stopped, Toast.LENGTH_SHORT).show();
                if (mp != null) {
                    mp.release();
                    mp = null;
                    play.setImageResource(R.drawable.ic_play_arrow);
                }

            }
        });
        return listItemView;
    }

    // Clean up the media player by releasing its resources.
    private void releaseMediaPlayer() {
        if (mp != null) {
            mp.release();
            mp = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mp.pause();
                mp.seekTo(0);

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mp.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();

        }
    };

}



