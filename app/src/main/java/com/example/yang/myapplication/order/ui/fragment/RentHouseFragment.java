package com.example.yang.myapplication.order.ui.fragment;

import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;

/**
 * Created by yang on 2017/8/7.
 */

public class RentHouseFragment extends BaseFragment {



    public static RentHouseFragment newInstance() {
        RentHouseFragment rentHouseFragment = new RentHouseFragment();
        return rentHouseFragment;
    }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_rent_house;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {

    }



}
