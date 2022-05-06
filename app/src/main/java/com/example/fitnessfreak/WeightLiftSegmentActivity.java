package com.example.fitnessfreak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class WeightLiftSegmentActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_lift_segment);
        ImageView imageView=findViewById(R.id.imgweight);
        Picasso.get().load("https://rb.gy/i4mhd5").into(imageView);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);
        textView4=findViewById(R.id.text4);
        textView5=findViewById(R.id.text5);
        textView6=findViewById(R.id.text6);
        textView7=findViewById(R.id.text7);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","ILIe_KJ_bKk");
//                ActivityOptionsCompat optionsCompat =  ActivityOptionsCompat.makeSceneTransitionAnimation(WeightLiftSegmentActivity.this
//                        ,youTubePlayerView, ViewCompat.getTransitionName(youTubePlayerView));


                startActivity(intent);//,optionsCompat.toBundle());
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","8LJ3Q3Fsrzs");
                startActivity(intent);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","mqfzsbV0lUs");
                startActivity(intent);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","rj0eWvZ4Deo");
                startActivity(intent);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","8PwoytUU06g");
                startActivity(intent);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","Vk3Q8WvUwf4");
                startActivity(intent);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","q7rCeOa_m58");
                startActivity(intent);
            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}