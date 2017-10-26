package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimplePhotoEntity;

import java.util.List;

public interface ManSimplePhotoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimplePhotoEntity record);

    int insertSelective(ManSimplePhotoEntity record);

    ManSimplePhotoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimplePhotoEntity record);

    int updateByPrimaryKey(ManSimplePhotoEntity record);

    List<ManSimplePhotoEntity> queryPhotoList(Long userId);

    ManSimplePhotoEntity selectOnePhoto(ManSimplePhotoEntity entity);
}