package com.example.letsquiz;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.firstmultiscreen.extra.NAME";
    EditText name;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);

        start =findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    if(TextUtils.isEmpty(name.getText().toString())){
                        Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this, Questions.class);
                        name = findViewById(R.id.name);
                        String nameText = name.getText().toString();
                        intent.putExtra(EXTRA_NAME, nameText);
                        startActivity(intent);
                    }
            }

        });

    }
}