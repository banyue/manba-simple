package com.manba.simple.domain.inside;

/**
 * Created by lijin on 2017/10/24.
 */
public class GuildEntityRequest {

    private String userId; //用户id

    private Integer pageSize;
    private Integer pageNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
