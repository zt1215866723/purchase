package com.lfxwkj.purchase.modular.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 存储新闻、公告等信息 

 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Data
public class InfolistParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

            /**
             * 1、新闻
            2、公告
            3、项目新闻
             */
        private Integer infoType;

        private Long projectID;

        private String title;

        private String listTitle;

        private String listPicUrl;

        private String tagLabel;

        private String abstrac;

            /**
             * 消息置顶级别，默认为0，值越大，越靠前。后台、前台该类信息显示，根据固顶级别 、发布时间  降序进行排序显示
             */
        private Integer topLevel;

        private Date topTime;

        private String content;

        private Date createTime;

        private Long createUserId;

            /**
             * 0 删除 1发布 2暂存
             */
        private Integer status;

        private Integer readNum;

        private Integer goodNum;

            /**
             * 默认值0  不轮播，1则轮播显示。（注：轮播默认显示状态为1的前几个）
             */
        private Integer isPlay;

        private String linkUrl;

        private Integer isShow;
    @Override
    public String checkParam() {
        return null;
    }

}
