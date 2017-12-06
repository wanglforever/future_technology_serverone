package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.QueryInfo;
import com.future.technology.serverone.utils.PageBean;

import java.util.List;

/**
 * Created by three on 2017/12/1.
 */

public interface IEssayService {
    Response saveEssay(Essay essay);

    Response deletEssay(Long essay_id);

    Response batchDeleteEssay(List<Long> list);

    Response updateEssay(Essay essay);

    Response downline(Long essay_id);

    Response<PageBean> queryEssay(QueryInfo queryInfo);


}
