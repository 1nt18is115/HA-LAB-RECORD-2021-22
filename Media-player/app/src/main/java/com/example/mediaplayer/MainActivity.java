package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton play, pause, rewind, forward, reset, stop;
    MediaPlayer mediaPlayer, newPlayer;
    TextView title;
    int Tstart = 0;
    int Tstop = 0;
    int Tforward = 5000;
    int Tbackward = 5000;
    View view;

    MediaPlayer createMedia() {
        newPlayer = MediaPlayer.create(this, R.raw.papercut);
        return newPlayer;
    }

    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = createMedia();
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        rewind = findViewById(R.id.rewind);
        forward = findViewById(R.id.forward);
        reset = findViewById(R.id.reset);
        stop = findViewById(R.id.stop);

        title = findViewById(R.id.songTitle);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Papercut");
                Toast.makeText(MainActivity.this, "Playing Media now", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Media player");
                Toast.makeText(MainActivity.this, "Media Stopped", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer = createMedia();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Papercut");
                mediaPlayer.reset();
                mediaPlayer = createMedia();
                mediaPlayer.start();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+Tforward) <= (Tstop =
                        mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos + Tforward);
                }
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos - Tbackward) <= (Tstop =
                        mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos - Tbackward);
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Papercut");
                Toast.makeText(MainActivity.this, "Pausing Media now", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

    }
}