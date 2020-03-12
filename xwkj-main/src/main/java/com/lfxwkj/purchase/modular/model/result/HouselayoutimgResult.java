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
public class HouselayoutimgResult implements Serializable {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long houseLayID;

        private String imgUrl;

            /**
             * 主图显示在户型列表,默认为0 勾选为1 则主图
            
             */
        private Integer isMain;

            /**
             * 某户型中轮播显示户型图的顺序，默认为0，数值越大排前
            
             */
        private Integer orderNum;

}
