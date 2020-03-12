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
@TableName("projectdynamic")
public class Projectdynamic implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("projectId")
    private Long projectId;

    /**
     * 预售证、开盘、交房等
            
     */
    @TableField("dynamicType")
    private Long dynamicType;

    @TableField("title")
    private String title;

    @TableField("dynamicDate")
    private Date dynamicDate;

    @TableField("content")
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getDynamicType() {
        return dynamicType;
    }

    public void setDynamicType(Long dynamicType) {
        this.dynamicType = dynamicType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDynamicDate() {
        return dynamicDate;
    }

    public void setDynamicDate(Date dynamicDate) {
        this.dynamicDate = dynamicDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Projectdynamic{" +
        "id=" + id +
        ", projectId=" + projectId +
        ", dynamicType=" + dynamicType +
        ", title=" + title +
        ", dynamicDate=" + dynamicDate +
        ", content=" + content +
        "}";
    }
}
