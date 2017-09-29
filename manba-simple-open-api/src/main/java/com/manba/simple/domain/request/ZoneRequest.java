package com.manba.simple.domain.request;

/**
 * 动态请求
 * Created by lijin on 2017/9/26.
 */
public class ZoneRequest {

    private String id;  //动态id

    private Integer pageSize;
    private Integer pageNo;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
