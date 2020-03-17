package com.lfxwkj.purchase.modular.api.result;

import com.lfxwkj.purchase.modular.entity.Projectambitus;
import com.lfxwkj.purchase.modular.entity.Projectdynamic;
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
public class Moredetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目周边的信息
     */
    private List<Projectambitus> projectambituses;

    /**
     * 项目的动态信息
     */
    private List<Projectdynamic> projectdynamics;

    private Long id;

    private Long areaId;

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
     * 多选
     */
    private String propertyType;

    private String projectAdv;

    /**
     * 多选
     */
    private String buildType;

    /**
     * 多选
     */
    private String renovation;

    private String years;

    private String developer;

    private Date handDate;

    /**
     * 在售 待售等
     */
    private Long saleStatus;

    private Date openDate;

    private String saleAddr;

    private String saleAddrLng;

    private String saleAddrLat;

    private BigDecimal areaCovered;

    private BigDecimal buildArea;

    private BigDecimal plotRatio;

    private BigDecimal greenRate;

    private String ParkNum;

    private Integer floorNum;

    private Integer houseNum;

    private String propertyCorp;

    private String propertyPrice;

    private String storeyCon;

    private String projectIntro;

    private String projectSpot;

    /**
     * 1 有效 0删除
     */
    private Integer status;

}
