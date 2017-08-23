package com.example.yang.myapplication.project.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.network.ApiConfig;
import com.example.yang.myapplication.base.mvp.network.ResponseInfo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpFragment;
import com.example.yang.myapplication.base.mvp.widget.refresh.NestedRefreshLayout;
import com.example.yang.myapplication.base.mvp.widget.refresh.RefreshLayout;
import com.example.yang.myapplication.project.adapter.ClientTypeAdapter;
import com.example.yang.myapplication.project.bean.ClientTypeBean;

import java.io.Serializable;

import butterknife.BindView;

/**
 * Author : WaterFlower.
 * Created on 2017/8/15.
 * Desc :  客户类型
 */
public class CommonClientTypeFragment extends MvpFragment<MvpBasePresenter> implements BaseQuickAdapter.RequestLoadMoreListener, NestedRefreshLayout.OnRefreshListener {

    //报备
    public static final int TYPE_REPORT = 0;
    public static final int TYPE_PARAM_REPORT = 2;
    //带客
    public static final int TYPE_CARRY = 1;
    public static final int TYPE_PARAM_CARRY = 3;
    //下定
    public static final int TYPE_DEPOSIT = 2;
    public static final int TYPE_PARAM_DEPOSIT = 5;
    //签约
    public static final int TYPE_SIGN = 3;
    public static final int TYPE_PARAM_SIGN = 6;
    //结佣
    public static final int TYPE_COMMISSION = 4;
    public static final int TYPE_PARAM_COMMISSION = 2;
    //全部
    public static final int TYPE_ALL = 5;
    public static final int TYPE_PARAM_ALL = 2;

    private static final String TYPE_KEY = "typeKey";
    private static final String PROJECT_ID = "projectId";

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;

    private int type;
    private int page = 1;
    private ClientTypeAdapter adapter;
    private int projectId;


    public static Fragment newInstance(int type, int projectId) {
        CommonClientTypeFragment commonClientTypeFragment = new CommonClientTypeFragment();
        Bundle args = new Bundle();
        args.putInt(TYPE_KEY, type);
        args.putInt(PROJECT_ID, projectId);
        commonClientTypeFragment.setArguments(args);
        return commonClientTypeFragment;

    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_common_recyclerview;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {
        type = args.getInt(TYPE_KEY, -1);
        projectId = args.getInt(PROJECT_ID, -1);
        initRv();
        refreshLayout.setOnRefreshListener(this);
    }

    private void initRv() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ClientTypeAdapter(getActivity(), type);
        rv.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnLoadMoreListener(this, rv);
    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
        getList(type,page);
    }


    @Override
    public void showContentView(String url, BaseVo dataVo) {
        if (url.contains(ApiConfig.API_PROJECT_DETAIL_LIST)) {
            closeRefresh(refreshLayout);
            ClientTypeBean clientTypeBean = (ClientTypeBean) dataVo;
            showData(clientTypeBean);

        }
    }

    /**
     * 获取数据列表
     *
     * @param type
     */
    private void getList(int type,int page) {
        int paramType = -1;
        switch (type) {
            case TYPE_REPORT:
                paramType = TYPE_PARAM_REPORT;
                break;
            case TYPE_CARRY:
                paramType = TYPE_PARAM_CARRY;
                break;
            case TYPE_DEPOSIT:
                paramType = TYPE_PARAM_DEPOSIT;
                break;
            case TYPE_SIGN:
                paramType = TYPE_PARAM_SIGN;
                break;
            case TYPE_COMMISSION:
                paramType = TYPE_PARAM_COMMISSION;
                break;

        }

        //TODO 参数类型暂时设置为三,有接口时候记得改过来
//        getList("client", paramType, "", page);
        getList("client", 3, "", page);
    }


    /**
     * 请求列表
     *
     * @param label
     * @param type
     * @param userInfo
     * @param page
     */
    private void getList(String label, int type, String userInfo, int page) {
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("label", label);
        params.put("project_id", projectId);
        params.put("type", type);
        params.put("user_info", userInfo);
        params.put("page", page);
        presenter.postData(ApiConfig.API_PROJECT_DETAIL_LIST, params, ClientTypeBean.class);
    }


    private void showData(ClientTypeBean clientTypeBean) {
        if (page == 1) {
            adapter.setNewData(clientTypeBean.data);
        } else {
            adapter.addData(clientTypeBean.data);
        }
    }

    /**
     * 关闭刷新和加载更多
     *
     * @param refreshLayout
     */
    private void closeRefresh(RefreshLayout refreshLayout) {
        if (refreshLayout!=null&&refreshLayout.isOnRefreshing()) {
            refreshLayout.refreshFinish();
        }
        if (adapter.isLoading()) {
            adapter.loadMoreEnd();
        }
    }


    @Override
    public void onRefresh() {
        page = 1;
        getList(type,page);
    }


    @Override
    public void onLoadMoreRequested() {
        page++;
        getList(type,page);
    }


    @Override
    public void onError(ResponseInfo responseInfo) {
        if (page > 1) {
            page--;
        }
        closeRefresh(refreshLayout);
        super.onError(responseInfo);
    }


}
