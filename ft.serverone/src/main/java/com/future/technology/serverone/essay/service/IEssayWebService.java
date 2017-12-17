package com.future.technology.serverone.essay.service;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.essay.domain.EssayCustomer;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
public interface IEssayWebService {
    Response<List<EssayCustomer>> getEssayList();
    Response<EssayCustomer> getEssayDetail(Long id);
}
