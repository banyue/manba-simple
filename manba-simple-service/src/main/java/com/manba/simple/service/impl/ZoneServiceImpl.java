package com.manba.simple.service.impl;

import com.manba.simple.domain.entity.ManSimpleZoneEntity;
import com.manba.simple.domain.inside.ZoneEntityRequest;
import com.manba.simple.mapper.ManSimpleZoneEntityMapper;
import com.manba.simple.service.ZoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class ZoneServiceImpl implements ZoneService {

    @Resource
    ManSimpleZoneEntityMapper manSimpleZoneEntityMapper;

    public List<ManSimpleZoneEntity> selectZoneList(ZoneEntityRequest request) {
        ManSimpleZoneEntity zoneEntity = new ManSimpleZoneEntity();
        return manSimpleZoneEntityMapper.selectZonesByCondition(zoneEntity);
    }
}
