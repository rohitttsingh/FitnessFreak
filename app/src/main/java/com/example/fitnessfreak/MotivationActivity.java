package com.example.fitnessfreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

public class MotivationActivity extends AppCompatActivity {
ImageView imageView;
RoundedImageView roundedImageView1,roundedImageView2,roundedImageView3,roundedImageView4;
RoundedImageView roundedImageView5;
TextView textView1,textView2,textView3,textView4;
androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        imageView=findViewById(R.id.imgview);
        roundedImageView1=findViewById(R.id.motiimg1);
        roundedImageView2=findViewById(R.id.motiimg2);
        roundedImageView3=findViewById(R.id.motiimg3);
        roundedImageView4=findViewById(R.id.motiimg4);
        roundedImageView5=findViewById(R.id.motiimg5);

        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);
        textView4=findViewById(R.id.text4);
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
                Intent intent=new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","Z63w5PefxTQ");
                startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","tbnzAVRZ9Xc");
                startActivity(intent);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","hKsNVL5Mag8");
                startActivity(intent);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainVideoPlayingActivity.class);
                intent.putExtra("videoId","loB4aMdlKaI");
                startActivity(intent);
            }
        });



        Picasso.get().load("https://rb.gy/omsuxa").into(roundedImageView1);
        Picasso.get().load("https://rb.gy/ootmmg").into(imageView);
        Picasso.get().load("https://rb.gy/kxa3pm").into(roundedImageView2);
        Picasso.get().load("https://rb.gy/8bkylu").into(roundedImageView3);
        Picasso.get().load("https://rb.gy/jpmoxt").into(roundedImageView4);
        Picasso.get().load("https://rb.gy/6yt37l").into(roundedImageView5);

        //
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}