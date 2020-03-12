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
@TableName("projectimg")
public class Projectimg implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("projectID")
    private Long projectID;

    /**
     * 1 图片 2 视频 3全景
     */
    @TableField("imgType")
    private Integer imgType;

    /**
     * 效果图、配套图、实景图等
     */
    @TableField("imgClass")
    private Long imgClass;

    @TableField("imgUrl")
    private String imgUrl;

    /**
     * 默认为0   值越大越靠前
     */
    @TableField("orderNum")
    private Integer orderNum;


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

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    public Long getImgClass() {
        return imgClass;
    }

    public void setImgClass(Long imgClass) {
        this.imgClass = imgClass;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Projectimg{" +
        "id=" + id +
        ", projectID=" + projectID +
        ", imgType=" + imgType +
        ", imgClass=" + imgClass +
        ", imgUrl=" + imgUrl +
        ", orderNum=" + orderNum +
        "}";
    }
}
