package com.manba.simple.service.impl;

import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.mapper.ManSimpleUserMapper;
import com.manba.simple.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    ManSimpleUserMapper manSimpleUserMapper;

    public ManSimpleUserEntity getOneUserInfo(ManSimpleUserEntity entity) {
        return manSimpleUserMapper.selectManSimpleUser(entity);
    }
}
