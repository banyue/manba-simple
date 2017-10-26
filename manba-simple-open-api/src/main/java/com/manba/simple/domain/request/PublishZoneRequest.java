package com.manba.simple.domain.request;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * 发布动态请求
 * Created by lijin on 2017/9/29.
 */
public class PublishZoneRequest implements Serializable {

    private String zoneTitle;
    private Long userId;
    private String zoneContent;
    private String zoneImage;
    private MultipartFile[] zoneFile;

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

    public MultipartFile[] getZoneFile() {
        return zoneFile;
    }

    public void setZoneFile(MultipartFile[] zoneFile) {
        this.zoneFile = zoneFile;
    }
}
