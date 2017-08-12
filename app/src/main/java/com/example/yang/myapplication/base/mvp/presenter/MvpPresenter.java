package com.example.yang.myapplication.base.mvp.presenter;


import com.example.yang.myapplication.base.mvp.view.MvpView;

import java.lang.ref.WeakReference;

public abstract class MvpPresenter<V extends MvpView> implements Presenter<V> {
    private WeakReference<V> viewReference; //MvpView的子类的弱引用
    protected String viewClassName;


    @Override
    public void attachView(V view) {
        viewClassName = view.getClass().getSimpleName();
        viewReference = new WeakReference<>(view);
    }

    /**
     * 检查Activity或者Fragment是否已经绑定到了Presenter层
     *
     * @return 是否已经绑定
     */
    public boolean isViewAttached() {
        return viewReference != null && viewReference.get() != null;
    }


    /**
     * @return 获取实现了MvpView接口的Activity或者Fragment的引用用来实现回调
     */
    public V getView() {
        return viewReference == null ? null : viewReference.get();
    }


    @Override
    public void detachView() {
        if (viewReference != null) {
            viewReference.clear();
            viewReference = null;
        }
    }

}
