package com.lfxwkj.purchase.modular.model.result;

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
public class SalespersonResult implements Serializable {

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

}
