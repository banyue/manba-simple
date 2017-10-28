package com.manba.simple.service.inner.impl;

import com.manba.simple.domain.entity.ManSimpleUserEntity;
import com.manba.simple.domain.inside.UserEntityRequest;
import com.manba.simple.mapper.ManSimpleUserEntityMapper;
import com.manba.simple.service.inner.UserInnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lijin on 2017/10/28.
 */
@Service
public class UserInnerServiceImpl implements UserInnerService {

    @Resource
    ManSimpleUserEntityMapper manSimpleUserEntityMapper;

    @Override
    public List<ManSimpleUserEntity> queryUserListPage(UserEntityRequest request) {
        return manSimpleUserEntityMapper.queryUserListForPage(request);
    }
}
