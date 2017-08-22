package com.example.yang.myapplication.my.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseActivity;

/**
 * Created by yang on 2017/8/8.
 */

public class AboutActivity extends BaseActivity {

    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, AboutActivity.class);
        return intent;
    }

    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_about;
    }



    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent args) {
        tbHolder.tvCenterTitle.setText("关于速卖通");
    }


}
