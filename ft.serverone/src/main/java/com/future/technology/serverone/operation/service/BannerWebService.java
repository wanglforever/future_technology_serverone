package com.future.technology.serverone.operation.service;

import com.future.technology.serverone.common.BannerStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.operation.dao.BannerWebMapper;
import com.future.technology.serverone.operation.domain.BCustomer;
import com.future.technology.serverone.operation.domain.Banner;
import com.future.technology.serverone.operation.domain.BannerWebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by three on 2017/12/16.
 */
@Service
@Transactional
public class BannerWebService implements IBannerWebService {
    @Autowired
    private BannerWebMapper bannerWebMapper;

    @Override
    public Response getBannerList() {
        List<Banner> bannerList = Optional.ofNullable(bannerWebMapper.getBannerList())
                .orElse(new ArrayList<>());
        BannerWebResult result = BannerWebResult.builder()
                .scrollBannerList(bannerList.stream().filter(b->isScroll(b)).collect(Collectors.toList()))
                .fixedBannerList(bannerList.stream().filter(b->!isScroll(b)).collect(Collectors.toList()))
                .build();
        return new Response(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_QUERY,BannerStatus.BANNERMSG_Q041,result);
    }

    private boolean isScroll(Banner banner){
        return banner.getBposition_id().equals(1) ||
                banner.getBposition_id().equals(2) ||
                banner.getBposition_id().equals(3);
    }
}
