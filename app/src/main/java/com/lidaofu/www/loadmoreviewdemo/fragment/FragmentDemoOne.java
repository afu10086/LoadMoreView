package com.lidaofu.www.loadmoreviewdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidaofu.www.loadmoreviewdemo.R;

/**
 * Created by lidaofu on 2016/4/20.
 */
public class FragmentDemoOne extends Fragment {



    public static FragmentDemoOne newInstamce() {
        FragmentDemoOne fragmentDemo = new FragmentDemoOne();
        return fragmentDemo;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

}
