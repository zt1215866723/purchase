package com.lfxwkj.purchase.modular.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 项目所属区域
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Data
public class ProjectareaParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

            /**
             * 1 国内
            2 国外
             */
        private Integer areaType;

        private String areaName;

        private String areaLatter;

            /**
             * 1启用
            0停用
             */
        private Integer status;

    @Override
    public String checkParam() {
        return null;
    }

}
