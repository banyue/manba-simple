package com.manba.simple.service.open;

import com.manba.simple.domain.entity.ManSimpleGuildEntity;
import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.inside.GuildEntityRequest;
import com.manba.simple.domain.inside.GuildUserEntityRequest;

import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
public interface GuildService {

    /**
     * 公会列表
     * @param request
     * @return
     */
    List<ManSimpleGuildEntity> selectGuildList(GuildEntityRequest request);

    /**
     * 创建公会
     * @param entity
     * @return
     */
    Long createGuild(ManSimpleGuildEntity entity);

    /**
     * 根据ID查询公会
     * @param id
     * @return
     */
    ManSimpleGuildEntity selectOneGuild(Long id);

    /**
     * 加入公会
     * @param userId
     * @param guildId
     * @return
     */
    Long addGuild(Long userId, Long guildId);

    /**
     * 退出公会
     * @param userId
     * @param guildId
     * @return
     */
    Integer quitGuild(Long userId, Long guildId);

    /**
     * 查询公会成员
     * @param request
     * @return
     */
    List<ManSimpleUserEntity> queryGuildMember(GuildUserEntityRequest request);

    /**
     * 更新公会头像
     * @param entity
     * @return
     */
    Integer uploadGuildPhotoAndSaveAlbum(ManSimpleGuildEntity entity);
}
