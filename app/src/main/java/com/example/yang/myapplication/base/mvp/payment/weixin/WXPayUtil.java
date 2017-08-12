package com.example.yang.myapplication.base.mvp.payment.weixin;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘琛慧
 * @date 2015/7/25
 */
public class WXPayUtil {

    /**
     * 将所有参数转为XML格式数据
     *
     * @param params
     * @return
     */
    public static String toXml(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (int i = 0; i < params.size(); i++) {
            sb.append("<").append(params.get(i).getName()).append(">");
            sb.append(params.get(i).getValue());
            sb.append("</").append(params.get(i).getName()).append(">");
        }

        sb.append("</xml>");

        return sb.toString();
    }

    public static Map<String, String> decodeXml(String content) {

        try {
            Map<String, String> xml = new HashMap<String, String>();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new StringReader(content));
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                String nodeName = parser.getName();
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:
                        if ("xml".equals(nodeName) == false) {
                            //实例化student对象
                            xml.put(nodeName, parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                event = parser.next();
            }

            return xml;
        } catch (Exception e) {
            Log.e("微信支付", e.toString());
        }
        return null;

    }




    public static boolean isWeChatExist(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcessInfos = activityManager.getRunningAppProcesses();
        boolean isExist = false;
        for (int i = 0; i < appProcessInfos.size(); i++) {
            if (appProcessInfos.get(i).processName.contains("com.tencent.mm")) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
}
