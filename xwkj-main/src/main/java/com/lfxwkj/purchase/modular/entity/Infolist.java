package com.lfxwkj.purchase.modular.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 存储新闻、公告等信息 

 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@TableName("infolist")
public class Infolist implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 1、新闻
            2、公告
            3、项目新闻
     */
    @TableField("infoType")
    private Integer infoType;

    @TableField("projectID")
    private Long projectID;

    @TableField("title")
    private String title;

    @TableField("listTitle")
    private String listTitle;

    @TableField("listPicUrl")
    private String listPicUrl;

    @TableField("tagLabel")
    private String tagLabel;

    @TableField("abstrac")
    private String abstrac;

    /**
     * 消息置顶级别，默认为0，值越大，越靠前。后台、前台该类信息显示，根据固顶级别 、发布时间  降序进行排序显示
     */
    @TableField("topLevel")
    private Integer topLevel;

    @TableField("topTime")
    private Date topTime;

    @TableField("content")
    private String content;

    @TableField("createTime")
    private Date createTime;

    @TableField("createUserId")
    private Long createUserId;

    /**
     * 0 删除 1发布 2暂存
     */
    @TableField("status")
    private Integer status;

    @TableField("readNum")
    private Integer readNum;

    @TableField("goodNum")
    private Integer goodNum;

    /**
     * 默认值0  不轮播，1则轮播显示。（注：轮播默认显示状态为1的前几个）
     */
    @TableField("isPlay")
    private Integer isPlay;

    @TableField("linkUrl")
    private String linkUrl;

    @TableField("isShow")
    private Integer isShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    public String getTagLabel() {
        return tagLabel;
    }

    public void setTagLabel(String tagLabel) {
        this.tagLabel = tagLabel;
    }

    public String getAbstract() {
        return abstrac;
    }

    public void setAbstract(String abstrac) {
        this.abstrac = abstrac;
    }

    public Integer getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(Integer topLevel) {
        this.topLevel = topLevel;
    }

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getIsPlay() {
        return isPlay;
    }

    public void setIsPlay(Integer isPlay) {
        this.isPlay = isPlay;
    }

    public String getLinkUrl() { return linkUrl; }

    public void setLinkUrl(String linkUrl) { this.linkUrl = linkUrl; }

    public Integer getIsShow() { return isShow; }

    public void setIsShow(Integer isShow) { this.isShow = isShow; }

    @Override
    public String toString() {
        return "Infolist{" +
        "id=" + id +
        ", infoType=" + infoType +
        ", projectID=" + projectID +
        ", title=" + title +
        ", listTitle=" + listTitle +
        ", listPicUrl=" + listPicUrl +
        ", tagLabel=" + tagLabel +
        ", abstrac=" + abstrac +
        ", topLevel=" + topLevel +
        ", topTime=" + topTime +
        ", content=" + content +
        ", createTime=" + createTime +
        ", createUserId=" + createUserId +
        ", status=" + status +
        ", readNum=" + readNum +
        ", goodNum=" + goodNum +
        ", isPlay=" + isPlay +
        ", linkUrl=" + linkUrl +
        ", isShow=" + isShow +
        "}";
    }
}
