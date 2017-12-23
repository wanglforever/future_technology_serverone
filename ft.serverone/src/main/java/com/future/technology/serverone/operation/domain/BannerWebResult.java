package com.future.technology.serverone.operation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangl
 * Date: 2017/12/22
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Getter
@Setter
@Builder
public class BannerWebResult {
    /**
     * 滚动banner列表
     */
    private List<Banner> scrollBannerList;
    /**
     * 新闻热点固定位置banner列表
     */
    private List<Banner> fixedBannerList;
}
