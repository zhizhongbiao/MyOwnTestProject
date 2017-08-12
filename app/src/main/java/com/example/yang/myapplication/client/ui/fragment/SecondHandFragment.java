package com.example.yang.myapplication.client.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.adpter.TabBarAdapter;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yang on 2017/8/7.
 */

public class SecondHandFragment extends BaseFragment {

    private static final String[] titles = {"审核", "报备", "下定", "带看", "签约"};

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.vpContainer)
    ViewPager vpContainer;
    private List<Fragment> fragments = new ArrayList<>();
    private TabBarAdapter adapter;


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
        initTab();
    }


    private void initTab() {
        fragments.clear();
        for (int i = 0; i < 5; i++) {
            fragments.add(CommonRvFragment.newInstance());
        }

        adapter = new TabBarAdapter(getChildFragmentManager(), fragments, titles);
        vpContainer.setAdapter(adapter);
        tablayout.setupWithViewPager(vpContainer);

    }

}
