package com.example.yang.myapplication.order.ui.fragment;

import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;

/**
 * Created by yang on 2017/8/7.
 */

public class SecondHandFragment extends BaseFragment {



    public static SecondHandFragment newInstance() {
        SecondHandFragment secondHandFragment = new SecondHandFragment();
        return secondHandFragment;
    }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_second_hand;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {

    }




}
