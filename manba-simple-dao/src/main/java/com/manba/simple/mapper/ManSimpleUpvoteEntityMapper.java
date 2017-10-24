package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleUpvoteEntity;

import java.util.List;

public interface ManSimpleUpvoteEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleUpvoteEntity record);

    int insertSelective(ManSimpleUpvoteEntity record);

    ManSimpleUpvoteEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleUpvoteEntity record);

    int updateByPrimaryKey(ManSimpleUpvoteEntity record);

    List<ManSimpleUpvoteEntity> queryUpvoteList(Long zoneId);
}