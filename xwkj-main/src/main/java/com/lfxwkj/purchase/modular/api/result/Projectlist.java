package com.lfxwkj.purchase.modular.api.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
@Data
public class Projectlist implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String recordName;

    private String wantBuy;

    private String address;


    private int wantBuyNums;

    /**
     * 在售 待售等
     */
    private String saleStatus;

    /**
     *
     *项目的标签
     */
    private List<String> title;

}
