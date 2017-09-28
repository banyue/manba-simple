package com.manba.simple.facade;

import com.manba.simple.api.OpenZoneService;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.ZoneRequest;
import com.manba.simple.domain.response.CommentInfo;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.UserInfoResponse;
import com.manba.simple.domain.response.ZoneResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijin on 2017/9/28.
 */
@Service
public class OpenZoneServiceImpl implements OpenZoneService {



    public ServiceResponse<PageBean<ZoneResponse>> queryZoneList(ZoneRequest request) {
        return null;
    }

    public ServiceResponse<ZoneResponse> queryZoneDetail(ZoneRequest request) {
        return null;
    }

    public ServiceResponse<Boolean> follow() {
        return null;
    }

    public ServiceResponse<UserInfoResponse> followList() {
        return null;
    }

    public ServiceResponse<Boolean> upvote() {
        return null;
    }

    public ServiceResponse<UserInfoResponse> upvoteList() {
        return null;
    }

    public ServiceResponse<Long> comment() {
        return null;
    }

    public ServiceResponse<Long> applyComment() {
        return null;
    }

    public ServiceResponse<PageBean<CommentInfo>> queryCommentList() {
        return null;
    }

    public ServiceResponse<List<String>> photoList() {
        return null;
    }

    public ServiceResponse<Integer> getUpvoteNum() {
        return null;
    }

    public ServiceResponse<Integer> getFollowNum() {
        return null;
    }
}
