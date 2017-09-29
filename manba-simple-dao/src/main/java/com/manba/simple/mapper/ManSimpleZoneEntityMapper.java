package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleZoneEntity;

import java.util.List;

public interface ManSimpleZoneEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManSimpleZoneEntity record);

    int insertSelective(ManSimpleZoneEntity record);

    ManSimpleZoneEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManSimpleZoneEntity record);

    int updateByPrimaryKey(ManSimpleZoneEntity record);

    List<ManSimpleZoneEntity> selectZonesByCondition(ManSimpleZoneEntity record);
}