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
public class ProjectlinkParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long projectID;

        private Long clientID;

            /**
             * 1 预约登记
            2 变价通知
            3、开盘通知
             */
        private Integer linkType;

        private String linkTel;

        private Date submitTime;

            /**
             * 提交后，默认状态为0
            如 预约登记已通知，或变价通知已通知等则状态改为1
             */
        private Integer isNotice;

        private String memo;

    @Override
    public String checkParam() {
        return null;
    }

}
