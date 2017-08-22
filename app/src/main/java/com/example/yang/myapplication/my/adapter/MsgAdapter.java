package com.example.yang.myapplication.my.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yang.myapplication.R;
import com.example.yang.myapplication.my.bean.MsgBean;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Author : WaterFlower.
 * Created on 2017/8/22.
 * Desc :
 */

public class MsgAdapter extends BaseQuickAdapter<MsgBean, BaseViewHolder> {
    public MsgAdapter() {
        super(R.layout.item_msg);
    }

    @Override
    protected void convert(BaseViewHolder helper, MsgBean item) {

    }


    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);
        return new BaseViewHolder(view);
    }
}
