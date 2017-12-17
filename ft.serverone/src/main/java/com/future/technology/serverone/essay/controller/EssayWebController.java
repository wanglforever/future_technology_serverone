package com.future.technology.serverone.essay.controller;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.EssayCustomer;
import com.future.technology.serverone.essay.service.IEssayService;
import com.future.technology.serverone.essay.service.IEssayWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
@RestController
public class EssayWebController {
    @Autowired
    private IEssayWebService essayWebService;
    @PostMapping("/essay/list")
    public Response<List<EssayCustomer>> getEssayList() {
        return essayWebService.getEssayList();
    }

    @PostMapping("/essay/detail")
    public Response<EssayCustomer> getEssayDetail(@RequestParam Long id){
        return essayWebService.getEssayDetail(id);
    }
}
