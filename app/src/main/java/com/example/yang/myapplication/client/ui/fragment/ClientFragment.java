package com.example.yang.myapplication.client.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.adpter.TabBarAdapter;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yang on 2017/8/7.
 */

public class ClientFragment extends BaseFragment {


    private static final String[] titles = {"二手房", "租房"};

    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.vpContainer)
    ViewPager vpContainer;
    @BindView(R.id.tabyout)
    TabLayout tabyout;
    private List<Fragment> fragments = new ArrayList<>();
    private TabBarAdapter adapter;


    public static ClientFragment newInstance() {
        ClientFragment clientFragment = new ClientFragment();
        return clientFragment;
    }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_client;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {
        initTab();
    }


    private void initTab() {
        fragments.clear();
        fragments.add(SecondHandFragment.newInstance());
        fragments.add(RentHouseFragment.newInstance());
        adapter = new TabBarAdapter(getChildFragmentManager(), fragments, titles);
        vpContainer.setAdapter(adapter);
        tabyout.setupWithViewPager(vpContainer);

    }

}
