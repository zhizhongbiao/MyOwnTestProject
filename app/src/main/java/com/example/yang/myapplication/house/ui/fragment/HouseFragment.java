package com.example.yang.myapplication.house.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.ui.BaseFragment;
import com.example.yang.myapplication.project.ui.fragment.ProjectFragment;

/**
 * Created by yang on 2017/8/7.
 */

public class HouseFragment extends BaseFragment {

    public static HouseFragment newInstance() {
        HouseFragment houseFragment = new HouseFragment();
        return houseFragment;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_house;
    }

    @Override
    protected void initView(Bundle savedInstanceState,Bundle args) {

    }
}
