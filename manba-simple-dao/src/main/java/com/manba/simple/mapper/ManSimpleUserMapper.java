package com.manba.simple.mapper;

import com.manba.simple.domain.entity.ManSimpleUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManSimpleUserMapper {

    ManSimpleUserEntity selectManSimpleUser(ManSimpleUserEntity entity);

    ManSimpleUserEntity selectOneManSimpleUser(Long id);

    Integer countManSimpleUser(ManSimpleUserEntity entity);

    void insertManSimpleUser(ManSimpleUserEntity entity);

    void insertManSimpleUserBatch(List<ManSimpleUserEntity> entities);

    void updateManSimpleUser(Map map);

    void updateManSimpleUserBatch(List<ManSimpleUserEntity> entities);

    void deleteManSimpleUser(ManSimpleUserEntity entity);

    void deleteOneManSimpleUser(Long id);

}