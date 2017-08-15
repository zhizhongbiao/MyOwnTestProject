package com.example.yang.myapplication.order.bean;

import com.example.yang.myapplication.base.mvp.model.BaseVo;

import java.util.List;

/**
 * Author : WaterFlower.
 * Created on 2017/8/15.
 * Desc :
 */

public class ProjectListBean extends BaseVo {
    /**
     * status : 1
     * data : [{"project_id":"4897","project_name":"漾城","region_id":"44190206","project_price":"19000","upload_id":"81405","region_name":"南城车站","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/07/5975be262d83f.jpg"},{"project_id":"4896","project_name":"顺祥城","region_id":"45032301","project_price":"5500","upload_id":"81404","region_name":"八里街","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/06/5942530dc44f0.jpg"},{"project_id":"4895","project_name":"绿地·领寓","region_id":"44191403","project_price":"13000","upload_id":"81403","region_name":"常平","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/05/5922869b1d4e3.jpg"},{"project_id":"4894","project_name":"长安万科中心","region_id":"44193201","project_price":"23000","upload_id":"81402","region_name":"长安","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/05/5919417063a6c.jpg"},{"project_id":"4893","project_name":"富盈·松湖国际","region_id":"44191403","project_price":"12000","upload_id":"81401","region_name":"常平","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/05/591917cccab20.jpg"},{"project_id":"4892","project_name":"达鑫江滨新城","region_id":"44190501","project_price":"16000","upload_id":"81400","region_name":"石碣","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/03/58bf61fe31f25.jpg"},{"project_id":"4891","project_name":"大道松山湖","region_id":"44193301","project_price":"16000","upload_id":"81399","region_name":"松山湖","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/02/58b4e946475f3.jpg"},{"project_id":"4890","project_name":"金地湖山大境","region_id":"44192301","project_price":"24000","upload_id":"81398","region_name":"黄江","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/02/58ad2c643f4dd.jpg"},{"project_id":"4889","project_name":"光明国际","region_id":"44192301","project_price":"18000","upload_id":"81397","region_name":"黄江","thumb_img":"http://dongguan.huifang.cn/u/uploads/2017/02/58ad2aec51246.jpg"},{"project_id":"4888","project_name":"塑金国际","region_id":"44192001","project_price":"11000","upload_id":"81396","region_name":"樟木头","thumb_img":"http://dongguan.huifang.cn/u/uploads/2016/08/57c39cf169351.jpg"}]
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
         * project_id : 4897
         * project_name : 漾城
         * region_id : 44190206
         * project_price : 19000
         * upload_id : 81405
         * region_name : 南城车站
         * thumb_img : http://dongguan.huifang.cn/u/uploads/2017/07/5975be262d83f.jpg
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
