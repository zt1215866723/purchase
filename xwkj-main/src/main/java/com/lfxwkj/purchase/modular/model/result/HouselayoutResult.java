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
public class HouselayoutResult implements Serializable {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long houseType;

        private Long projectID;

            /**
             * 如：
            A2户型
             */
        private String layoutName;

            /**
             * 如：二室二厅一卫
             */
        private String room;

            /**
             * 如：约75万元/套
             */
        private String storeyPrice;

            /**
             * 如：105
             */
        private String buildArea;

            /**
             * 该户型销售状态：在售、待售等
             */
        private Long saleStatus;

        private String content;

            /**
             * 默认值0，数值越大排前
             */
        private Integer orderNum;

            /**
            * 1是主力户型，2不是主力户型
            */
        private Integer isMain;
}
