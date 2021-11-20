package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dbhandler handler=new Dbhandler(this,"empd",null,1);
        handler.addEmployee(new Employee(1,"harry",44.4));
        handler.close();

    }
}