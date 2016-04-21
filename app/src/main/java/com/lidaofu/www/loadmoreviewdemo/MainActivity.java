package com.lidaofu.www.loadmoreviewdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lidaofu.www.view.LoadMoreView;
import com.lidaofu.www.loadmoreviewdemo.fragment.CacheFragmentPagerAdapter;
import com.lidaofu.www.loadmoreviewdemo.fragment.FragmentDemoOne;
import com.lidaofu.www.loadmoreviewdemo.fragment.FragmentDemoThree;
import com.lidaofu.www.loadmoreviewdemo.fragment.FragmentDemoTwo;

public class MainActivity extends AppCompatActivity {

    private LoadMoreView verticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalViewPager = (LoadMoreView) findViewById(R.id.verticalViewPager);
        VerticalPagerAdapter adapter = new VerticalPagerAdapter(getSupportFragmentManager());
        verticalViewPager.setAdapter(adapter);
        verticalViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }


    public class VerticalPagerAdapter extends CacheFragmentPagerAdapter {

        public VerticalPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment createItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = FragmentDemoOne.newInstamce();
                    break;
                case 1:
                    fragment = FragmentDemoTwo.newInstamce();
                    break;
                case 2:
                    fragment= FragmentDemoThree.newInstamce();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
