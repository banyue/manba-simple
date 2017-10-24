package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleFavoriteEntity;

import java.util.List;

public interface ManSimpleFavoriteEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleFavoriteEntity record);

    int insertSelective(ManSimpleFavoriteEntity record);

    ManSimpleFavoriteEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleFavoriteEntity record);

    int updateByPrimaryKey(ManSimpleFavoriteEntity record);

    List<ManSimpleFavoriteEntity> queryFavoriteList(Long userId);
}