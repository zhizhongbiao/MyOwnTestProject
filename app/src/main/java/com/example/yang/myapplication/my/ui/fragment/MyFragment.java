package com.example.yang.myapplication.my.ui.fragment;

import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;

/**
 * Created by yang on 2017/8/7.
 */

public class MyFragment extends BaseFragment {

    public static MyFragment newInstance() {
        MyFragment myFragment = new MyFragment();
        return myFragment;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(Bundle savedInstanceState,Bundle args) {

    }
}
