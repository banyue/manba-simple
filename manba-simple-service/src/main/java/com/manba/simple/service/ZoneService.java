package com.manba.simple.service;

import com.manba.simple.domain.entity.ManSimpleCommentEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.entity.ManSimpleZoneEntity;
import com.manba.simple.domain.inside.CommentEntityRequest;
import com.manba.simple.domain.inside.FavoriteEntityRequest;
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

    /**
     * 关注某人
     * @param userId
     * @param followId
     * @return
     */
    Long follow(Long userId, Long followId);

    /**
     * 获取关注列表
     * @param userId
     * @return
     */
    List<ManSimpleUserEntity> followList(Long userId);

    /**
     * 点赞某条动态
     * @param userId
     * @param zoneId
     * @return
     */
    Long upvote(Long userId, Long zoneId);

    /**
     * 点赞列表
     * @param zoneId
     * @return
     */
    List<ManSimpleUserEntity> upvoteList(Long zoneId);

    /**
     * 发表评论
     * @param entity
     * @return
     */
    Long comment(ManSimpleCommentEntity entity);

    /**
     * 查询评论列表
     * @param request
     * @return
     */
    List<ManSimpleCommentEntity> selectCommentList(CommentEntityRequest request);

    /**
     * 查询点赞数
     * @param zoneId
     * @return
     */
    Integer getUpvoteNum(Long zoneId);

    /**
     * 收藏动态
     * @param userId
     * @param zoneId
     * @return
     */
    Long favorite(Long userId, Long zoneId);

    /**
     * 取消收藏
     * @param userId
     * @param zoneId
     * @return
     */
    Integer cancelFavorite(Long userId, Long zoneId);

    /**
     * 收藏列表
     * @param request
     * @return
     */
    List<ManSimpleZoneEntity> queryFavoriteList(FavoriteEntityRequest request);
}
