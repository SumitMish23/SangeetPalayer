package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView3);

        editText1=findViewById(R.id.e1);
      //  editText2=findViewById(R.id.editText2);

        //button.setOnClickListener(new View.OnClickListener() {
          //  @Override
           /* public void onClick(View view) {
                //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
               String s= editText.getText().toString();
               int num=Integer.parseInt(s);
               int answer=23+num;
               textView.setText("your value is"+answer);*/


            }
    public void getAnswer(View view)
    {
        //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        int i=0;
        String s= editText1.getText().toString();
       // String s2= editText2.getText().toString();
        int num=Integer.parseInt(s);
        while(i<11)
        {
            textView.setText("The multiplication of given table is:-" + num+"*"+i+"="+num*i);
        i++;
        }

    }
        
        


}