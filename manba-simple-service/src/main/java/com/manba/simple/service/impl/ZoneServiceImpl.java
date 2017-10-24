package com.manba.simple.service.impl;

import com.manba.simple.domain.constant.YnEnum;
import com.manba.simple.domain.entity.*;
import com.manba.simple.domain.inside.CommentEntityRequest;
import com.manba.simple.domain.inside.FavoriteEntityRequest;
import com.manba.simple.domain.inside.ZoneEntityRequest;
import com.manba.simple.mapper.*;
import com.manba.simple.service.ZoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class ZoneServiceImpl implements ZoneService {

    @Resource
    ManSimpleZoneEntityMapper manSimpleZoneEntityMapper;
    @Resource
    ManSimpleFollowEntityMapper manSimpleFollowEntityMapper;
    @Resource
    ManSimpleUserEntityMapper manSimpleUserEntityMapper;
    @Resource
    ManSimpleUpvoteEntityMapper manSimpleUpvoteEntityMapper;
    @Resource
    ManSimpleCommentEntityMapper manSimpleCommentEntityMapper;
    @Resource
    ManSimpleFavoriteEntityMapper manSimpleFavoriteEntityMapper;

    @Override
    public List<ManSimpleZoneEntity> selectZoneList(ZoneEntityRequest request) {
        ManSimpleZoneEntity zoneEntity = new ManSimpleZoneEntity();
        return manSimpleZoneEntityMapper.selectZonesByCondition(zoneEntity);
    }

    @Override
    public ManSimpleZoneEntity selectOneZone(Long id) {
        return manSimpleZoneEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long createZone(ManSimpleZoneEntity request) {
        manSimpleZoneEntityMapper.insertSelective(request);
        //返回主键
        return request.getId();
    }

    @Override
    public Integer deleteZone(Long id) {
        ManSimpleZoneEntity entity = new ManSimpleZoneEntity();
        entity.setId(id);
        entity.setYn(YnEnum.NO.getCode());
        entity.setUpdateTime(new Date());
        return manSimpleZoneEntityMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Long follow(Long userId, Long followId) {
        ManSimpleFollowEntity entity = new ManSimpleFollowEntity();
        entity.setFollowId(followId);
        entity.setUserId(userId);
        entity.setYn(YnEnum.YES.getCode());
        manSimpleFollowEntityMapper.insertSelective(entity);
        return entity.getId();
    }

    @Override
    public List<ManSimpleUserEntity> followList(Long userId) {
        List<ManSimpleFollowEntity> follows = manSimpleFollowEntityMapper.queryFollowList(userId);
        List<ManSimpleUserEntity> result = new ArrayList<>();
        for(ManSimpleFollowEntity entity : follows) {
            ManSimpleUserEntity user = manSimpleUserEntityMapper.selectByPrimaryKey(entity.getFollowId());
            result.add(user);
        }
        return result;
    }

    @Override
    public Long upvote(Long userId, Long zoneId) {
        ManSimpleUpvoteEntity entity = new ManSimpleUpvoteEntity();
        entity.setUserId(userId);
        entity.setZoneId(zoneId);
        entity.setUpvoteTime(new Date());
        entity.setYn(YnEnum.YES.getCode());
        manSimpleUpvoteEntityMapper.insertSelective(entity);
        return entity.getId();
    }

    @Override
    public List<ManSimpleUserEntity> upvoteList(Long zoneId) {
        List<ManSimpleUpvoteEntity> votes = manSimpleUpvoteEntityMapper.queryUpvoteList(zoneId);
        List<ManSimpleUserEntity> result = new ArrayList<>();
        for(ManSimpleUpvoteEntity entity : votes) {
            ManSimpleUserEntity user = manSimpleUserEntityMapper.selectByPrimaryKey(entity.getUserId());
            result.add(user);
        }
        return result;
    }

    @Override
    public Long comment(ManSimpleCommentEntity entity) {
        entity.setYn(YnEnum.YES.getCode());
        entity.setCommentTime(new Date());
        manSimpleCommentEntityMapper.insertSelective(entity);
        return entity.getId();
    }

    @Override
    public List<ManSimpleCommentEntity> selectCommentList(CommentEntityRequest request) {
        return manSimpleCommentEntityMapper.selectComments(request);
    }

    @Override
    public Integer getUpvoteNum(Long zoneId) {
        return manSimpleUpvoteEntityMapper.queryUpvoteList(zoneId).size();
    }

    @Override
    public Long favorite(Long userId, Long zoneId) {
        ManSimpleFavoriteEntity entity = new ManSimpleFavoriteEntity();
        entity.setUserId(userId);
        entity.setZoneId(zoneId);
        entity.setFavoriteTime(new Date());
        entity.setYn(YnEnum.YES.getCode());
        manSimpleFavoriteEntityMapper.insertSelective(entity);
        return entity.getId();
    }

    @Override
    public Integer cancelFavorite(Long userId, Long zoneId) {
        ManSimpleFavoriteEntity entity = new ManSimpleFavoriteEntity();
        entity.setUserId(userId);
        entity.setZoneId(zoneId);
        entity.setYn(YnEnum.NO.getCode());
        return manSimpleFavoriteEntityMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<ManSimpleZoneEntity> queryFavoriteList(FavoriteEntityRequest request) {
        List<ManSimpleFavoriteEntity> result = manSimpleFavoriteEntityMapper.queryFavoriteList(request.getUserId());
        List<ManSimpleZoneEntity> zones = new ArrayList<>();
        ManSimpleZoneEntity zone;
        for(ManSimpleFavoriteEntity entity : result) {
            zone = manSimpleZoneEntityMapper.selectByPrimaryKey(entity.getZoneId());
            zones.add(zone);
        }
        return zones;
    }
}
