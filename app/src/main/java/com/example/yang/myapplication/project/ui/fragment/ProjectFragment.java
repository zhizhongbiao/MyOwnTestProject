package com.example.yang.myapplication.project.ui.fragment;

import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.view.BaseFragment;

/**
 * Created by yang on 2017/8/7.
 */

public class ProjectFragment extends BaseFragment {

    public static ProjectFragment newInstance() {
        ProjectFragment projectFragment = new ProjectFragment();
        return projectFragment;
    }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initView(Bundle savedInstanceState,Bundle args) {

    }
}
