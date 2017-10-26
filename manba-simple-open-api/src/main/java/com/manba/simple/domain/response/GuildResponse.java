package com.manba.simple.domain.response;

/**
 * 公会返回实体
 * Created by lijin on 2017/9/26.
 */
public class GuildResponse {

    private Long guildId;

    private String guildName;

    private Integer memberNum;

    private Integer liveness;

    private String guildPhoto;

    private String declaration;

    private Long createUser;

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
    }

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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
}
