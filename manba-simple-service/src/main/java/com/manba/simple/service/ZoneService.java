package com.manba.simple.service;

import com.manba.simple.domain.entity.ManSimpleZoneEntity;
import com.manba.simple.domain.inside.ZoneEntityRequest;

import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
public interface ZoneService {

    /**
     * 查询动态列表
     * @param request
     * @return
     */
    List<ManSimpleZoneEntity> selectZoneList(ZoneEntityRequest request);

    /**
     * 根据动态ID获取动态
     * @param id
     * @return
     */
    ManSimpleZoneEntity selectOneZone(Long id);

    /**
     * 创建动态
     * @param request
     * @return
     */
    Long createZone(ManSimpleZoneEntity request);

    /**
     * 删除动态（注意：逻辑删除）
     * @param id
     * @return
     */
    Integer deleteZone(Long id);
}
