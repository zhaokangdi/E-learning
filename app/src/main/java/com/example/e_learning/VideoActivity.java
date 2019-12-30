package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.net.Uri;

public class VideoActivity extends AppCompatActivity {

    private Button video_play;
    private Button video_stop;
    private VideoView android_video;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
    }

    private void initView() {
        android_video = (VideoView) findViewById(R.id.android_video);
        video_play = (Button) findViewById(R.id.video_play);
        video_stop = (Button) findViewById(R.id.video_stop);

        video_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        video_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android_video.stopPlayback();
            }
        });
    }

    private void init() {
        android_video = (VideoView) findViewById(R.id.android_video);
        mediaController = new MediaController(this);
        String uri = "https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4";
        android_video.setVideoURI(Uri.parse(uri));
        android_video.setMediaController(mediaController);
        mediaController.setMediaPlayer(android_video);
        android_video.requestFocus();
        android_video.start();
    }
}
