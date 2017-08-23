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
    private int type = -1;

    public ClientTypeAdapter(Context context, int type) {
        super(R.layout.item_client_type);
        this.context = context;
        this.type = type;
    }


    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);
        return new BaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClientTypeBean.DataBean item) {
        switch (type) {
            case TYPE_REPORT:
                showReport(helper, item);
                break;
            case TYPE_CARRY:
                showCarry(helper, item);
                break;
            case TYPE_DEPOSIT:
                showDeposit(helper, item);
                break;
            case TYPE_SIGN:
                showSign(helper, item);
                break;
            case TYPE_COMMISSION:
                showCommission(helper, item);
                break;
            case TYPE_ALL:
                break;

        }

    }

    private void showReport(BaseViewHolder helper, ClientTypeBean.DataBean item) {
        helper.setText(R.id.tvClienName, "clientName")
                .setText(R.id.tvClienPhone, "CLientPhone")
                .setText(R.id.tvIntentProject, "intentProject")
                .setText(R.id.tvReportTime, "tvReportTime")
                .setText(R.id.tvProtectLeftTime, "tvProtectLeftTime")
                .setText(R.id.tvClientDelegate, "tvClientDelegate")

                .setText(R.id.tvStateType, "tvStateType")

                .setText(R.id.tvStateTop, "tvStateTop")
                .setText(R.id.tvStateBottom, "tvStateBottom")
                .setVisible(R.id.tvStateCenter, false)

                .setVisible(R.id.llDoneMoney, false)
                .setVisible(R.id.llDoneTime, false)
                .setVisible(R.id.llVisitTime, false)
                .setVisible(R.id.llDeposit, false)
                .setVisible(R.id.llCommission, false)
                .setVisible(R.id.llSignTime, false);

    }


    private void showCarry(BaseViewHolder helper, ClientTypeBean.DataBean item) {
        helper.setText(R.id.tvClienName, "clientName")
                .setText(R.id.tvClienPhone, "CLientPhone")
                .setText(R.id.tvIntentProject, "intentProject")
                .setText(R.id.tvReportTime, "tvReportTime")
                .setText(R.id.tvProtectLeftTime, "tvProtectLeftTime")
                .setText(R.id.tvClientDelegate, "tvClientDelegate")

                .setText(R.id.tvStateType, "tvStateType")

                .setText(R.id.tvStateTop, "tvStateTop")
                .setText(R.id.tvStateBottom, "tvStateBottom")
                .setVisible(R.id.tvStateCenter, false)

                .setVisible(R.id.llDoneMoney, false)
                .setVisible(R.id.llDoneTime, false)
                .setVisible(R.id.llVisitTime, false)
                .setVisible(R.id.llDeposit, false)
                .setVisible(R.id.llCommission, false)
                .setVisible(R.id.llSignTime, false);

    }

    private void showDeposit(BaseViewHolder helper, ClientTypeBean.DataBean item) {
        helper.setText(R.id.tvClienName, "clientName")
                .setText(R.id.tvClienPhone, "CLientPhone")
                .setText(R.id.tvIntentProject, "intentProject")
                .setText(R.id.tvVisitTime, "tvVisitTime")
                .setText(R.id.tvProtectLeftTime, "tvProtectLeftTime")
                .setText(R.id.tvClientDelegate, "tvClientDelegate")

                .setText(R.id.tvStateType, "tvStateType")

                .setText(R.id.tvStateTop, "tvStateTop")
                .setText(R.id.tvStateBottom, "tvStateBottom")
                .setVisible(R.id.tvStateCenter, false)

                .setVisible(R.id.llDoneMoney, false)
                .setVisible(R.id.llDoneTime, false)
                .setVisible(R.id.llReportTime, false)
                .setVisible(R.id.llDeposit, false)
                .setVisible(R.id.llCommission, false)
                .setVisible(R.id.llSignTime, false);

    }

    private void showSign(BaseViewHolder helper, ClientTypeBean.DataBean item) {
        helper.setText(R.id.tvClienName, "clientName")
                .setText(R.id.tvClienPhone, "CLientPhone")
                .setText(R.id.tvIntentProject, "intentProject")
                .setText(R.id.tvDepositTime, "tvDepositTime")
                .setText(R.id.tvDeposit, "tvDeposit")
                .setText(R.id.tvProtectLeftTime, "tvProtectLeftTime")
                .setText(R.id.tvClientDelegate, "tvClientDelegate")

                .setText(R.id.tvStateType, "tvStateType")

                .setText(R.id.tvStateTop, "tvStateTop")
                .setText(R.id.tvStateBottom, "tvStateBottom")
                .setVisible(R.id.tvStateCenter, false)

                .setVisible(R.id.llDoneMoney, false)
                .setVisible(R.id.llDoneTime, false)
                .setVisible(R.id.llVisitTime, false)
                .setVisible(R.id.llReportTime, false)
                .setVisible(R.id.llCommission, false)
                .setVisible(R.id.llSignTime, false);

    }

    private void showCommission(BaseViewHolder helper, ClientTypeBean.DataBean item) {
        helper.setText(R.id.tvClienName, "clientName")
                .setText(R.id.tvClienPhone, "CLientPhone")
                .setText(R.id.tvIntentProject, "intentProject")
                .setText(R.id.tvDeposit, "tvDeposit")
                .setText(R.id.tvDoneTime, "tvDoneTime")
                .setText(R.id.tvDoneMoney, "tvDoneMoney")
                .setText(R.id.tvProtectLeftTime, "tvProtectLeftTime")
                .setText(R.id.tvClientDelegate, "tvClientDelegate")

                .setText(R.id.tvStateType, "tvStateType")

                .setText(R.id.tvStateCenter, "tvStateCenter")
                .setVisible(R.id.tvStateTop, false)
                .setVisible(R.id.tvStateBottom, false)

                .setVisible(R.id.llDepositTime, false)
                .setVisible(R.id.llVisitTime, false)
                .setVisible(R.id.llReportTime, false)
                .setVisible(R.id.llCommission, false)
                .setVisible(R.id.llSignTime, false);

    }


}
