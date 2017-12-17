package com.future.technology.serverone.operation.service;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.operation.domain.BCustomer;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
public interface IBannerWebService {
    Response<List<BCustomer>> getBannerList();
}
