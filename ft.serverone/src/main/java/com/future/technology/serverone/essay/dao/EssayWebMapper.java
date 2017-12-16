package com.future.technology.serverone.essay.dao;

import com.future.technology.serverone.essay.domain.Essay;
import com.future.technology.serverone.essay.domain.EssayCustomer;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
public interface EssayWebMapper {
    List<EssayCustomer> getEssayList();
    EssayCustomer getEssayDetail(Long id);
}
