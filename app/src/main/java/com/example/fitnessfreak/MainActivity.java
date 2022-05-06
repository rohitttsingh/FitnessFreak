package com.example.fitnessfreak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.viewpager);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.bacharrow);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(),BMIResultsActivity.class));
                //Toast.makeText(getApplicationContext(),"uhu",Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });

        List<Slideritem> slideritems= new ArrayList<>();
        slideritems.add(new Slideritem(R.drawable.img1));
        slideritems.add(new Slideritem(R.drawable.img2));
        slideritems.add(new Slideritem(R.drawable.img3));
        slideritems.add(new Slideritem(R.drawable.img4));
        slideritems.add(new Slideritem(R.drawable.img5));
        slideritems.add(new Slideritem(R.drawable.img6));
        slideritems.add(new Slideritem(R.drawable.img7));
        slideritems.add(new Slideritem(R.drawable.remainder));
        slideritems.add(new Slideritem(R.drawable.premium));

        viewPager2.setAdapter(new SliderAdapter(slideritems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(3));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

    }

    public void gotoBMIcalci(View view) {
        startActivity(new Intent(getApplicationContext(),BMIActivity.class));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}