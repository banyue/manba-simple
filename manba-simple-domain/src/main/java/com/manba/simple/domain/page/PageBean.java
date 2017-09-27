package com.manba.simple.domain.page;

import java.io.Serializable;
import java.util.Collection;

/**
 * 分页实体类
 * Created by lijin on 2017/9/26.
 */
public class PageBean<T> implements Serializable {

    private long pageNo = 1L;
    private int pageSize = 20;
    private int maxPageSize = 100;
    private long totalCount;
    private Collection<T> resultList;

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxPageSize() {
        return maxPageSize;
    }

    public void setMaxPageSize(int maxPageSize) {
        this.maxPageSize = maxPageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public Collection<T> getResultList() {
        return resultList;
    }

    public void setResultList(Collection<T> resultList) {
        this.resultList = resultList;
    }
}
