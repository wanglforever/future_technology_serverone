package com.future.technology.serverone.essay.controller;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.PageBean;
import com.future.technology.serverone.essay.domain.QueryInfo;
import com.future.technology.serverone.essay.service.IEssayService;
import com.future.technology.serverone.utils.GetDateUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by three on 2017/12/1.
 */
@RestController
public class EssayController {
    @Autowired
    private IEssayService essayService;

    // 新增文章内容
    @GetMapping("/essay_save")
    public Response essaySave(Essay essay) {
        Response<String> response = essayService.saveEssay(essay);
        return response;
    }

    // 删除文章
    @GetMapping("/essay_delete")
    public Response deleteEssay(@RequestParam(value = "id") String id) {
        return essayService.deletEssay(Long.valueOf(id));
    }

    // 批量删除文章
    @GetMapping("/essay_bath_delete")
    public Response batchDeleteEssay(@RequestParam(value = "id") String id) {
        String[] idArray = id.split(",");
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < idArray.length; i++) {
            idList.add(Long.valueOf(idArray[i]));
        }
        return essayService.batchDeleteEssay(idList);
    }

    // 编辑文章
    @GetMapping("/essay_editor")
    public Response editorEssay(Essay essay) {
        return essayService.updateEssay(essay);
    }

    // 文章下线
    @GetMapping("/essay_downline")
    public Response downLine(@RequestParam(value = "status_id") String status_id) {
        return essayService.downline(Integer.valueOf(status_id));
    }

    // 查询文章
    @GetMapping("/essay_query")
    public Response<PageBean> queryEssay(QueryInfo queryInfo){
        return essayService.queryEssay(queryInfo);
    }
}
