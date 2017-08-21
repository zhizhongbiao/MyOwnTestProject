package com.example.yang.myapplication.project.base;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.network.ApiConfig;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpFragment;
import com.example.yang.myapplication.project.adapter.ProjectItemAdapter;
import com.example.yang.myapplication.project.bean.ProjectItemBean;

import java.io.Serializable;

import butterknife.BindView;

/**
 * Created by yang on 2017/8/7.
 */

public class CommonRvFragment extends MvpFragment<MvpBasePresenter> {

    //报备
    public static final int TYPE_REPORT = 0;
    //带客
    public static final int TYPE_CARRY = 1;
    //下定
    public static final int TYPE_DEPOSIT = 2;
    //签约
    public static final int TYPE_SIGN = 3;
    //结佣
    public static final int TYPE_COMMISSION = 4;

    private static final String TYPE_KEY = "typeKey";

    @BindView(R.id.rv)
    RecyclerView rv;
    private int type;

    private int page = 1;


    public static CommonRvFragment newInstance(int type) {
        CommonRvFragment commonRvFragment = new CommonRvFragment();
        Bundle args = new Bundle();
        args.putInt(TYPE_KEY, type);
        commonRvFragment.setArguments(args);
        return commonRvFragment;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_common_recyclerview;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {
        type = args.getInt(TYPE_KEY, -1);
        initRv();
    }

    private void initRv() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new ProjectItemAdapter(getActivity(), type));
    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
        getList(type);
    }


    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }


    private void getList(int type) {
        switch (type) {
            case TYPE_REPORT:
                getList("", 1, 1, "", 1);
                break;
            case TYPE_CARRY:
                break;
            case TYPE_DEPOSIT:
                break;
            case TYPE_SIGN:
                break;
            case TYPE_COMMISSION:
                break;

        }
    }

    private void getList(String label, int projectId, int type, String userInfo, int page) {
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("label", label);
        params.put("project_id", projectId);
        params.put("type", type);
        params.put("user_info", userInfo);
        params.put("page", page);
        presenter.postData(ApiConfig.API_PROJECT_DETAIL_LIST, params, ProjectItemBean.class);
    }


}
