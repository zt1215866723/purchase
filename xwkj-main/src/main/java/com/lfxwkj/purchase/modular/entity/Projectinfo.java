package com.lfxwkj.purchase.modular.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
@TableName("projectinfo")
public class Projectinfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("areaId")
    private Long areaId;

    @TableField("NAME")
    private String name;

    @TableField("recordName")
    private String recordName;

    /**
     * 0 为待定***元/平方米
     */
    @TableField("price")
    private BigDecimal price;

    @TableField("Tel")
    private String Tel;

    @TableField("address")
    private String address;

    @TableField("addrLng")
    private String addrLng;

    @TableField("addrLat")
    private String addrLat;

    /**
     * 多选
     */
    @TableField("propertyType")
    private String propertyType;

    @TableField("projectAdv")
    private String projectAdv;

    /**
     * 多选
     */
    @TableField("buildType")
    private String buildType;

    /**
     * 多选
     */
    @TableField("renovation")
    private String renovation;

    @TableField("years")
    private String years;

    @TableField("developer")
    private String developer;

    @TableField("handDate")
    private Date handDate;

    /**
     * 在售 待售等
     */
    @TableField("saleStatus")
    private Long saleStatus;

    @TableField("openDate")
    private Date openDate;

    @TableField("saleAddr")
    private String saleAddr;

    @TableField("saleAddrLng")
    private String saleAddrLng;

    @TableField("saleAddrLat")
    private String saleAddrLat;

    @TableField("areaCovered")
    private BigDecimal areaCovered;

    @TableField("buildArea")
    private BigDecimal buildArea;

    @TableField("plotRatio")
    private BigDecimal plotRatio;

    @TableField("greenRate")
    private BigDecimal greenRate;

    @TableField("ParkNum")
    private String ParkNum;

    @TableField("floorNum")
    private Integer floorNum;

    @TableField("houseNum")
    private Integer houseNum;

    @TableField("propertyCorp")
    private String propertyCorp;

    @TableField("propertyPrice")
    private String propertyPrice;

    @TableField("storeyCon")
    private String storeyCon;

    @TableField("projectIntro")
    private String projectIntro;

    @TableField("projectSpot")
    private String projectSpot;

    /**
     * 1 有效 0删除
     */
    @TableField("STATUS")
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddrLng() {
        return addrLng;
    }

    public void setAddrLng(String addrLng) {
        this.addrLng = addrLng;
    }

    public String getAddrLat() {
        return addrLat;
    }

    public void setAddrLat(String addrLat) {
        this.addrLat = addrLat;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getProjectAdv() {
        return projectAdv;
    }

    public void setProjectAdv(String projectAdv) {
        this.projectAdv = projectAdv;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getRenovation() {
        return renovation;
    }

    public void setRenovation(String renovation) {
        this.renovation = renovation;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Date getHandDate() {
        return handDate;
    }

    public void setHandDate(Date handDate) {
        this.handDate = handDate;
    }

    public Long getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Long saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getSaleAddr() {
        return saleAddr;
    }

    public void setSaleAddr(String saleAddr) {
        this.saleAddr = saleAddr;
    }

    public String getSaleAddrLng() {
        return saleAddrLng;
    }

    public void setSaleAddrLng(String saleAddrLng) {
        this.saleAddrLng = saleAddrLng;
    }

    public String getSaleAddrLat() {
        return saleAddrLat;
    }

    public void setSaleAddrLat(String saleAddrLat) {
        this.saleAddrLat = saleAddrLat;
    }

    public BigDecimal getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(BigDecimal areaCovered) {
        this.areaCovered = areaCovered;
    }

    public BigDecimal getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(BigDecimal buildArea) {
        this.buildArea = buildArea;
    }

    public BigDecimal getPlotRatio() {
        return plotRatio;
    }

    public void setPlotRatio(BigDecimal plotRatio) {
        this.plotRatio = plotRatio;
    }

    public BigDecimal getGreenRate() {
        return greenRate;
    }

    public void setGreenRate(BigDecimal greenRate) {
        this.greenRate = greenRate;
    }

    public String getParkNum() {
        return ParkNum;
    }

    public void setParkNum(String ParkNum) {
        this.ParkNum = ParkNum;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    public String getPropertyCorp() {
        return propertyCorp;
    }

    public void setPropertyCorp(String propertyCorp) {
        this.propertyCorp = propertyCorp;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getStoreyCon() {
        return storeyCon;
    }

    public void setStoreyCon(String storeyCon) {
        this.storeyCon = storeyCon;
    }

    public String getProjectIntro() {
        return projectIntro;
    }

    public void setProjectIntro(String projectIntro) {
        this.projectIntro = projectIntro;
    }

    public String getProjectSpot() {
        return projectSpot;
    }

    public void setProjectSpot(String projectSpot) {
        this.projectSpot = projectSpot;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Projectinfo{" +
        "id=" + id +
        ", areaId=" + areaId +
        ", name=" + name +
        ", recordName=" + recordName +
        ", price=" + price +
        ", Tel=" + Tel +
        ", address=" + address +
        ", addrLng=" + addrLng +
        ", addrLat=" + addrLat +
        ", propertyType=" + propertyType +
        ", projectAdv=" + projectAdv +
        ", buildType=" + buildType +
        ", renovation=" + renovation +
        ", years=" + years +
        ", developer=" + developer +
        ", handDate=" + handDate +
        ", saleStatus=" + saleStatus +
        ", openDate=" + openDate +
        ", saleAddr=" + saleAddr +
        ", saleAddrLng=" + saleAddrLng +
        ", saleAddrLat=" + saleAddrLat +
        ", areaCovered=" + areaCovered +
        ", buildArea=" + buildArea +
        ", plotRatio=" + plotRatio +
        ", greenRate=" + greenRate +
        ", ParkNum=" + ParkNum +
        ", floorNum=" + floorNum +
        ", houseNum=" + houseNum +
        ", propertyCorp=" + propertyCorp +
        ", propertyPrice=" + propertyPrice +
        ", storeyCon=" + storeyCon +
        ", projectIntro=" + projectIntro +
        ", projectSpot=" + projectSpot +
        ", status=" + status +
        "}";
    }
}
