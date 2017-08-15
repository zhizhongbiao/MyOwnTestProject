package com.example.yang.myapplication.base.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.adpter.TabBarAdapter;
import com.example.yang.myapplication.base.mvp.view.BaseActivity;
import com.example.yang.myapplication.order.ui.fragment.ClientFragment;
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

public class MainActivity extends BaseActivity {


    @BindView(R.id.vpContainer)
    ViewPager vpContainer;
    @BindView(R.id.tabbar)
    JPTabBar tabbar;

    List<Fragment> fragments = new ArrayList<>();
    TabBarAdapter adapter;

    @Titles
    private static final String[] mTitles = {"项目", "抢单", "数据", "我的"};

    @NorIcons
    private static final int[] mNormalIcons = {R.drawable.project_46
            ,R.drawable.get_order_46
            ,R.drawable.data_46
            ,R.drawable.me_46};

    @SeleIcons
    private static final int[] mSeleIcons = {R.drawable.project_check_46
            ,R.drawable.get_order_check_46
            ,R.drawable.data_check_46
            ,R.drawable.me_check_46};


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
    protected void initView(Bundle savedInstanceState, BaseActivity.ToolbarHolder tbHolder, Intent intent) {
        initTab();
    }



    private void initTab() {
//        tabbar  .setTabTextSize(DisplayUtil.px2sp(this,24f));
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
