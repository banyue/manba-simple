package com.manba.simple.controller;

import com.manba.simple.api.OpenZoneService;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.ZoneRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.ZoneResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 动态相关网关接口
 * Created by lijin on 2017/9/28.
 */
@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Resource
    OpenZoneService openZoneService;

    @ApiOperation("获取动态列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServiceResponse<PageBean<ZoneResponse>> zoneList(ZoneRequest request) {
        ServiceResponse<PageBean<ZoneResponse>> response = openZoneService.queryZoneList(request);
        return response;
    }
}
