package com.hungrok.myfragment;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ColorListFragment.OnColorSelectedListener {

    private ColorFragment mColorFragment ;
    private ColorListFragment mColorListFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mColorListFragment = (ColorListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color_list) ;
        ((ColorListFragment) mColorListFragment).setOnColorSelectedListener(this);

        mColorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color) ;
        mColorFragment.setColor(Color.RED);
    }

    @Override
    public void onColorSelected(int color){
        mColorFragment.setColor(color);
    }
}
