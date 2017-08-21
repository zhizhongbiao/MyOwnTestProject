package com.example.yang.myapplication.project.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseActivity;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc : 客源
 */

public class ClientSourceActivity extends BaseActivity {

    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, ClientSourceActivity.class);
        return intent;
    }


    @Override
    public int getViewLayout() {
        return R.layout.activity_client_source;
    }



    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent intent) {

    }

}
