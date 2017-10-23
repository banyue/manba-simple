package com.manba.simple.domain.request;

import java.io.Serializable;

/**
 * Created by lijin on 2017/10/23.
 * 评论列表查询请求
 */
public class CommentListRequest implements Serializable {

    private Long zoneId;

    private Integer pageSize;
    private Integer pageNo;

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
