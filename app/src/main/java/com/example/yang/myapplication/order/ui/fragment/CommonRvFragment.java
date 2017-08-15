package com.example.yang.myapplication.order.ui.fragment;

import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;

/**
 * Created by yang on 2017/8/7.
 */

public class CommonRvFragment extends BaseFragment {


    public static CommonRvFragment newInstance() {
        CommonRvFragment commonRvFragment = new CommonRvFragment();
        return commonRvFragment;
    }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_common_recyclerview;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {

    }



}
