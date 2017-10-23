package com.manba.simple.domain.request;

import java.io.Serializable;

/**
 * Created by lijin on 2017/10/22.
 * 点赞请求
 */
public class UpvoteRequest implements Serializable {

    private Long upvoteUserId;
    private Long zoneId;

    public Long getUpvoteUserId() {
        return upvoteUserId;
    }

    public void setUpvoteUserId(Long upvoteUserId) {
        this.upvoteUserId = upvoteUserId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
