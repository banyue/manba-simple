package com.manba.simple.domain.request;

import java.io.Serializable;

/**
 * Created by lijin on 2017/10/22.
 * 点赞请求
 */
public class UpvoteRequest implements Serializable {

    private Long userId;
    private Long zoneId;

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
