package com.example.yang.myapplication.base.mvp.view;


import android.content.Intent;
import android.os.Bundle;

import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :   只是包裹一下,让一些有些子类用不到的的方法不用传递给子类实现
 */

public abstract class WrapperMvpActivity<P extends MvpBasePresenter> extends MvpActivity<P> {

    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }


}
