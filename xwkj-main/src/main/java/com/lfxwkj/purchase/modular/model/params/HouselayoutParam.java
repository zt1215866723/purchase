package com.lfxwkj.purchase.modular.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;

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
public class HouselayoutParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

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

    @Override
    public String checkParam() {
        return null;
    }

}
