package com.manba.simple.domain.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijin on 2017/9/27.
 */
public class PageList<T> extends ArrayList implements List {

    private Integer totalCount;

    public PageList() {
    }

    public PageList(int totalCount, List<T> list) {
        this.totalCount = Integer.valueOf(totalCount);
        this.addAll(list);
    }

    public Integer getTotalCount() {
        return this.totalCount == null?Integer.valueOf(this.size()):this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
