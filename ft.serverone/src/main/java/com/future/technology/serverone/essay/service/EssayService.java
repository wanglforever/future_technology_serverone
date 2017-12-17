package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.common.BannerStatus;
import com.future.technology.serverone.common.EssayStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.essay.dao.EssayMapper;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.EssayCustomer;
import com.future.technology.serverone.essay.domain.QueryInfo;
import com.future.technology.serverone.utils.GetDateUtil;
import com.future.technology.serverone.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by three on 2017/12/1.
 */
@Service
@Slf4j
public class EssayService implements IEssayService {

    @Autowired
    private EssayMapper essayMapper;

    @Override
    public Response<String> saveEssay(Essay essay) {
        if (essay == null)
            return new Response<>(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_102);
        if (essay.getEssay_title() != null &&
                !essay.getEssay_title().trim().equals("") &&
                essayMapper.getEssayByTitle(essay.getEssay_title()) == null) {
            String date = GetDateUtil.getDate();
            essay.setEssay_mktime(date);
            essay.setEssay_modtime(date);
            // 其他类别
            if (essay.getCatogory_id() == null)
                essay.setCatogory_id(0);
            if (essay.getStatus_id() == null)
                essay.setStatus_id(0);
            try {
                int record = essayMapper.saveEssay(essay);
                if (record > 0) {
                    return new Response<>(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_101);
                } else {
                    return new Response<>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_102);
                }
            } catch (Exception excp) {
                log.error("erro,{}",excp);
                return new Response<>(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_103);
            }
        } else if (essay.getEssay_title() != null &&
                essayMapper.getEssayByTitle(essay.getEssay_title()) != null) {
            return new Response<>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_105);
        } else {
            return new Response<>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_104);
        }
    }

    @Override
    public Response deletEssay(Long essay_id) {
        if (essay_id == null)
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_205);
        if (essay_id != 0) {
            try {
                int record = essayMapper.deletEssay(essay_id);
                if (record > 0) {
                    return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_201);
                } else {
                    return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_202);
                }
            } catch (Exception excp) {
                log.error("erro,{}",excp);
                return new Response(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_203);
            }
        } else {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_205);
        }
    }

    @Override
    public Response batchDeleteEssay(List<Long> list) {
        if (list != null && list.size() > 0) {
            try {
                int size = list.size();
                if (size == essayMapper.batchDeleteEssay(list)) {
                    return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_201);
                } else {
                    return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_202);
                }
            } catch (Exception excp) {
                log.error("erro,{}",excp);
                return new Response(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_203);
            }
        } else {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_205);
        }
    }

    @Override
    public Response updateEssay(Essay essay) {
        if (essay.getEssay_title() != null && !essay.getEssay_title().trim().equals("") &&
                essay.getEssay_content() != null && !essay.getEssay_content().trim().equals("")) {
            try {
                String date = GetDateUtil.getDate();

                if(essayMapper.hasDuplicateName(essay) > 0){
                    return new Response(ResponseStatus.FAIL,EssayStatus.ESSAYCOD_300,EssayStatus.ESSAYMES_105);
                }
                essay.setEssay_modtime(date);
                if (0 < essayMapper.editorEssay(essay)) {
                    return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_301);
                } else {
                    return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_302);
                }
            } catch (Exception excp) {
                log.error("erro,{}",excp);
                return new Response(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_303);
            }
        } else if (essay.getEssay_title() != null && essay.getEssay_title().trim().equals("")) {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_307);
        } else {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_308);
        }
    }

    @Override
    public Response downline(Long essay_id) {
        if (essay_id == null)
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_302);
        Essay essay = essayMapper.queryEssayById(essay_id);
        if(essay == null)
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_302);

        int record;
        if (essay.getStatus_id() == 0) {
            essay.setStatus_id(1);
            essay.setEssay_modtime(GetDateUtil.getDate());
            record = essayMapper.downline(essay);
        }else {
            essay.setStatus_id(0);
            essay.setEssay_modtime(GetDateUtil.getDate());
            record = essayMapper.downline(essay);
        }
        if(record > 0)
            return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_301);
        return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_302);

    }

    @Override
    public Response<PageBean> queryEssay(QueryInfo queryInfo) {
        if (queryInfo != null) {
            try {
                PageBean<EssayCustomer> pageBean = new PageBean();
                queryInfo.setOffset((queryInfo.getCurrentPage()-1) * queryInfo.getOffcount());
                List<EssayCustomer> essays = essayMapper.queryEssay(queryInfo);
                if(essays == null || essays.size() ==0)
                    return new Response<>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_402);
                else {
                    Integer totalCount = essayMapper.queryEssayCount(queryInfo);
                    pageBean.setCurrentPage(queryInfo.getCurrentPage());
                    pageBean.setTotalCount(totalCount);
                    pageBean.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageBean.getCurrentCount()));
                    pageBean.setInfoList(essays);
                    return new Response<PageBean>(ResponseStatus.SUCCESS,EssayStatus.ESSAYCOD_400,EssayStatus.ESSAYMES_401,pageBean);
                }
            } catch (Exception excp) {
                log.error("erro,{}",excp);
                return new Response<>(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_403);
            }
        } else {
            return new Response<>(ResponseStatus.FAIL,EssayStatus.ESSAYCOD_400,EssayStatus.ESSAYMES_404);
        }
    }
}
