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
@TableName("projectsalesperson")
public class Projectsalesperson implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("projectID")
    private Long projectID;

    @TableField("salespersonID")
    private Long salespersonID;

    /**
     * 默认为0  值越大靠前
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

    public Long getSalespersonID() {
        return salespersonID;
    }

    public void setSalespersonID(Long salespersonID) {
        this.salespersonID = salespersonID;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Projectsalesperson{" +
        "id=" + id +
        ", projectID=" + projectID +
        ", salespersonID=" + salespersonID +
        ", orderNum=" + orderNum +
        "}";
    }
}
