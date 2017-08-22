package com.example.yang.myapplication.project.bean;

import com.example.yang.myapplication.base.mvp.model.BaseVo;

import java.util.List;

/**
 * Author : WaterFlower.
 * Created on 2017/8/21.
 * Desc :
 */

public class ClientTypeBean extends BaseVo {
    /**
     * status : 1
     * data : [{"project_id":"4901","project_name":"万江江滨花园","region_id":"44190402","project_price":"10000","upload_id":"105427","region_name":"万江","thumb_img":"http://dongguan.huifang.cn/u/441900/20170819/14/3043/44290/20170819143043ToaKmbibY495613.png"},{"project_id":"4900","project_name":"万江曦龙广场","region_id":"44190406","project_price":"15000","upload_id":"105426","region_name":"万江中心","thumb_img":"http://dongguan.huifang.cn/u/441900/20170819/14/2913/44290/20170819142913L2RuiMNU9V50245.png"},{"project_id":"4899","project_name":"莞城金域名苑","region_id":"44190101","project_price":"12000","upload_id":"105425","region_name":"莞城","thumb_img":"http://dongguan.huifang.cn/u/441900/20170819/14/2810/44290/20170819142810IrcB6i9jiG82992.png"},{"project_id":"4898","project_name":"莞城万佳花园","region_id":"441901","project_price":"10000","upload_id":"105424","region_name":"莞城","thumb_img":"http://dongguan.huifang.cn/u/441900/20170819/14/0358/44290/20170819140358bBM0YzhyxQ44938.png"},{"project_id":"4897","project_name":"漾城","region_id":"44190206","project_price":"19000","upload_id":"81405","region_name":"南城车站","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/07/5975be262d83f.jpg"},{"project_id":"4896","project_name":"顺祥城","region_id":"45032301","project_price":"5500","upload_id":"81404","region_name":"八里街","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/06/5942530dc44f0.jpg"},{"project_id":"4895","project_name":"绿地·领寓","region_id":"44191403","project_price":"13000","upload_id":"81403","region_name":"常平","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/05/5922869b1d4e3.jpg"},{"project_id":"4894","project_name":"长安万科中心","region_id":"44193201","project_price":"23000","upload_id":"81402","region_name":"长安","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/05/5919417063a6c.jpg"},{"project_id":"4893","project_name":"富盈·松湖国际","region_id":"44191403","project_price":"12000","upload_id":"81401","region_name":"常平","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/05/591917cccab20.jpg"},{"project_id":"4892","project_name":"达鑫江滨新城","region_id":"44190501","project_price":"16000","upload_id":"81400","region_name":"石碣","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/03/58bf61fe31f25.jpg"}]
     * msg : 项目列表
     * page : 1
     * login_status : 1
     * count : 0
     */

    public int status;
    public String msg;
    public int page;
    public int login_status;
    public int count;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * project_id : 4901
         * project_name : 万江江滨花园
         * region_id : 44190402
         * project_price : 10000
         * upload_id : 105427
         * region_name : 万江
         * thumb_img : http://dongguan.huifang.cn/u/441900/20170819/14/3043/44290/20170819143043ToaKmbibY495613.png
         */

        public String project_id;
        public String project_name;
        public String region_id;
        public String project_price;
        public String upload_id;
        public String region_name;
        public String thumb_img;
    }
}
