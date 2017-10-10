package com.manba.simple.controller;

import com.manba.simple.api.OpenZoneService;
import com.manba.simple.domain.page.PageBean;
import com.manba.simple.domain.request.PublishZoneRequest;
import com.manba.simple.domain.request.ZoneRequest;
import com.manba.simple.domain.response.ServiceResponse;
import com.manba.simple.domain.response.ZoneResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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

    @ApiOperation("获取动态详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ServiceResponse<ZoneResponse> zoneDetail(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<ZoneResponse> response = openZoneService.queryZoneDetail(request);
        return response;
    }

    @ApiOperation("发布动态")
    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public ServiceResponse<Integer> publishZone(PublishZoneRequest request) {
        ServiceResponse<Integer> response = openZoneService.publishZone(request);
        return response;
    }

    @ApiOperation("删除动态")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ServiceResponse<Integer> deleteZone(@PathVariable String id) {
        ZoneRequest request = new ZoneRequest();
        request.setZoneId(id);
        ServiceResponse<Integer> response = openZoneService.deleteZone(request);
        return response;
    }
}
