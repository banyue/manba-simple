package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleFollowEntity;

import java.util.List;

public interface ManSimpleFollowEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleFollowEntity record);

    int insertSelective(ManSimpleFollowEntity record);

    ManSimpleFollowEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleFollowEntity record);

    int updateByPrimaryKey(ManSimpleFollowEntity record);

    List<ManSimpleFollowEntity> queryFollowList(Long userId);
}