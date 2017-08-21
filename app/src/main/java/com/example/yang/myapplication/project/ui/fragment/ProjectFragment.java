package com.example.yang.myapplication.project.ui.fragment;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.network.ApiConfig;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpFragment;
import com.example.yang.myapplication.order.bean.ProjectListBean;
import com.example.yang.myapplication.project.ui.activity.ClientSearchActivity;
import com.example.yang.myapplication.project.ui.activity.ClientSourceActivity;
import com.example.yang.myapplication.project.adapter.EstateAdapter;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc : 项目
 */
public class ProjectFragment extends MvpFragment<MvpBasePresenter> {


    @BindView(R.id.ivAdd)
    ImageView ivAdd;
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.rvEstate)
    RecyclerView rvEstate;
    private EstateAdapter adapter;
    private int page = 1;


    public static ProjectFragment newInstance() {
        ProjectFragment projectFragment = new ProjectFragment();
        return projectFragment;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_project;
    }


    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {
        initRv();
    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
        getProjectList("distribution", "", page);
    }

    @Override
    public void showContentView(String url, BaseVo dataVo) {
        if (url.contains(ApiConfig.API_PROJECT_LIST)) {
            ProjectListBean projectListBean = (ProjectListBean) dataVo;
            showProjectData(projectListBean);
        }

    }


    @OnClick({R.id.ivAdd, R.id.ivSearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivAdd:
                break;
            case R.id.ivSearch:
                startActivity(ClientSearchActivity.getIntent(getActivity(), "暂时无参数"));
                break;
        }
    }


    /**
     * 初始化Rv
     */
    private void initRv() {
        rvEstate.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new EstateAdapter(getActivity());
        rvEstate.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(ClientSourceActivity.getIntent(getActivity(), "暂时无参数"));
            }
        });
    }


    /**
     * 获取项目数据列表
     *
     * @param label
     * @param projectName
     * @param page
     */
    private void getProjectList(String label, String projectName, int page) {
        ArrayMap<String, Serializable> params = new ArrayMap<>();
        params.put("label", label);
        params.put("project_name", projectName);
        params.put("page", page);
        presenter.postData(ApiConfig.API_PROJECT_LIST, params, ProjectListBean.class);
    }


    /**
     * 展示project数据列表
     *
     * @param projectListBean
     */
    private void showProjectData(ProjectListBean projectListBean) {

        if (page == 1) {
            adapter.setNewData(projectListBean.data);
        } else {
            adapter.addData(projectListBean.data);
        }
    }
}
