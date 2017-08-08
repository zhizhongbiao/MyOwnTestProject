package com.example.yang.myapplication.project.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.ui.BaseFragment;

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
