package com.example.yang.myapplication.data.ui.fragment;

import android.os.Bundle;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpFragment;

/**
 * Created by yang on 2017/8/7.
 */

public class DataFragment extends MvpFragment<MvpBasePresenter> {

    public static DataFragment newInstance() {
        DataFragment dataFragment = new DataFragment();
        return dataFragment;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_data;
    }



    @Override
    protected void initView(Bundle savedInstanceState,Bundle args) {

    }

    @Override
    protected void loadData(Bundle savedInstanceState) {

    }


    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }
}
