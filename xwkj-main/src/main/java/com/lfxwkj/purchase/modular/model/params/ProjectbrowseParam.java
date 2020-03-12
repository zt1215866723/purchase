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
public class ProjectbrowseParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long clientID;

            /**
             * 楼盘的项目的主键
             */
        private Integer projectID;

            /**
             * 数据的添加时间
             */
        private Long creatTime;

            /**
             * 是否已经推荐
             */
        private String isRecom;

            /**
             * 数据的状态
             */
        private Integer orderNum;

            /**
             * 销售的主键
             */
        private Long salesID;

    @Override
    public String checkParam() {
        return null;
    }

}
