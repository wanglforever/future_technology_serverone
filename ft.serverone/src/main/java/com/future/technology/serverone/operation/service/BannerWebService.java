package com.future.technology.serverone.operation.service;

import com.future.technology.serverone.common.BannerStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.operation.dao.BannerWebMapper;
import com.future.technology.serverone.operation.domain.BCustomer;
import com.future.technology.serverone.operation.domain.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by three on 2017/12/16.
 */
@Service
@Transactional
public class BannerWebService implements IBannerWebService {
    @Autowired
    private BannerWebMapper bannerWebMapper;

    @Override
    public Response<List<BCustomer>> getBannerList() {
        List<BCustomer> bannerList =  bannerWebMapper.getBannerList();
        if(bannerList.size() >0)
            return new Response<List<BCustomer>>(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_QUERY,BannerStatus.BANNERMSG_Q041,bannerList);
        return new Response<List<BCustomer>>(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_QUERY,BannerStatus.BANNERMSG_Q042,null);
    }
}
