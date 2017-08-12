package com.example.yang.myapplication.base.mvp.payment;

/**
 * @author 刘琛慧
 *         date 2015/8/25.
 */
public interface PayResultListener {

    /**
     * 支付成功完成
     *
     * @param orderNo
     */
    void onSuccess(String orderNo);

    /**
     * 支付遇到错误失败
     */
    void onFail();

    /**
     * 支付已完成，服务器正在处理当中
     */
    void onProcess();
}
