package com.lfxwkj.purchase.modular.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 企业的简介
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Data
public class CompanyinfoParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Integer companyName;

        private String companyDesc;

        private Date creatTime;

        private Integer status;

    @Override
    public String checkParam() {
        return null;
    }

}
