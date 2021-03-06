package com.manba.simple.domain.response;

import java.util.Date;

/**
 * 动态详情返回结果
 * Created by lijin on 2017/9/26.
 */
public class ZoneResponse {

    private Long id;
    private String zoneTitle;
    private Long userId;
    private String zoneContent;
    private String zoneImage;
    private Date publishTime;

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
        this.zoneTitle = zoneTitle;
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
        this.zoneContent = zoneContent;
    }

    public String getZoneImage() {
        return zoneImage;
    }

    public void setZoneImage(String zoneImage) {
        this.zoneImage = zoneImage;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
