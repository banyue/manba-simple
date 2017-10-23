package com.manba.simple.service;

import com.manba.simple.domain.entity.ManSimpleUserEntity;

import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
public interface UserService {

    ManSimpleUserEntity getOneUserInfo(ManSimpleUserEntity entity);

    /**
     * 相册列表
     * @param userId
     * @return
     */
    List<String> photoList(Long userId);

    /**
     * 获取关注数
     * @param userId
     * @return
     */
    Integer getFollowNum(Long userId);

    /**
     * 保存用户
     * @param entity
     * @return
     */
    Long createUser(ManSimpleUserEntity entity);

    /**
     * 更新用户信息
     * @param entity
     * @return
     */
    Integer updateUserInfo(ManSimpleUserEntity entity);

    /**
     * 上传用户头像，并保存到相册
     * @param entity
     * @return
     */
    Integer uploadPhotoAndSaveAlbum(ManSimpleUserEntity entity);
}
