package com.lfxwkj.purchase.modular.model.params;

import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Data
public class SalespersonParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String name;

    private String picUrl;

    private String tel;

    private String weChatNo;

    private String QRCodeUrl;

    private Integer goodNum;

    private Integer serviceNum;

    private String saleSign;

    private String salePosition;

    private Integer status;

    @Override
    public String checkParam() {
        return null;
    }

}
