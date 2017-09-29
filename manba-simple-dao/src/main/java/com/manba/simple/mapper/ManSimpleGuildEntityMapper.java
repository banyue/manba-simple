package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleGuildEntity;

public interface ManSimpleGuildEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleGuildEntity record);

    int insertSelective(ManSimpleGuildEntity record);

    ManSimpleGuildEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleGuildEntity record);

    int updateByPrimaryKey(ManSimpleGuildEntity record);
}