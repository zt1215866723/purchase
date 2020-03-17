package com.lfxwkj.purchase.modular.api.result;

import com.lfxwkj.purchase.modular.model.result.HouselayoutimgResult;

import java.util.List;

/**
 * @ClassName:HouselayoutVo
 * @Description:
 * @Author:张童
 * @Date:
 **/
public class HouselayoutVo {
    private Long houseId;

    private String houseName;

    private Long saleStatus;

    private String storeyPrice;

    private String content;

    private String buildArea;

    private String projectName;

    private String imgUrl;

    private List<HouselayoutimgResult> imgUrlList;

    public Long getHouseId() {
        return houseId;
    }

    public HouselayoutVo setHouseId(Long houseId) {
        this.houseId = houseId;
        return this;
    }

    public String getHouseName() {
        return houseName;
    }

    public HouselayoutVo setHouseName(String houseName) {
        this.houseName = houseName;
        return this;
    }

    public Long getSaleStatus() {
        return saleStatus;
    }

    public HouselayoutVo setSaleStatus(Long saleStatus) {
        this.saleStatus = saleStatus;
        return this;
    }

    public String getStoreyPrice() {
        return storeyPrice;
    }

    public HouselayoutVo setStoreyPrice(String storeyPrice) {
        this.storeyPrice = storeyPrice;
        return this;
    }

    public String getContent() {
        return content;
    }

    public HouselayoutVo setContent(String content) {
        this.content = content;
        return this;
    }

    public String getBuildArea() {
        return buildArea;
    }

    public HouselayoutVo setBuildArea(String buildArea) {
        this.buildArea = buildArea;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public HouselayoutVo setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public HouselayoutVo setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public List<HouselayoutimgResult> getImgUrlList() {
        return imgUrlList;
    }

    public HouselayoutVo setImgUrlList(List<HouselayoutimgResult> imgUrlList) {
        this.imgUrlList = imgUrlList;
        return this;
    }
}
