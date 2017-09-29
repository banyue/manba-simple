package com.manba.simple.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class ManSimpleGuildEntity implements Serializable {
    private Long id;

    private String guildName;

    private Integer memberNum;

    private Integer liveness;

    private String guildPhoto;

    private String declaration;

    private Long createUser;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName == null ? null : guildName.trim();
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
        this.guildPhoto = guildPhoto == null ? null : guildPhoto.trim();
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration == null ? null : declaration.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}