package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleUserEntity;

public interface ManSimpleUserEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleUserEntity record);

    int insertSelective(ManSimpleUserEntity record);

    ManSimpleUserEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleUserEntity record);

    int updateByPrimaryKey(ManSimpleUserEntity record);
}