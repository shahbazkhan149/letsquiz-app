package com.example.letsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class finalactivity extends AppCompatActivity {
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalactivity);
        textview=findViewById(R.id.textView);
        Intent intent = getIntent();
        int score = intent.getIntExtra("scores", 0);


       textview.setText(String.valueOf("Your Score is : "+ score+"/6"));
    }
}