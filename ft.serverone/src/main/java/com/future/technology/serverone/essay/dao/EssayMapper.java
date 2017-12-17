package com.future.technology.serverone.essay.dao;

import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.EssayCustomer;
import com.future.technology.serverone.essay.domain.QueryInfo;

import java.util.List;

/**
 * Created by three on 2017/12/1.
 */
public interface EssayMapper {

    Essay getEssayByTitle(String essay_title);

    int saveEssay(Essay essay);

    int deletEssay(Long essay_id);

    int batchDeleteEssay(List<Long> list);

    int editorEssay(Essay essay);

    int downline(Essay essay);

    List<EssayCustomer> queryEssay(QueryInfo queryInfo);

    Essay queryEssayById(Long essay_id);

    int queryAllCount(QueryInfo queryInfo);
}
