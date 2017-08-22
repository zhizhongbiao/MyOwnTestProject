package com.example.yang.myapplication.project.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yang.myapplication.R;
import com.example.yang.myapplication.project.bean.ClientTypeBean;
import com.zhy.autolayout.utils.AutoUtils;

import static com.example.yang.myapplication.project.base.CommonClientTypeFragment.TYPE_ALL;
import static com.example.yang.myapplication.project.base.CommonClientTypeFragment.TYPE_CARRY;
import static com.example.yang.myapplication.project.base.CommonClientTypeFragment.TYPE_COMMISSION;
import static com.example.yang.myapplication.project.base.CommonClientTypeFragment.TYPE_DEPOSIT;
import static com.example.yang.myapplication.project.base.CommonClientTypeFragment.TYPE_REPORT;
import static com.example.yang.myapplication.project.base.CommonClientTypeFragment.TYPE_SIGN;

/**
 * Author : WaterFlower.
 * Created on 2017/8/15.
 * Desc :
 */

public class ClientTypeAdapter extends BaseQuickAdapter<ClientTypeBean.DataBean, BaseViewHolder> {
    private Context context;
    private int type=-1;

    public ClientTypeAdapter(Context context, int type) {
        super(R.layout.item_client_type);
        this.context = context;
        this.type=type;
    }

    @Override
    protected void convert(BaseViewHolder helper, ClientTypeBean.DataBean item) {
        switch (type) {
            case TYPE_REPORT:
                break;
            case TYPE_CARRY:
                break;
            case TYPE_DEPOSIT:
                break;
            case TYPE_SIGN:
                break;
            case TYPE_COMMISSION:
                break;
            case TYPE_ALL:
                break;

        }



//        helper.setText(R.id.etEstateName, item.project_name)
//                .setText(R.id.tvEstateLocate, item.region_name)
//                .setText(R.id.tvEstatePrice, item.project_price);
//        ImageManager.load(
//                context
//                , item.thumb_img
//                , R.mipmap.ic_launcher_round
//                , ((ImageView) helper.getView(R.id.ivEstate)));
    }


    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);
        return new BaseViewHolder(view);
    }
}
