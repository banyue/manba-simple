package com.manba.simple.domain.request;

import java.io.Serializable;

/**
 * Created by lijin on 2017/9/29.
 */
public class CreateGuildRequest implements Serializable {

    private String userId;

    private String guildName;

    private Integer memberNum;

    private Integer liveness;

    private String guildPhoto;

    private String declaration;

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public Integer getLiveness() {
        return liveness;
    }

    public void setLiveness(Integer liveness) {
        this.liveness = liveness;
    }

    public String getGuildPhoto() {
        return guildPhoto;
    }

    public void setGuildPhoto(String guildPhoto) {
        this.guildPhoto = guildPhoto;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
