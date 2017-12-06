package com.future.technology.serverone.operation.service;

import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.operation.domain.BQueryInfo;
import com.future.technology.serverone.operation.domain.Banner;
import com.future.technology.serverone.utils.PageBean;

import java.util.List;

/**
 * Created by three on 2017/12/5.
 */
public interface IBannerService {
    Response saveBanner(Banner banner);

    Response deleteBanner(Long bannerId);

    Response bathDeleteBanner(List<Long> bannerIdList);

    Response editorBanner(Banner banner);

    Response editorLineBanner(Long bannerId);

    Response<PageBean> queryBanner(BQueryInfo bQueryInfo);
}
