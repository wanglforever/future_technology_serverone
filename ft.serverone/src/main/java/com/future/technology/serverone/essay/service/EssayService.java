package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.common.EssayStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.essay.dao.EssayMapper;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.EssayCustomer;
import com.future.technology.serverone.essay.domain.PageBean;
import com.future.technology.serverone.essay.domain.QueryInfo;
import com.future.technology.serverone.utils.GetDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                if (record == 1) {
                    return new Response<>(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_101);
                } else {
                    return new Response<>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_100, EssayStatus.ESSAYMES_102);
                }
            } catch (Exception excp) {
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
        if (essay_id != null && essay_id != 0) {
            try {
                int record = essayMapper.deletEssay(essay_id);
                if (record == 1) {
                    return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_201);
                } else {
                    return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_202);
                }
            } catch (Exception excp) {
                return new Response(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_203);
            }
        } else {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_205);
        }

    }

    @Override
    public Response batchDeleteEssay(List<Long> list) {
        if (list != null || list.size() != 0) {
            try {
                int size = list.size();
                if (size == essayMapper.batchDeleteEssay(list)) {
                    return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_201);
                } else {
                    return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_200, EssayStatus.ESSAYMES_202);
                }
            } catch (Exception excp) {
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
                essay.setEssay_modtime(date);
                if (1 == essayMapper.editorEssay(essay)) {
                    return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_301);
                } else {
                    return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_302);
                }
            } catch (Exception excp) {
                return new Response(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_303);
            }
        } else if (essay.getEssay_title() != null && essay.getEssay_title().trim().equals("")) {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_307);
        } else {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_308);
        }
    }

    @Override
    public Response downline(Integer essay_id) {
        if (essay_id != null) {
            try {
                if (1 == essayMapper.downline(essay_id)) {
                    return new Response(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_304);
                } else {
                    return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_305);
                }
            } catch (Exception excp) {
                return new Response(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_306);
            }
        }else {
            return new Response(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_300, EssayStatus.ESSAYMES_309);
        }
    }

    @Override
    public Response<PageBean> queryEssay(QueryInfo queryInfo) {
        if (queryInfo != null) {
            try {
                PageBean pageBean = new PageBean();
                queryInfo.setStartRecord((pageBean.getCurrentPage()-1) * pageBean.getCurrentCount() * 1l);
                queryInfo.setEndRecord(pageBean.getCurrentCount() * 1l);
                List<EssayCustomer> essays = essayMapper.queryEssay(queryInfo);

                if (essays != null &&essays.size() != 0) {
                    pageBean.setTotalCount(essays.size());
                    pageBean.setTotalPage((int) Math.ceil(essays.size() * 1.0 / pageBean.getCurrentCount()));
                    pageBean.setInfoList(essays);
                    return new Response<PageBean>(ResponseStatus.SUCCESS,EssayStatus.ESSAYCOD_400,EssayStatus.ESSAYMES_401,pageBean);
                } else {
                    return new Response<>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_402);
                }
            } catch (Exception excp) {
                return new Response<>(ResponseStatus.ERROR, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_403);
            }
        } else {
            return new Response<>(ResponseStatus.FAIL,EssayStatus.ESSAYCOD_400,EssayStatus.ESSAYMES_404);
        }
    }
}
