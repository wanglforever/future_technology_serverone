package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.common.EssayStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.essay.dao.EssayWebMapper;
import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.EssayCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
@Service
@Transactional
public class EssayWebService implements IEssayWebService {
    @Autowired
    private EssayWebMapper essayWebMapper;

    @Override
    public Response<List<EssayCustomer>> getEssayList() {
        List<EssayCustomer> essayList = essayWebMapper.getEssayList();
        if(essayList.size()>0)
            return new Response<List<EssayCustomer>>(ResponseStatus.SUCCESS, EssayStatus.ESSAYCOD_400,EssayStatus.ESSAYMES_401,essayList);
        return new Response<List<EssayCustomer>>(ResponseStatus.FAIL,EssayStatus.ESSAYCOD_400,EssayStatus.ESSAYMES_402,null);
    }

    @Override
    public Response<EssayCustomer> getEssayDetail(Long id) {
        if(id == null)
            return new Response<EssayCustomer>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_404, null);
        if(id == 0l)
            return new Response<EssayCustomer>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_404, null);

        EssayCustomer essayDetail = essayWebMapper.getEssayDetail(id);
        if(essayDetail != null)
            return new Response<EssayCustomer>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_401, essayDetail);
        return new Response<EssayCustomer>(ResponseStatus.FAIL, EssayStatus.ESSAYCOD_400, EssayStatus.ESSAYMES_402, essayDetail);
    }
}
