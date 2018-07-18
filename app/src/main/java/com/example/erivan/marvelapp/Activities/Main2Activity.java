package com.example.erivan.marvelapp.Activities;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.erivan.marvelapp.Data.SectionsPageAdapter;
import com.example.erivan.marvelapp.Fragments.Tab1Fragment;
import com.example.erivan.marvelapp.Fragments.Tab2Fragment;
import com.example.erivan.marvelapp.Fragments.Tab3Fragment;
import com.example.erivan.marvelapp.R;
import com.example.erivan.marvelapp.Util.MyTask;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SectionsPageAdapter mSectionPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mSectionPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        MyTask myTask = new MyTask();
        myTask.execute("reer", String.valueOf(1), "fdsf");

        mViewPager = (ViewPager) findViewById(R.id.container);
        setUpViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void setUpViewPager(ViewPager viewPager){

        SectionsPageAdapter sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        sectionsPageAdapter.addFragment(new Tab1Fragment(), "CHARACTERS");
        sectionsPageAdapter.addFragment(new Tab2Fragment(), "COMICS");
        sectionsPageAdapter.addFragment(new Tab3Fragment(), "SERIES");
        viewPager.setAdapter(sectionsPageAdapter);

    }

}
