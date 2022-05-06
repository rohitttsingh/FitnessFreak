package com.example.fitnessfreak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    SeekBar seekBar;
    EditText age, weight;
    EditText height;
    AppCompatButton button;
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

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

        seekBar=findViewById(R.id.seekBar);
        age=findViewById(R.id.age);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        button=findViewById(R.id.calc);
        Toast.makeText(getApplicationContext(),"Fill The Given Details",Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            seekBar.setMax(220);
            seekBar.setMin(100);
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                height.setText(i+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    bmical();

            }
        });
    }

    private void bmical() {
        float bmires=0;
        String weights= weight.getText().toString();
        String heights=height.getText().toString();
        float h=Float.parseFloat(heights);
        float w= Float.parseFloat(weights);

        float hh=h*h;
        bmires=w/(hh/(10000));

    //    Toast.makeText(getApplicationContext(),bmires+"",Toast.LENGTH_LONG).show();
        Intent intent =new Intent(getApplicationContext(),BMIResultsActivity.class);
        intent.putExtra("bmi",bmires+"");
        startActivity(intent);


    }



    public void female(View view) {
        Toast.makeText(getApplicationContext(),"Selected Gender As: Female",Toast.LENGTH_SHORT).show();

    }

    public void male(View view) {
        Toast.makeText(getApplicationContext(),"Selected Gender As: Male",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}