package com.lfxwkj.purchase.modular.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@TableName("houselayout")
public class Houselayout implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("projectID")
    private Long projectID;

    @TableField("houseType")
    private Long houseType;
    /**
     * 如：
            A2户型
     */
    @TableField("layoutName")
    private String layoutName;

    /**
     * 如：二室二厅一卫
     */
    @TableField("room")
    private String room;

    /**
     * 如：约75万元/套
     */
    @TableField("storeyPrice")
    private String storeyPrice;

    /**
     * 如：105
     */
    @TableField("buildArea")
    private String buildArea;

    /**
     * 该户型销售状态：在售、待售等
     */
    @TableField("saleStatus")
    private Long saleStatus;

    @TableField("content")
    private String content;

    /**
     * 默认值0，数值越大排前
     */
    @TableField("orderNum")
    private Integer orderNum;

    /**
     * 默认值0，数值越大排前
     */
    @TableField("isMain")
    private Integer isMain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStoreyPrice() {
        return storeyPrice;
    }

    public void setStoreyPrice(String storeyPrice) {
        this.storeyPrice = storeyPrice;
    }

    public String getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(String buildArea) {
        this.buildArea = buildArea;
    }

    public Long getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Long saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getIsMain() { return isMain; }

    public void setIsMain(Integer isMain) { this.isMain = isMain; }

    public Long getHouseType() { return houseType; }

    public void setHouseType(Long houseType) { this.houseType = houseType; }

    @Override
    public String toString() {
        return "Houselayout{" +
        "id=" + id +
        ", projectID=" + projectID +
        ", layoutName=" + layoutName +
        ", room=" + room +
        ", storeyPrice=" + storeyPrice +
        ", buildArea=" + buildArea +
        ", saleStatus=" + saleStatus +
        ", content=" + content +
        ", orderNum=" + orderNum +
        ", isMain=" + isMain +
        ", houseType=" + houseType +
        "}";
    }
}
