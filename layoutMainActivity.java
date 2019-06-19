package com.hungrok.mylayout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements PageFragment.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        setSupportActionBar(toolbar);
        ActionBar ab1 = getSupportActionBar() ;
        ab1.setDisplayHomeAsUpEnabled(true);
        ab1.setHomeButtonEnabled(true);

        TabLayout tla1 = (TabLayout) findViewById(R.id.tablayout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragAdapter adpt = new FragAdapter(getSupportFragmentManager(),MainActivity.this);
        viewPager.setAdapter(adpt);
        tla1.setupWithViewPager(viewPager); // populate TabLayout-tabitem automatically , getPageTitle

        TabLayout.OnTabSelectedListener tls1 = new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                System.out.printf("onTabSelected, pos=%d \n",tab.getPosition()) ;
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        };
        tla1.addOnTabSelectedListener(tls1);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

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
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true ;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        if (id == R.id.app_bar_search) {
            // SearchView
        }
        if (id == R.id.app_bar_airplane){
            doAirplane() ;
        }
        if (super.onOptionsItemSelected(item)) return true;
        else return false;


    }

    protected void doAirplane(){
        //Intent it1 = new Intent(this, TabActivity.class) ;
        //startActivity(it1) ;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    private class FragAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 4;
        private String tabTitles[] = new String[] { "Linear", "Relative", "Frame", "Constraint" };
        private Context context;

        public FragAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }


        @Override
        public Fragment getItem(int position) {
            Fragment frag = null ;
            System.out.printf("getItem, pos=%d \n",position) ;
            /*
            switch(position) {
                case 0 :
                    frag = PageFragment1.newInstance("MyFragment1", "Hello");
                    break ;
                case 1 :
                    frag = PageFragment2.newInstance("MyFragment2", "Hello");
                    break ;
                case 2 :
                    frag = PageFragment3.newInstance("MyFragment3", "Hello");
                    break ;
            }
            return frag ;
            */

            return PageFragment.newInstance(position+1) ;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;

        }
        @Override
        public CharSequence getPageTitle(int position) { // for menu item populate
            // Generate title based on item position
            System.out.printf("getPageTitle, pos=%d \n",position) ;
            return tabTitles[position];
        }



    }
}
