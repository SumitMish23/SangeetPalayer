package com.example.multiscreenquiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    ConstraintLayout a;
    RecyclerView rv;
    List<model> modelList=new ArrayList<>();
    MyAdapter a=new MyAdapter(modelList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(a);


        InsertData();

    }
    private void InsertData()
    {
        model model=new model("AJIAJI","djidj","2022");
        modelList.add(model);
         model=new model("Sumit Smarty","Work","2022");
        modelList.add(model);


        a.notifyDataSetChanged();

    }
}
