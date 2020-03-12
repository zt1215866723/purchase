package com.lfxwkj.purchase.modular.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 项目所属区域
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@TableName("projectarea")
public class Projectarea implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 1 国内
            2 国外
     */
    @TableField("areaType")
    private Integer areaType;

    @TableField("areaName")
    private String areaName;

    @TableField("areaLatter")
    private String areaLatter;

    /**
     * 1启用
            0停用
     */
    @TableField("status")
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaLatter() {
        return areaLatter;
    }

    public void setAreaLatter(String areaLatter) {
        this.areaLatter = areaLatter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Projectarea{" +
        "id=" + id +
        ", areaType=" + areaType +
        ", areaName=" + areaName +
        ", areaLatter=" + areaLatter +
        ", status=" + status +
        "}";
    }
}
