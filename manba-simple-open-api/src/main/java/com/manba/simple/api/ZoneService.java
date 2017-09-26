package com.manba.simple.api;

import com.manba.simple.domain.request.ZoneRequest;
import com.manba.simple.domain.response.CommentInfo;
import com.manba.simple.domain.response.PageBean;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.ZoneResponse;

/**
 * 动态对外服务接口
 * Created by lijin on 2017/9/26.
 */
public interface ZoneService {

    /**
     * 分页查询动态列表
     * @param request
     * @return
     */
    ServiceResponse<PageBean<ZoneResponse>> queryZoneList(ZoneRequest request);

    /**
     * 查询动态详情
     * @param request
     * @return
     */
    ServiceResponse<ZoneResponse> queryZoneDetail(ZoneRequest request);

    /**
     * 关注某人
     * @return
     */
    ServiceResponse<Boolean> follow();

    /**
     * 点赞某条动态
     * @return
     */
    ServiceResponse<Boolean> upvote();

    /**
     * 点赞列表
     * @return
     */
    ServiceResponse<Boolean> upvoteList();

    /**
     * 评论动态
     * @return
     */
    ServiceResponse<Boolean> comment();

    /**
     * 回复评论
     * @return
     */
    ServiceResponse<Boolean> applyComment();

    /**
     * 查询评论列表
     * @return
     */
    ServiceResponse<PageBean<CommentInfo>> queryCommentList();
}
