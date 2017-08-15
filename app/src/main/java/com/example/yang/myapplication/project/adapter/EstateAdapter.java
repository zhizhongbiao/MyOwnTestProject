package com.example.yang.myapplication.project.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yang.myapplication.R;
import com.example.yang.myapplication.base.mvp.manager.ImageManager;
import com.example.yang.myapplication.order.bean.ProjectListBean;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Author : WaterFlower.
 * Created on 2017/8/15.
 * Desc :
 */

public class EstateAdapter extends BaseQuickAdapter<ProjectListBean.DataBean, BaseViewHolder> {
    private Context context;

    public EstateAdapter(Context context) {
        super(R.layout.item_estate);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectListBean.DataBean item) {
        helper.setText(R.id.etEstateName, item.project_name)
                .setText(R.id.tvEstateLocate, item.region_name)
                .setText(R.id.tvEstatePrice, item.project_price);
        ImageManager.load(
                context
                , item.thumb_img
                , R.mipmap.ic_launcher_round
                , ((ImageView) helper.getView(R.id.ivEstate)));
    }


    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);
        return new BaseViewHolder(view);
    }
}
