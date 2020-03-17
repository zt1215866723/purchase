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
 * @since 2020-03-16
 */
@Data
public class HouselayouttypeParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long projectID;

    private Long status;

    private String name;

    @Override
    public String checkParam() {
        return null;
    }

}
