package com.manba.simple.service.impl;

import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.mapper.ManSimpleUserEntityMapper;
import com.manba.simple.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    ManSimpleUserEntityMapper manSimpleUserEntityMapper;

    @Override
    public ManSimpleUserEntity getOneUserInfo(ManSimpleUserEntity entity) {
        return manSimpleUserEntityMapper.selectByPrimaryKey(entity.getId());
    }

    @Override
    public List<String> photoList(Long userId) {
        return null;
    }

    @Override
    public Integer getFollowNum(Long userId) {
        return null;
    }

    @Override
    public Long createUser(ManSimpleUserEntity entity) {
        manSimpleUserEntityMapper.insertSelective(entity);
        return entity.getId();
    }

    @Override
    public Integer updateUserInfo(ManSimpleUserEntity entity) {
        return manSimpleUserEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
