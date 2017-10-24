package com.manba.simple.service.impl;

import com.manba.simple.domain.constant.YnEnum;
import com.manba.simple.domain.entity.ManSimpleGuildEntity;
import com.manba.simple.domain.entity.ManSimpleGuildUserEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.inside.GuildEntityRequest;
import com.manba.simple.domain.inside.GuildUserEntityRequest;
import com.manba.simple.mapper.ManSimpleGuildEntityMapper;
import com.manba.simple.mapper.ManSimpleGuildUserEntityMapper;
import com.manba.simple.mapper.ManSimpleUserEntityMapper;
import com.manba.simple.service.GuildService;
import org.springframework.stereotype.Service;

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

    @Override
    public List<ManSimpleGuildEntity> selectGuildList(GuildEntityRequest request) {
        return manSimpleGuildEntityMapper.selectGuildList(request);
    }

    @Override
    public Long createGuild(ManSimpleGuildEntity entity) {
        manSimpleGuildEntityMapper.insertSelective(entity);
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
}
