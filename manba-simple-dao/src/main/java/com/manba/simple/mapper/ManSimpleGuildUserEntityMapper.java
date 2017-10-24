package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleGuildUserEntity;

import java.util.List;

public interface ManSimpleGuildUserEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleGuildUserEntity record);

    int insertSelective(ManSimpleGuildUserEntity record);

    ManSimpleGuildUserEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleGuildUserEntity record);

    int updateByPrimaryKey(ManSimpleGuildUserEntity record);

    List<ManSimpleGuildUserEntity> queryGuildMember(Long guildId);
}