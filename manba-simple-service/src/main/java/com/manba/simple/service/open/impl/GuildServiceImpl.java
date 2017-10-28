package com.manba.simple.service.open.impl;

import com.manba.simple.common.util.StringUtil;
import com.manba.simple.domain.constant.BusiTypeEnum;
import com.manba.simple.domain.constant.YnEnum;
import com.manba.simple.domain.entity.ManSimpleGuildEntity;
import com.manba.simple.domain.entity.ManSimpleGuildUserEntity;
import com.manba.simple.domain.entity.ManSimplePhotoEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.inside.GuildEntityRequest;
import com.manba.simple.domain.inside.GuildUserEntityRequest;
import com.manba.simple.mapper.ManSimpleGuildEntityMapper;
import com.manba.simple.mapper.ManSimpleGuildUserEntityMapper;
import com.manba.simple.mapper.ManSimplePhotoEntityMapper;
import com.manba.simple.mapper.ManSimpleUserEntityMapper;
import com.manba.simple.service.open.GuildService;
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
public class GuildServiceImpl implements GuildService {

    @Resource
    ManSimpleGuildEntityMapper manSimpleGuildEntityMapper;
    @Resource
    ManSimpleGuildUserEntityMapper manSimpleGuildUserEntityMapper;
    @Resource
    ManSimpleUserEntityMapper manSimpleUserEntityMapper;
    @Resource
    ManSimplePhotoEntityMapper manSimplePhotoEntityMapper;

    @Override
    public List<ManSimpleGuildEntity> selectGuildList(GuildEntityRequest request) {
        return manSimpleGuildEntityMapper.selectGuildList(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createGuild(ManSimpleGuildEntity entity) {
        manSimpleGuildEntityMapper.insertSelective(entity);
        //保存相册
        if(StringUtil.isEmpty(entity.getGuildPhoto())) {
            ManSimplePhotoEntity photoEntity = new ManSimplePhotoEntity();
            photoEntity.setCreateTime(new Date());
            photoEntity.setUserId(entity.getCreateUser());
            photoEntity.setPhotoPath(entity.getGuildPhoto());
            photoEntity.setYn(YnEnum.YES.getCode());
            photoEntity.setBusiType(BusiTypeEnum.GUILD.getCode());
            manSimplePhotoEntityMapper.insertSelective(photoEntity);
        }
        return entity.getId();
    }

    @Override
    public ManSimpleGuildEntity selectOneGuild(Long id) {
        return manSimpleGuildEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long addGuild(Long userId, Long guildId) {
        ManSimpleGuildUserEntity guildUserEntity = new ManSimpleGuildUserEntity();
        guildUserEntity.setUserId(userId);
        guildUserEntity.setGuildId(guildId);
        guildUserEntity.setCreateTime(new Date());
        guildUserEntity.setYn(YnEnum.YES.getCode());
        manSimpleGuildUserEntityMapper.insertSelective(guildUserEntity);
        return guildUserEntity.getId();
    }

    @Override
    public Integer quitGuild(Long userId, Long guildId) {
        ManSimpleGuildUserEntity entity = new ManSimpleGuildUserEntity();
        entity.setUserId(userId);
        entity.setGuildId(guildId);
        entity.setYn(YnEnum.NO.getCode());
        return manSimpleGuildUserEntityMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<ManSimpleUserEntity> queryGuildMember(GuildUserEntityRequest request) {
        List<ManSimpleGuildUserEntity> members = manSimpleGuildUserEntityMapper.queryGuildMember(request.getGuildId());
        List<ManSimpleUserEntity> result = new ArrayList<>();
        for(ManSimpleGuildUserEntity entity : members) {
            ManSimpleUserEntity user = manSimpleUserEntityMapper.selectByPrimaryKey(entity.getUserId());
            result.add(user);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer uploadGuildPhotoAndSaveAlbum(ManSimpleGuildEntity entity) {
        Integer r = manSimpleGuildEntityMapper.updateByPrimaryKeySelective(entity);
        //保存相册表
        if(r > 0) {
            ManSimplePhotoEntity photoEntity = new ManSimplePhotoEntity();
            photoEntity.setUserId(entity.getCreateUser());
            photoEntity.setPhotoPath(entity.getGuildPhoto());
            photoEntity.setCreateTime(new Date());
            photoEntity.setYn(YnEnum.YES.getCode());
            photoEntity.setBusiType(BusiTypeEnum.GUILD.getCode());
            ManSimplePhotoEntity one = manSimplePhotoEntityMapper.selectOnePhoto(photoEntity);
            if (null == one) {
                manSimplePhotoEntityMapper.insertSelective(photoEntity);
            } else {
                manSimplePhotoEntityMapper.updateByPrimaryKeySelective(photoEntity);
            }
        }
        return r;
    }
}
