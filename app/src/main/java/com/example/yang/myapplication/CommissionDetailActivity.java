package com.example.yang.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.yang.myapplication.base.adpter.TabBarAdapter;
import com.example.yang.myapplication.base.ui.BaseActivity;
import com.example.yang.myapplication.client.ui.fragment.ClientFragment;
import com.example.yang.myapplication.house.ui.fragment.HouseFragment;
import com.example.yang.myapplication.my.ui.fragment.MyFragment;
import com.example.yang.myapplication.project.ui.fragment.ProjectFragment;
import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.SeleIcons;
import com.jpeng.jptabbar.anno.Titles;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CommissionDetailActivity extends BaseActivity {


    @Override
    public int getViewLayout() {
        return R.layout.activity_commission_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder toolbarHolder, Intent intent) {

    }


}
