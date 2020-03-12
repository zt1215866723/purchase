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
@TableName("houselayoutimg")
public class Houselayoutimg implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("houseLayID")
    private Long houseLayID;

    @TableField("imgUrl")
    private String imgUrl;

    /**
     * 主图显示在户型列表,默认为0 勾选为1 则主图
            
     */
    @TableField("isMain")
    private Integer isMain;

    /**
     * 某户型中轮播显示户型图的顺序，默认为0，数值越大排前
            
     */
    @TableField("orderNum")
    private Integer orderNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseLayID() {
        return houseLayID;
    }

    public void setHouseLayID(Long houseLayID) {
        this.houseLayID = houseLayID;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Houselayoutimg{" +
        "id=" + id +
        ", houseLayID=" + houseLayID +
        ", imgUrl=" + imgUrl +
        ", isMain=" + isMain +
        ", orderNum=" + orderNum +
        "}";
    }
}
