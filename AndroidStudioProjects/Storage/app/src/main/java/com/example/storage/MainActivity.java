package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView textView;
  EditText editText;
  Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String sk=editText.getText().toString();
                SharedPreferences s=getSharedPreferences("mydata",MODE_PRIVATE);
                SharedPreferences.Editor ed=s.edit();
                ed.putString("name",sk);

                ed.apply();
                textView.setText(sk);
            }
        });


        SharedPreferences s=getSharedPreferences("mydata",MODE_PRIVATE);
        String sk=s.getString("name","no value as of now");
                textView.setText(sk);






    }
}