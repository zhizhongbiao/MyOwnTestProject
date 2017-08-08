package com.example.yang.myapplication.client.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.adpter.TabBarAdapter;
import com.example.yang.myapplication.base.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.yang.myapplication.R.id.vpContainer;

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
