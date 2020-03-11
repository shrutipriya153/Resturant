package com.example.restraunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.restraunt.ui.main.SectionsPagerAdapter;

public class MainCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
        MainCourseAdapter mainCourseAdapter = new MainCourseAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager1);
        viewPager.setAdapter(mainCourseAdapter);
        TabLayout tabs = findViewById(R.id.tabs1);
        tabs.setupWithViewPager(viewPager);


    }
}