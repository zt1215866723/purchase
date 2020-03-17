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
public class HouselayoutParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long houseType;

        private Long projectID;

            /**
             * 如：
            A2户型
             */
        private String layoutName;

            /**
             * 如：二室二厅一卫
             */
        private String room;

            /**
             * 如：约75万元/套
             */
        private String storeyPrice;

            /**
             * 如：105
             */
        private String buildArea;

            /**
             * 该户型销售状态：在售、待售等
             */
        private Long saleStatus;

        private String content;

            /**
             * 默认值0，数值越大排前
             */
        private Integer orderNum;

        /**
         * 1是主力户型，2不是主力户型
         */

        private Integer isMain;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public HouselayoutParam setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getHouseType() {
        return houseType;
    }

    public HouselayoutParam setHouseType(Long houseType) {
        this.houseType = houseType;
        return this;
    }

    public Long getProjectID() {
        return projectID;
    }

    public HouselayoutParam setProjectID(Long projectID) {
        this.projectID = projectID;
        return this;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public HouselayoutParam setLayoutName(String layoutName) {
        this.layoutName = layoutName;
        return this;
    }

    public String getRoom() {
        return room;
    }

    public HouselayoutParam setRoom(String room) {
        this.room = room;
        return this;
    }

    public String getStoreyPrice() {
        return storeyPrice;
    }

    public HouselayoutParam setStoreyPrice(String storeyPrice) {
        this.storeyPrice = storeyPrice;
        return this;
    }

    public String getBuildArea() {
        return buildArea;
    }

    public HouselayoutParam setBuildArea(String buildArea) {
        this.buildArea = buildArea;
        return this;
    }

    public Long getSaleStatus() {
        return saleStatus;
    }

    public HouselayoutParam setSaleStatus(Long saleStatus) {
        this.saleStatus = saleStatus;
        return this;
    }

    public String getContent() {
        return content;
    }

    public HouselayoutParam setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public HouselayoutParam setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public HouselayoutParam setIsMain(Integer isMain) {
        this.isMain = isMain;
        return this;
    }

    @Override
    public String checkParam() {
        return null;
    }

}
