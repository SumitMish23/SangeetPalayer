package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class intent2 extends AppCompatActivity {
       TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        textView=findViewById(R.id.textView2);
        Intent i=getIntent();
        String s=i.getStringExtra("name");

        textView.setText(s);






    }
}