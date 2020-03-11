package com.example.restraunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button starter,main,dess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starter=findViewById(R.id.starter);
        main=findViewById(R.id.main);
        dess=findViewById(R.id.des);
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,Starter.class));
                overridePendingTransition(R.anim.right,R.anim.left);
            }
        });
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainCourse.class));
                overridePendingTransition(R.anim.right,R.anim.left);
            }
        });
        dess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Dessert1.class));
                overridePendingTransition(R.anim.right,R.anim.left);
            }
        });
    }

}
