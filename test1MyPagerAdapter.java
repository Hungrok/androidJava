package com.example.test1;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyPagerAdapter extends PagerAdapter {


    Context context;
    private final int[] drawableImgs = new int[] {
            R.drawable.ic_battery_20_black_24dp,
            R.drawable.ic_battery_30_black_24dp,
            R.drawable.ic_battery_50_black_24dp,
            R.drawable.ic_battery_60_black_24dp,
            R.drawable.ic_battery_80_black_24dp,
            R.drawable.ic_battery_90_black_24dp
    };

    MyPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return drawableImgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Bitmap drawImg = BitmapFactory.decodeResource(context.getResources(), drawableImgs[position]);

        imageView.setImageBitmap(drawImg);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}