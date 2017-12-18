package com.future.technology.serverone.operation.controller;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.operation.domain.BQueryInfo;
import com.future.technology.serverone.operation.domain.Banner;
import com.future.technology.serverone.operation.service.IBannerService;
import com.future.technology.serverone.utils.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by three on 2017/12/5.
 */
@Api("后台管理系统banner模块")
@RestController
public class BannerController {
    @Autowired
    private IBannerService bannerService;

    @ApiOperation("保存banner")
    @PostMapping("/banner/save")
    public Response saveBanner(@RequestBody Banner banner) {
        return bannerService.saveBanner(banner);
    }

    @DeleteMapping("/banner/delete")
    public Response deleteBanner(@RequestParam Long bannerId) {
        return bannerService.deleteBanner(bannerId);
    }

    @DeleteMapping("/banner/bathDelete")
    public Response bathDeleteBanner(@RequestParam List<Long> bannerIdList) {
        return bannerService.bathDeleteBanner(bannerIdList);
    }

    @PutMapping("/banner/editor")
    public Response editorBanner(@RequestBody Banner banner) {
        return bannerService.editorBanner(banner);
    }

    @PutMapping("/banner/downline")
    public Response editorBanner(@RequestParam Long bannerId){
        return bannerService.editorLineBanner(bannerId);
    }

    @PostMapping("/banner/query")
    public Response<PageBean> queryBanner(@RequestBody BQueryInfo bQueryInfo) {
        return bannerService.queryBanner(bQueryInfo);
    }
}