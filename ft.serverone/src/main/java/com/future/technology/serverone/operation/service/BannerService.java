package com.future.technology.serverone.operation.service;

import com.future.technology.serverone.common.BannerStatus;
import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.operation.dao.BannerMapper;
import com.future.technology.serverone.operation.domain.BCustomer;
import com.future.technology.serverone.operation.domain.BQueryInfo;
import com.future.technology.serverone.operation.domain.Banner;
import com.future.technology.serverone.utils.GetDateUtil;
import com.future.technology.serverone.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by three on 2017/12/5.
 */
@Service
@Slf4j
@Transactional
public class BannerService implements IBannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public Response saveBanner(Banner banner) {
        if (banner == null)
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S016);
        if (StringUtils.isEmpty(banner.getBanner_name()))
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S013);
        if (StringUtils.isEmpty(banner.getBanner_title()))
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S017);
        if (StringUtils.isEmpty(banner.getBanner_content()))
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S018);
        if (bannerMapper.queryBannerByTitle(banner.getBanner_name()).size() > 0)
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S015);
        banner.setBanner_mktime(GetDateUtil.getDate());
        banner.setBanner_modtime(GetDateUtil.getDate());
        int record = bannerMapper.saveBanner(banner);
        if (record > 0)
            return new Response(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S011);
        return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S012);
    }

    @Override
    public Response deleteBanner(Long bannerId) {
        if (bannerId == null)
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_D023);
        int record = bannerMapper.deleteBanner(bannerId);
        if(record > 0)
            return new Response(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_DELETE, BannerStatus.BANNERMSG_D021);
        return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_DELETE, BannerStatus.BANNERMSG_D022);
    }

    @Override
    public Response bathDeleteBanner(List<Long> bannerIdList) {
        if (bannerIdList == null)
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_DELETE, BannerStatus.BANNERMSG_D023);
        int records = bannerMapper.bathDeleteBanner(bannerIdList);
        if( records == bannerIdList.size())
            return new Response(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_DELETE, BannerStatus.BANNERMSG_D021);
        return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_DELETE, BannerStatus.BANNERMSG_D022);
    }

    @Override
    public Response editorBanner(Banner banner) {
        if(banner == null)
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_EDITOR, BannerStatus.BANNERMSG_E033);
        if(StringUtils.isEmpty(banner.getBanner_name()))
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_EDITOR, BannerStatus.BANNERMSG_E035);
        if (StringUtils.isEmpty(banner.getBanner_title()))
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S017);
        if (StringUtils.isEmpty(banner.getBanner_content()))
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_SAVE, BannerStatus.BANNERMSG_S018);
        Banner bannerprevious = bannerMapper.queryBannerById(banner.getBanner_id());
        List<Banner> banners = bannerMapper.queryOtherBanners(banner.getBanner_id());
        for (int i = 0; i < banners.size(); i++) {
            Banner otherBanner =  banners.get(i);
            if(otherBanner.getBanner_name() == banner.getBanner_name())
                return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_EDITOR, BannerStatus.BANNERMSG_S015);
        }
        banner.setBanner_modtime(GetDateUtil.getDate());
        banner.setBanner_mktime(bannerprevious.getBanner_mktime());
        int record = bannerMapper.editorBanner(banner);
        if(record > 0)
            return new Response(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_EDITOR, BannerStatus.BANNERMSG_E031);
        return new Response(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_EDITOR, BannerStatus.BANNERMSG_E032);
    }

    @Override
    public Response editorLineBanner(Long bannerId) {
        if (bannerId == null)
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_LINE, BannerStatus.BANNERMSG_L053);
        Banner banner = bannerMapper.queryBannerById(bannerId);
        if(banner == null)
            new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_LINE, BannerStatus.BANNERMSG_L053);
        Integer bstatus_id = banner.getBstatus_id();
        banner.setBanner_modtime(GetDateUtil.getDate());
        int record;
        if (bstatus_id == 0) {
            banner.setBstatus_id(1);
            record = bannerMapper.editorBannerLine(banner);
        }else {
            banner.setBstatus_id(0);
            record = bannerMapper.editorBannerLine(banner);
        }
        if(record > 0)
            return new Response(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_LINE, BannerStatus.BANNERMSG_L051);
        return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_LINE, BannerStatus.BANNERMSG_L052);
    }

    @Override
    public Response<PageBean> queryBanner(BQueryInfo bQueryInfo) {
        if (bQueryInfo == null)
            return new Response(ResponseStatus.FAIL, BannerStatus.BANNERCOD_QUERY, BannerStatus.BANNERMSG_Q045);
        PageBean<BCustomer> pageBean = new PageBean<>();
        bQueryInfo.setOffset((pageBean.getCurrentPage()-1) * pageBean.getCurrentCount() * 1l);
        bQueryInfo.setOffcount(pageBean.getCurrentCount() * 1l);
        pageBean.setCurrentPage(bQueryInfo.getCurrentPage());
        List<BCustomer> records = bannerMapper.queryBanner(bQueryInfo);
        if(records == null)
            return new Response<PageBean>(ResponseStatus.FAIL, BannerStatus.BANNERCOD_QUERY, BannerStatus.BANNERMSG_Q042);
        if (records.size() > 0){
            pageBean.setInfoList(records);
            return new Response<PageBean>(ResponseStatus.SUCCESS, BannerStatus.BANNERCOD_QUERY, BannerStatus.BANNERMSG_Q041, pageBean);
        }
        return new Response<PageBean>(ResponseStatus.FAIL, BannerStatus.BANNERCOD_QUERY, BannerStatus.BANNERMSG_Q043,null);
    }
}
