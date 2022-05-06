package com.example.fitnessfreak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ExerciseChartActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    androidx.appcompat.widget.Toolbar toolbar;
    LinearLayout mdotslayout;
    TextView dots[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_chart);
        viewPager2 = findViewById(R.id.viewpagerchart);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.bacharrow);
        setSupportActionBar(toolbar);
        mdotslayout=findViewById(R.id.indicator);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        List<ExerciseChartitems> exerciseChartitems= new ArrayList<>();

        ExerciseChartitems chart1=new ExerciseChartitems();
        chart1.imageurl="https://rb.gy/dapohs";
        exerciseChartitems.add(chart1);

        ExerciseChartitems chart2=new ExerciseChartitems();
        chart2.imageurl="https://rb.gy/rglg73";
        exerciseChartitems.add(chart2);

        ExerciseChartitems chart3=new ExerciseChartitems();
        chart3.imageurl="https://rb.gy/xitkqg";
        exerciseChartitems.add(chart3);

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


        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(5));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.setAdapter(new ExerciseChartAdapter(exerciseChartitems,viewPager2));

    }
    public  void setupindicator(int position){
        dots=new TextView[3];
        mdotslayout.removeAllViews();

        for (int i=0 ;i<dots.length;i++){
            dots[i]= new TextView(ExerciseChartActivity.this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.white));
            mdotslayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.red));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}