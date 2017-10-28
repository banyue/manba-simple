package com.manba.simple.inner.api;

import com.manba.simple.common.domain.PageBean;
import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.inner.domain.request.UserInnerRequest;
import com.manba.simple.inner.domain.response.UserInnerRespone;

/**
 * Created by lijin on 2017/10/28.
 * 用户后台service接口
 */
public interface InnerUserService {

    /**
     * 查询用户列表
     * @param request
     * @return
     */
    ServiceResponse<PageBean<UserInnerRespone>> queryUserList(UserInnerRequest request);

}
