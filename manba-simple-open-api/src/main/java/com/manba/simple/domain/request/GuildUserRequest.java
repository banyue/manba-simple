package com.manba.simple.domain.request;

/**
 * Created by lijin on 2017/10/24.
 */
public class GuildUserRequest {

    private String userId;
    private String guildId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }
}
