package com.manba.simple.service.impl;

import com.manba.simple.domain.constant.BusiTypeEnum;
import com.manba.simple.domain.constant.YnEnum;
import com.manba.simple.domain.entity.ManSimplePhotoEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.mapper.ManSimpleFollowEntityMapper;
import com.manba.simple.mapper.ManSimplePhotoEntityMapper;
import com.manba.simple.mapper.ManSimpleUserEntityMapper;
import com.manba.simple.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    ManSimpleUserEntityMapper manSimpleUserEntityMapper;
    @Resource
    ManSimpleFollowEntityMapper manSimpleFollowEntityMapper;
    @Resource
    ManSimplePhotoEntityMapper manSimplePhotoEntityMapper;

    @Override
    public ManSimpleUserEntity getOneUserInfo(ManSimpleUserEntity entity) {
        return manSimpleUserEntityMapper.selectByPrimaryKey(entity.getId());
    }

    @Override
    public List<String> photoList(Long userId) {
        List<String> result = new ArrayList<>();
        List<ManSimplePhotoEntity> entities = manSimplePhotoEntityMapper.queryPhotoList(userId);
        entities.forEach(entity -> {
            result.add(entity.getPhotoPath());
        });
        return result;
    }

    @Override
    public Integer getFollowNum(Long userId) {
        return manSimpleFollowEntityMapper.queryFollowList(userId).size();
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer uploadPhotoAndSaveAlbum(ManSimpleUserEntity entity) {
        Integer r = manSimpleUserEntityMapper.updateByPrimaryKeySelective(entity);
        //保存相册表
        if(r > 0) {
            ManSimplePhotoEntity photoEntity = new ManSimplePhotoEntity();
            photoEntity.setUserId(entity.getId());
            photoEntity.setPhotoPath(entity.getPhotoUrl());
            photoEntity.setCreateTime(new Date());
            photoEntity.setYn(YnEnum.YES.getCode());
            photoEntity.setBusiType(BusiTypeEnum.USER_PHOTO.getCode());
            manSimplePhotoEntityMapper.insertSelective(photoEntity);
        }
        return r;
    }
}
