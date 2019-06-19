package com.hungrok.myfirebase3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements PageFragment1.OnFragmentInteractionListener{

    private ViewPager viewPager ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_auth:
                    //mTextMessage.setText(R.string.title_home);
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_database:
                    //mTextMessage.setText(R.string.title_dashboard);
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_messanger:
                    //mTextMessage.setText(R.string.title_notifications);
                    viewPager.setCurrentItem(2);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragAdapter adpt = new FragAdapter(getSupportFragmentManager(),MainActivity.this);
        viewPager.setAdapter(adpt);


        /* Attach the page change listener inside the activity */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                System.out.printf("onPageSelected, pos=%d \n",position) ;
                /*
                Toast.makeText(TabActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                        */
            }


            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    private class FragAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 1;
        private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };
        private Context context;

        public FragAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag = null ;
            System.out.printf("getItem, pos=%d \n",position) ;
            return PageFragment1.newInstance(position+1) ;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;

        }
        @Override
        public CharSequence getPageTitle(int position) { // for menu item populate
            // Generate title based on item position
            return tabTitles[position];
        }



    }

}
