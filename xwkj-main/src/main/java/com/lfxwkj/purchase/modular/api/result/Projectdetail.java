package com.lfxwkj.purchase.modular.api.result;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
public class Projectdetail implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;


    private String name;

    private String recordName;

    /**
     * 0 为待定***元/平方米
     */
    private BigDecimal price;

    private String Tel;

    private String address;

    private String addrLng;

    private String addrLat;

    /**
     * 在售 待售等
     */
    private String saleStatus;

    private Date openDate;

    private String saleAddr;

    private String saleAddrLng;

    private String saleAddrLat;

    private BigDecimal areaCovered;

    private BigDecimal buildArea;

    private List<String> pictureUrls;

}
