package com.example.yang.myapplication.base.mvp.presenter;

/**
 * Created by Administrator on 2015/8/10.
 */
public interface Presenter<V> {

    /**
     * 将Activity或者Fragment绑定到Presenter��
     */
    void attachView(V view);


    /**
     * 将Activity或者Fragment从Presenter中分离出来��
     */
    void detachView();

}
