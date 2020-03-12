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
public class ProjectambitusParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long projectID;

            /**
             * 如 交通、学校、医疗、购物等
             */
        private Long ambitusType;

        private String name;

        private BigDecimal distance;

    @Override
    public String checkParam() {
        return null;
    }

}
