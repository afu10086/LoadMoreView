package com.lidaofu.www.loadmoreviewdemo.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by lidaofu on 2016/4/6.
 */
public abstract class CacheFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = CacheFragmentPagerAdapter.class.getSimpleName();
    private FragmentManager mFm;
    private SparseArray<Fragment> mPages;


    public CacheFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mPages = new SparseArray<Fragment>();
        mFm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        f = mPages.get(position);
        if (f == null) {
            f = createItem(position);
            mPages.put(position, f);
        }
        return f;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


    public Fragment getItemAt(int position) {
        return mPages.get(position);
    }


    public abstract Fragment createItem(int position);

}
