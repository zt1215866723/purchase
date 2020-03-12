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
@TableName("salesperson")
public class Salesperson implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("picUrl")
    private String picUrl;

    @TableField("tel")
    private String tel;

    @TableField("weChatNo")
    private String weChatNo;

    @TableField("QRCodeUrl")
    private String QRCodeUrl;

    @TableField("goodNum")
    private Integer goodNum;

    @TableField("serviceNum")
    private Integer serviceNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeChatNo() {
        return weChatNo;
    }

    public void setWeChatNo(String weChatNo) {
        this.weChatNo = weChatNo;
    }

    public String getQRCodeUrl() {
        return QRCodeUrl;
    }

    public void setQRCodeUrl(String QRCodeUrl) {
        this.QRCodeUrl = QRCodeUrl;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(Integer serviceNum) {
        this.serviceNum = serviceNum;
    }

    @Override
    public String toString() {
        return "Salesperson{" +
        "id=" + id +
        ", name=" + name +
        ", picUrl=" + picUrl +
        ", tel=" + tel +
        ", weChatNo=" + weChatNo +
        ", QRCodeUrl=" + QRCodeUrl +
        ", goodNum=" + goodNum +
        ", serviceNum=" + serviceNum +
        "}";
    }
}
