package com.future.technology.serverone.operation.controller;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.operation.domain.BCustomer;
import com.future.technology.serverone.operation.domain.Banner;
import com.future.technology.serverone.operation.service.IBannerWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
@Api("主页banner模块")
@RestController
public class BannerWebController {
    @Autowired
    private IBannerWebService bannerWebService;

    @ApiOperation("获取banner列表")
    @GetMapping("/banner/list")
    public Response<List<BCustomer>> getBannerList(){
        return bannerWebService.getBannerList();
    }
}
