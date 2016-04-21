package com.lidaofu.www.loadmoreviewdemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidaofu.www.loadmoreviewdemo.R;
import com.lidaofu.www.loadmoreviewdemo.view.SlidingTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lidaofu on 2016/4/20.
 */
public class FragmentDemoThree extends Fragment {


    @Bind(R.id.sliding_tabs)
    SlidingTabLayout slidingTabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    public static FragmentDemoThree newInstamce() {
        FragmentDemoThree fragmentDemo = new FragmentDemoThree();
        return fragmentDemo;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        TabFragmentAdapter adapter = new TabFragmentAdapter(getActivity().getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        slidingTabs.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
        slidingTabs.setSelectedIndicatorColors(Color.parseColor("#0081ee"));
        slidingTabs.setDistributeEvenly(true);
        slidingTabs.setViewPager(viewpager);
    }


    public class TabFragmentAdapter extends CacheFragmentPagerAdapter {

        private String[] titles = {"项目详情", "产品介绍", "评价"};

        public TabFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment createItem(int position) {
            return TabFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
