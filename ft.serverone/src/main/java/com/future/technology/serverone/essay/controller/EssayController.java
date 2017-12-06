package com.future.technology.serverone.essay.controller;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.QueryInfo;
import com.future.technology.serverone.essay.service.IEssayService;
import com.future.technology.serverone.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by three on 2017/12/1.
 */
@RestController
public class EssayController {
    @Autowired
    private IEssayService essayService;

    // 新增文章内容
    @PostMapping(value = "/essay/save", produces = "application/json; charset=utf-8")
    public Response essaySave(@RequestBody Essay essay) {
        return essayService.saveEssay(essay);
    }

    // 删除文章
    @DeleteMapping(value = "/essay/delete" ,produces = "application/json; charset=utf-8")
    public Response deleteEssay(@RequestParam Long id ) {
        return essayService.deletEssay(id);
    }

    // 批量删除文章
    @DeleteMapping(value = "/essay/bathDelete", produces = "application/json; charset=utf-8")
    public Response batchDeleteEssay(@RequestParam List<Long> idList) {
        return essayService.batchDeleteEssay(idList);
    }

    // 编辑文章
    @PutMapping(value = "/essay/editor",produces = "application/json; charset=utf-8")
    public Response editorEssay(@RequestBody Essay essay) {
        return essayService.updateEssay(essay);
    }

    // 文章下线
    @PutMapping(value = "/essay/downline", produces = "application/json; charset=utf-8")
    public Response downLine(@RequestParam Long id) {
        return essayService.downline(id);
    }

    // 查询文章
    @PostMapping(value = "/essay/query",produces = "application/json; charset=utf-8")
    public Response<PageBean> queryEssay(@RequestBody QueryInfo queryInfo){
        return essayService.queryEssay(queryInfo);
    }
}
