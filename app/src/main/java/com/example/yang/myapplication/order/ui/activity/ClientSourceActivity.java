package com.example.yang.myapplication.order.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseActivity;

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
