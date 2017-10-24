package com.manba.simple.domain.inside;

/**
 * Created by lijin on 2017/10/24.
 */
public class GuildUserEntityRequest {

    private Long guildId; //公会id

    private Integer pageSize;
    private Integer pageNo;

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
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
