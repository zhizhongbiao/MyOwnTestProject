package com.example.yang.myapplication.base.mvp.view;

import android.os.Bundle;

import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;

/**
 * Author : WaterFlower.
 * Created on 2017/8/22.
 * Desc :   只是包裹一下,让一些有些子类用不到的的方法不用传递给子类实现
 */

public abstract class WrapperMvpFragment<P extends MvpBasePresenter> extends MvpFragment<P> {


    @Override
    protected void loadData(Bundle savedInstanceState) {

    }
}
