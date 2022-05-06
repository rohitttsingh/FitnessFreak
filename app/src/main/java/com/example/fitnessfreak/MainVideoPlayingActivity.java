package com.example.fitnessfreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MainVideoPlayingActivity extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_video_playing);
        String videoId=getIntent().getStringExtra("videoId");

        youTubePlayerView=findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                youTubePlayer.loadVideo(videoId,0);
            }
        });
        youTubePlayerView.enterFullScreen();
        youTubePlayerView.exitFullScreen();
         youTubePlayerView.isFullScreen();
        youTubePlayerView.toggleFullScreen();

    }

    @Override
    public void onBackPressed() {
//startActivity(new Intent(getApplicationContext(),DashBoardActivity.class));
        super.onBackPressed();
    }
}