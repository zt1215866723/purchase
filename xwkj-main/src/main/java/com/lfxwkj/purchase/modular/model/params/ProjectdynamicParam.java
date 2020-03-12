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
public class ProjectdynamicParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long projectId;

            /**
             * 预售证、开盘、交房等
            
             */
        private Long dynamicType;

        private String title;

        private Date dynamicDate;

        private String content;

    @Override
    public String checkParam() {
        return null;
    }

}
