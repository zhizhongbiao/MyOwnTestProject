package com.example.yang.myapplication.project.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.model.BaseVo;
import com.example.yang.myapplication.base.mvp.presenter.MvpBasePresenter;
import com.example.yang.myapplication.base.mvp.view.MvpActivity;
import com.example.yang.myapplication.project.adapter.ProjectItemAdapter;

import butterknife.BindView;

import static com.example.yang.myapplication.project.base.CommonRvFragment.TYPE_ALL;

/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */
public class AllProjectDetailActivity extends MvpActivity<MvpBasePresenter> {


    @BindView(R.id.rv)
    RecyclerView rv;
    private ProjectItemAdapter adapter;

    public static Intent getIntent(Context context, String args) {
        Intent intent = new Intent(context, AllProjectDetailActivity.class);
        return intent;
    }


    @Override
    protected int getToolBarLayout() {
        return DEFAULT_TOOLBAR;
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_common_recyclerview;
    }


    @Override
    protected void initView(Bundle savedInstanceState, ToolbarHolder tbHolder, Intent intent) {
        initToolbar(tbHolder);
        initRv();
    }

    private void initRv() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectItemAdapter(this, TYPE_ALL);
        rv.setAdapter(adapter);
    }


    @Override
    protected void loadData(Bundle savedInstanceState, Intent intent) {

    }


    @Override
    public void showContentView(String url, BaseVo dataVo) {

    }


    private void initToolbar(ToolbarHolder tbHolder) {

        tbHolder.tvCenterTitle.setText("全部客源");
        tbHolder.ivRight.setVisibility(View.VISIBLE);
        tbHolder.ivRight.setImageResource(R.drawable.search_54);
        tbHolder.ivRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ClientSearchActivity.getIntent(AllProjectDetailActivity.this, "暂无参数"));
            }
        });

    }

}
