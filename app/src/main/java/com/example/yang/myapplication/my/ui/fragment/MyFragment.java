package com.example.yang.myapplication.my.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;
import com.example.yang.myapplication.my.ui.activity.MsgInfoActivity;
import com.example.yang.myapplication.my.ui.activity.SettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yang on 2017/8/7.
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.vNotify)
    View vNotify;



    public static MyFragment newInstance() {
        MyFragment myFragment = new MyFragment();
        return myFragment;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {

    }


    @OnClick({R.id.ivNotification, R.id.llMyProject, R.id.llMyClient, R.id.llSetting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivNotification:
                startActivity(MsgInfoActivity.getIntent(getActivity(),"暂无参数"));
                break;
            case R.id.llMyProject:
                break;
            case R.id.llMyClient:
                break;
            case R.id.llSetting:
                startActivity(SettingActivity.getIntent(getActivity(),"暂无参数"));
                break;
        }
    }


}
