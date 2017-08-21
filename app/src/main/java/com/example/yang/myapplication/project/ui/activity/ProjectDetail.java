package com.example.yang.myapplication.project.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.adpter.TabBarAdapter;
import com.example.yang.myapplication.base.mvp.view.BaseActivity;
import com.example.yang.myapplication.project.base.CommonRvFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc : 客源
 */

public class ProjectDetail extends BaseActivity {


    private static final String[] titles = {"报备", "带客", "下定", "签约", "结佣"};

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.vpContainer)
    ViewPager vpContainer;
    private List<Fragment> fragments = new ArrayList<>();
    private TabBarAdapter adapter;

    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, ProjectDetail.class);
        return intent;
    }


    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_project_detail;
    }



    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent intent) {
        initToolbar(tbHolder);
        initTab();
    }

    private void initToolbar(ToolbarHolder tbHolder) {
        tbHolder.ivBack.setVisibility(View.GONE);
        tbHolder.tvCenterTitle.setText("ProjectName");
        tbHolder.ivRight.setVisibility(View.VISIBLE);
        tbHolder.ivRight.setImageResource(R.drawable.search_36);
        tbHolder.ivRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ClientSearchActivity.getIntent(ProjectDetail.this,"暂无参数"));
            }
        });
        tbHolder.tvLeftTitle.setVisibility(View.VISIBLE);
        tbHolder.tvLeftTitle.setText("全部客源");
        tbHolder.tvLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void initTab() {
        fragments.clear();
        for (int i = 0; i < titles.length; i++) {
            fragments.add(CommonRvFragment.newInstance(i));
        }

        adapter = new TabBarAdapter(getSupportFragmentManager(), fragments, titles);
        vpContainer.setAdapter(adapter);
        tablayout.setupWithViewPager(vpContainer);

    }

}
