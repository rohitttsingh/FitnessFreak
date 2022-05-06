package com.example.fitnessfreak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class YogaSegmentActivity extends AppCompatActivity {
ImageView imageView;
    YouTubePlayerView youTubePlayerView;
    CardView cardView;
    TextView textView1,textView2,textView3,textView4,textView5,textView6;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_segment);

        cardView=findViewById(R.id.card1);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);
        textView4=findViewById(R.id.text4);
        textView5=findViewById(R.id.text5);
        textView6=findViewById(R.id.text6);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","sTANio_2E0Q");
                ActivityOptionsCompat optionsCompat =  ActivityOptionsCompat.makeSceneTransitionAnimation(YogaSegmentActivity.this
                        ,youTubePlayerView, ViewCompat.getTransitionName(youTubePlayerView));


                startActivity(intent,optionsCompat.toBundle());
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","4pKly2JojMw");
                startActivity(intent);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","UEEsdXn8oG8");
                startActivity(intent);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","nQwKKCqkJxg");
                startActivity(intent);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","Eml2xnoLpYE");
                startActivity(intent);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","EIqsDkpzOgo");
                startActivity(intent);
            }
        });



        youTubePlayerView=findViewById(R.id.youtube_player_view);
        imageView=findViewById(R.id.yogaimg);
        Picasso.get().load("https://rb.gy/kxdak7").into(imageView);
        getLifecycle().addObserver(youTubePlayerView);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "sTANio_2E0Q";
                youTubePlayer.loadVideo(videoId,0);
            }
        });



        youTubePlayerView.enterFullScreen();
        youTubePlayerView.exitFullScreen();
        // youTubePlayerView.isFullScreen();
        // youTubePlayerView.toggleFullScreen();



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}