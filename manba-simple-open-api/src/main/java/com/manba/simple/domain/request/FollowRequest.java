package com.manba.simple.domain.request;

import java.io.Serializable;

/**
 * Created by lijin on 2017/10/22.
 * 关注请求
 */
public class FollowRequest implements Serializable {

    private Long userId;  //当前用户
    private Long followId;  //被关注人ID

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }
}
