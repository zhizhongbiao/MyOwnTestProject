package com.example.yang.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.vpContainer)
    ViewPager vpContainer;
    @BindView(R.id.tabbar)
    JPTabBar tabbar;

    List<Fragment> fragments = new ArrayList<>();
    TabBarAdapter adapter;

    /**
     * 清空栈顶 进入主页
     *
     * @param context
     * @return
     */
    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState, BaseActivity.ToolbarHolder toolbarHolder, Intent intent) {
        initTab();
    }

    @Titles
    private static final String[] mTitles = {"项目", "房源", "客户", "我的"};

    @NorIcons
    private static final int[] mNormalIcons = {R.mipmap.project_false
            , R.mipmap.ic_launcher_round
            , R.mipmap.ic_launcher_round
            , R.mipmap.my_false};

    @SeleIcons
    private static final int[] mSeleIcons = {R.mipmap.project_true
            , R.mipmap.ic_launcher_round
            , R.mipmap.ic_launcher_round
            , R.mipmap.my_true};







    private void initTab() {
        tabbar
                .setTitles(mTitles)
                .setNormalIcons(mNormalIcons)
                .setSelectedIcons(mSeleIcons)
                .generate();

        fragments.add(ProjectFragment.newInstance());
        fragments.add(HouseFragment.newInstance());
        fragments.add(ClientFragment.newInstance());
        fragments.add(MyFragment.newInstance());

        adapter = new TabBarAdapter(getSupportFragmentManager(), fragments);
        vpContainer.setAdapter(adapter);
        tabbar.setContainer(vpContainer);
    }

}
