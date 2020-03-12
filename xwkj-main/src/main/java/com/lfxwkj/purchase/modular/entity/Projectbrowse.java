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
@TableName("projectbrowse")
public class Projectbrowse implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("clientID")
    private Long clientID;

    /**
     * 楼盘的项目的主键
     */
    @TableField("projectID")
    private Integer projectID;

    /**
     * 数据的添加时间
     */
    @TableField("creatTime")
    private Long creatTime;

    /**
     * 是否已经推荐
     */
    @TableField("isRecom")
    private String isRecom;

    /**
     * 数据的状态
     */
    @TableField("orderNum")
    private Integer orderNum;

    /**
     * 销售的主键
     */
    @TableField("salesID")
    private Long salesID;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public String getIsRecom() {
        return isRecom;
    }

    public void setIsRecom(String isRecom) {
        this.isRecom = isRecom;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getSalesID() {
        return salesID;
    }

    public void setSalesID(Long salesID) {
        this.salesID = salesID;
    }

    @Override
    public String toString() {
        return "Projectbrowse{" +
        "id=" + id +
        ", clientID=" + clientID +
        ", projectID=" + projectID +
        ", creatTime=" + creatTime +
        ", isRecom=" + isRecom +
        ", orderNum=" + orderNum +
        ", salesID=" + salesID +
        "}";
    }
}
