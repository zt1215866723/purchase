package com.lfxwkj.purchase.modular.entity;

import java.math.BigDecimal;
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
@TableName("projectambitus")
public class Projectambitus implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("projectID")
    private Long projectID;

    /**
     * 如 交通、学校、医疗、购物等
     */
    @TableField("ambitusType")
    private Long ambitusType;

    @TableField("name")
    private String name;

    @TableField("distance")
    private BigDecimal distance;


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

    public Long getAmbitusType() {
        return ambitusType;
    }

    public void setAmbitusType(Long ambitusType) {
        this.ambitusType = ambitusType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Projectambitus{" +
        "id=" + id +
        ", projectID=" + projectID +
        ", ambitusType=" + ambitusType +
        ", name=" + name +
        ", distance=" + distance +
        "}";
    }
}
