package com.lidaofu.www.loadmoreviewdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.lidaofu.www.loadmoreviewdemo.R;
import com.lidaofu.www.view.ListMoreView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lidaofu on 2016/4/20.
 */
public class FragmentDemoTwo extends Fragment {


    @Bind(R.id.listview)
    ListMoreView listview;

    public static FragmentDemoTwo newInstamce() {
        FragmentDemoTwo fragmentDemo = new FragmentDemoTwo();
        return fragmentDemo;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        listview.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, getDummyData(20)));
    }


    public ArrayList<String> getDummyData(int num) {
        ArrayList<String> items = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            items.add("Item " + i);
        }
        return items;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
