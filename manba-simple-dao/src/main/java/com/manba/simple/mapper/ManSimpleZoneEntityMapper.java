package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleZoneEntity;

public interface ManSimpleZoneEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleZoneEntity record);

    int insertSelective(ManSimpleZoneEntity record);

    ManSimpleZoneEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleZoneEntity record);

    int updateByPrimaryKey(ManSimpleZoneEntity record);
}