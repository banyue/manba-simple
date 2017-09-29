package com.manba.simple.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class ManSimpleZoneEntity implements Serializable {
    private Long id;

    private String zoneTitle;

    private Long userId;

    private String zoneContent;

    private String zoneImage;

    private Date publishTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZoneTitle() {
        return zoneTitle;
    }

    public void setZoneTitle(String zoneTitle) {
        this.zoneTitle = zoneTitle == null ? null : zoneTitle.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getZoneContent() {
        return zoneContent;
    }

    public void setZoneContent(String zoneContent) {
        this.zoneContent = zoneContent == null ? null : zoneContent.trim();
    }

    public String getZoneImage() {
        return zoneImage;
    }

    public void setZoneImage(String zoneImage) {
        this.zoneImage = zoneImage == null ? null : zoneImage.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}