package com.example.test1;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyPagerAdapter extends FragmentPagerAdapter {


    Context context;
    private final int[] drawableImgs = new int[] {
            R.drawable.ic_battery_20_black_24dp,
            R.drawable.ic_battery_30_black_24dp,
            R.drawable.ic_battery_50_black_24dp,
            R.drawable.ic_battery_60_black_24dp,
            R.drawable.ic_battery_80_black_24dp,
            R.drawable.ic_battery_90_black_24dp
    };



    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return BlankFragment.newInstance("Fragment-0","Test", 0);
            case 1:
                return BlankFragment.newInstance("Fragment-1","Test", 1);
            case 2:
                return BlankFragment.newInstance("Fragment-2","Test", 2);
            case 3:
                return BlankFragment.newInstance("Fragment-3","Test", 3);
            case 4:
                return BlankFragment.newInstance("Fragment-4","Test", 4);
            case 5:
                return BlankFragment.newInstance("Fragment-5","Test", 5);

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "SUB01";
            case 1:
                return "SUB02";
            default:
                return null;
        }
    }
}