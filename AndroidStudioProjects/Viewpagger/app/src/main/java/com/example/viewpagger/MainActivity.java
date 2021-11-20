package com.example.viewpagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<modelClass> videos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager2=findViewById(R.id.vp);
        videos=new ArrayList<>();

        modelClass obj=new modelClass("http://techslides.com/demos/sample-videos/small.mp4","Yotube","Hi Sumit");
        videos.add(obj);

        modelClass obj1=new modelClass("https://www.youtube.com/watch?v=GExIF9iydR4","pheli phurst mai nikal","Hi Sumit");
        videos.add(obj1);
        viewPager2.setAdapter(new viewAdapter(videos));
    }
}