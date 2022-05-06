package com.example.fitnessfreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BMIResultsActivity extends AppCompatActivity {
TextView resultnum, resulttv;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresults);
         SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);

        SharedPreferences.Editor myEdit = sharedPreferences.edit();


        resultnum=findViewById(R.id.bmiresult);
        resulttv=findViewById(R.id.resulttv);
        button=findViewById(R.id.button);

        String a = getIntent().getStringExtra("bmi");
        myEdit.putString("bmi", a);

        myEdit.commit();
        myEdit.apply();


        resultnum.setText(a);

        float bmi = Float.parseFloat(a);
        if (bmi<=18.5){
            resulttv.setText("Classification: UnderWeight");
        }
        else if (bmi<=24.9&&bmi>18.5){
            resulttv.setText("Classification: Normal Weight");
        }
        else if (bmi<29.9&&bmi>25.0){
            resulttv.setText("Classification: OverWeight");
        }
        else if (bmi>30.0&&bmi<34.5){
            resulttv.setText("Classification: Obesity class I");
        }
        else if (bmi>35.0&&bmi<39.9){
            resulttv.setText("Classification: Obesity class II");
        }
        else if (bmi>=40.0){
            resulttv.setText("Classification: Obesity class III");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),DashBoardActivity.class);
                intent.putExtra("bmi",a);
                Toast.makeText(getApplicationContext(),""+a,Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}