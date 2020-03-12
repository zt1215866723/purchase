package com.lfxwkj.purchase.modular.entity;

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
 * @since 2020-03-12
 */
@TableName("projectlink")
public class Projectlink implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("projectID")
    private Long projectID;

    @TableField("clientID")
    private Long clientID;

    /**
     * 1 预约登记
            2 变价通知
            3、开盘通知
     */
    @TableField("linkType")
    private Integer linkType;

    @TableField("linkTel")
    private String linkTel;

    @TableField("submitTime")
    private Date submitTime;

    /**
     * 提交后，默认状态为0
            如 预约登记已通知，或变价通知已通知等则状态改为1
     */
    @TableField("isNotice")
    private Integer isNotice;

    @TableField("memo")
    private String memo;


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

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(Integer isNotice) {
        this.isNotice = isNotice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Projectlink{" +
        "id=" + id +
        ", projectID=" + projectID +
        ", clientID=" + clientID +
        ", linkType=" + linkType +
        ", linkTel=" + linkTel +
        ", submitTime=" + submitTime +
        ", isNotice=" + isNotice +
        ", memo=" + memo +
        "}";
    }
}
