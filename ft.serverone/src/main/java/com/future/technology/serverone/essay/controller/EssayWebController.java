package com.future.technology.serverone.essay.controller;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.EssayCustomer;
import com.future.technology.serverone.essay.service.IEssayService;
import com.future.technology.serverone.essay.service.IEssayWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
@Api("主页咨询动态，信息公告模块")
@RestController
public class EssayWebController {
    @Autowired
    private IEssayWebService essayWebService;

    @ApiOperation("获取所有咨询列表")
    @GetMapping("/essay/list")
    public Response<List<EssayCustomer>> getEssayList() {
        return essayWebService.getEssayList();
    }

    @ApiOperation("根据id获取资讯的内容")
    @GetMapping("/essay/detail")
    public Response<EssayCustomer> getEssayDetail(@RequestParam Long id){
        return essayWebService.getEssayDetail(id);
    }
}
