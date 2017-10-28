package com.manba.simple.service.inner;

import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.inside.UserEntityRequest;

import java.util.List;

/**
 * Created by lijin on 2017/10/28.
 */
public interface UserInnerService {

    /**
     * 分页查询用户信息
     * @param request
     * @return
     */
    List<ManSimpleUserEntity> queryUserListPage(UserEntityRequest request);

}
