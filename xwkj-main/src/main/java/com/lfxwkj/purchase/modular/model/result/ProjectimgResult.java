package com.lfxwkj.purchase.modular.model.result;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Data
public class ProjectimgResult implements Serializable {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long projectID;

            /**
             * 1 图片 2 视频 3全景
             */
        private Integer imgType;

            /**
             * 效果图、配套图、实景图等
             */
        private Long imgClass;

        private String imgUrl;

            /**
             * 默认为0   值越大越靠前
             */
        private Integer orderNum;

}
