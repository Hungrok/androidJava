package com.example.test1;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking ViewPager - PagerAdapter
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Button object , callback listener
        Button bt1 = findViewById(R.id.button1);
        Button bt2 = findViewById(R.id.button2);
        Button bt3 = findViewById(R.id.button3);
        Button bt4 = findViewById(R.id.button4);
        Button bt5 = findViewById(R.id.button5);
        Button bt6 = findViewById(R.id.button6);

        // 익명함수 객체생성방법
        View.OnClickListener ls1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        };
        bt1.setOnClickListener(ls1);  // 핸들러에게 콜백객체 set

        View.OnClickListener ls2 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        };
        bt1.setOnClickListener(ls2);

        View.OnClickListener ls3 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        };
        bt1.setOnClickListener(ls3);

        View.OnClickListener ls4 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        };
        bt1.setOnClickListener(ls1);

        View.OnClickListener ls5 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(4);
            }
        };
        bt1.setOnClickListener(ls1);

        View.OnClickListener ls6 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(5);
            }
        };
        bt1.setOnClickListener(ls1);




    }
}
