package com.manba.simple.domain.request;

import java.io.Serializable;

/**
 * Created by lijin on 2017/10/22.
 * 评论请求
 */
public class CommentRequest implements Serializable {

    private Long commentParentId;  //评论父ID
    private Long userId;  //评论人ID
    private Long zoneId; //动态ID
    private String content;  //评论内容

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(Long commentParentId) {
        this.commentParentId = commentParentId;
    }
}
