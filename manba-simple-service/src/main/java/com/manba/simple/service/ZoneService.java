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
}
