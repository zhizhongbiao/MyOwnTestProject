package com.example.yang.myapplication.base.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.ArrayMap;

import java.util.List;

/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */

public abstract class CommonFragmentPagerAdapter<T> extends FragmentPagerAdapter {
    protected List<T> mDataList;
    protected ArrayMap<Integer, Fragment> mFragmentMaps = new ArrayMap<>();

    public CommonFragmentPagerAdapter(FragmentManager fm, List<T> mDataList) {
        super(fm);
        this.mDataList = mDataList;
    }

    @Override
    public Fragment getItem(int position) {
        T data = mDataList.get(position);
        Fragment fragment = mFragmentMaps.get(position);

        if (fragment == null) {
            fragment = initFragment(data);
            mFragmentMaps.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    protected abstract Fragment initFragment(T data);

    public List<T> getDataList() {
        return mDataList;
    }

    public void setDataList(List<T> dataList) {
        this.mDataList = dataList;
    }


}
