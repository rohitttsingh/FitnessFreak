package com.example.fitnessfreak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.ramotion.paperonboarding.PaperOnboardingFragment;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences shared = getSharedPreferences("Settings", MODE_PRIVATE);
        String channel = (shared.getString("bmi", ""));
      //  Toast.makeText(getApplicationContext(),channel,Toast.LENGTH_SHORT).show();


    }


    public void gotomainactivity(View view) {
        SharedPreferences shared = getSharedPreferences("Settings", MODE_PRIVATE);
        String channel = (shared.getString("bmi", ""));
        //Toast.makeText(getApplicationContext(),channel,Toast.LENGTH_SHORT).show();

        if (channel.length()==0){
           // Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }
        else {
            //Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();

            gotodash();
        }

    }

    public void gotodash(){

        Intent intent=new Intent(getApplicationContext(),DashBoardActivity.class);
        startActivity(intent);
    }
}