package com.example.fitnessfreak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.transition.Fade;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class DashBoardActivity extends AppCompatActivity {
LinearLayout mdotslayout;
TextView dots[];
ViewPager2 viewPager2;
KenBurnsView kenBurnsView,kenBurnsView2,kenBurnsView3;
androidx.appcompat.widget.Toolbar toolbar;
SmoothBottomBar smoothBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        SharedPreferences shared = getSharedPreferences("Settings", MODE_PRIVATE);
        String channel = (shared.getString("bmi", ""));
       // String bmi=getIntent().getStringExtra("bmi");

        smoothBottomBar=findViewById(R.id.smooth);


         toolbar=findViewById(R.id.toolbar);
         if (channel.length()==0){
             toolbar.setTitle("BMI: Not set");

         }
         else  toolbar.setTitle("BMI: "+channel);
        toolbar.setNavigationIcon(R.drawable.bacharrow);
        setSupportActionBar(toolbar);

         toolbar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),BMIActivity.class));
             }
         });

         toolbar.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onBackPressed();
             }
         });
        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                switch (i){
                    case 0:
                        break;
                    case 1: startActivity(new Intent(getApplicationContext(),PremiumActivity.class));
                        break;

                    case 2: startActivity(new Intent(getApplicationContext(),DietActivity.class));
                        break;
                    case 3:startActivity(new Intent(getApplicationContext(),MotivationActivity.class));
                    break;
                    case 4: startActivity(new Intent(getApplicationContext(),ExerciseChartActivity.class));
                        break;

                }
                return true;
            }
        });


        mdotslayout=findViewById(R.id.indicator);
        kenBurnsView=findViewById(R.id.image1v);
        kenBurnsView2=findViewById(R.id.image2v);
        kenBurnsView3=findViewById(R.id.image3v);

        Picasso.get().load("https://rb.gy/5cw3gd").into(kenBurnsView);
        Picasso.get().load("https://rb.gy/kxdak7").into(kenBurnsView2);
        Picasso.get().load("https://rb.gy/i4mhd5").into(kenBurnsView3);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        viewPager2=findViewById(R.id.locationViewPager);
        List<HorizontalImage> horizontalImages= new ArrayList<>();

        HorizontalImage travelLocationEiffeltower= new HorizontalImage();
        travelLocationEiffeltower.imageurl="https://rb.gy/xlela0";
        travelLocationEiffeltower.description="Tutorial Videos";
        travelLocationEiffeltower.title="Yoga";
        horizontalImages.add(travelLocationEiffeltower);

        HorizontalImage travelLocationMountainView= new HorizontalImage();
        travelLocationMountainView.imageurl="https://rb.gy/fmttks";
        travelLocationMountainView.description="Expert Diet Chart";
        travelLocationMountainView.title="Diet";
        horizontalImages.add(travelLocationMountainView);

        HorizontalImage travelLocationMountainView2= new HorizontalImage();
        travelLocationMountainView2.imageurl="https://rb.gy/dfs7cx";
        travelLocationMountainView2.description="Quotes";
        travelLocationMountainView2.title="Daily Motivation";
        horizontalImages.add(travelLocationMountainView2);


        HorizontalImage smartreminder= new HorizontalImage();
        smartreminder.imageurl="https://rb.gy/ttj2b9";
        smartreminder.description="Notification";
        smartreminder.title="Smart Reminder";
        horizontalImages.add(smartreminder);//

        HorizontalImage exercisechart= new HorizontalImage();
        exercisechart.imageurl="https://rb.gy/wvdluh";
        exercisechart.description="Daily Schedule";
        exercisechart.title="Exercise Chart";
        horizontalImages.add(exercisechart);//

        HorizontalImage aicoach= new HorizontalImage();
        aicoach.imageurl="https://rb.gy/lunhlu";
        aicoach.description="Personal Coach";
        aicoach.title="AI Coach";
        horizontalImages.add(aicoach);//

        HorizontalImage fitnessmusic= new HorizontalImage();
        fitnessmusic.imageurl="https://rb.gy/zeaabk";
        fitnessmusic.description="Listen and Play";
        fitnessmusic.title="Exercise Playlist";
        horizontalImages.add(fitnessmusic);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        kenBurnsView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),YogaSegmentActivity.class);
                ActivityOptionsCompat optionsCompat =  ActivityOptionsCompat.makeSceneTransitionAnimation(DashBoardActivity.this
                        ,kenBurnsView2, ViewCompat.getTransitionName(kenBurnsView2));

                startActivity(intent,optionsCompat.toBundle());
            }
        });
        kenBurnsView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),WeightLiftSegmentActivity.class);
                ActivityOptionsCompat optionsCompat =  ActivityOptionsCompat.makeSceneTransitionAnimation(DashBoardActivity.this
                        ,kenBurnsView3, ViewCompat.getTransitionName(kenBurnsView3));

                startActivity(intent,optionsCompat.toBundle());
            }
        });
        kenBurnsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MeditationSegmentActivity.class);
                ActivityOptionsCompat optionsCompat =  ActivityOptionsCompat.makeSceneTransitionAnimation(DashBoardActivity.this
                        ,kenBurnsView, ViewCompat.getTransitionName(kenBurnsView));

                startActivity(intent,optionsCompat.toBundle());
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
               // Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_LONG).show();
                setupindicator(position);
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        viewPager2.setAdapter(new HorizontalImageAdapter(horizontalImages,viewPager2));

        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(2));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
    }

    public  void setupindicator(int position){
        dots=new TextView[7];
        mdotslayout.removeAllViews();

        for (int i=0 ;i<dots.length;i++){
            dots[i]= new TextView(DashBoardActivity.this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.black));
            mdotslayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.red));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void gotoNotification(View view) {
        startActivity(new Intent(getApplicationContext(),NotificationManagementActivity.class));
    }
}