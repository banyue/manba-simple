package com.manba.simple.domain.request;

/**
 * 公会请求实体
 * Created by lijin on 2017/9/26.
 */
public class GuildRequest {

    private String guildId;  //公会id

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

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }
}
