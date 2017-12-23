package com.future.technology.serverone.operation.dao;

import com.future.technology.serverone.operation.domain.BCustomer;
import com.future.technology.serverone.operation.domain.BQueryInfo;
import com.future.technology.serverone.operation.domain.Banner;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * Created by three on 2017/12/5.
 */
public interface BannerMapper {
    List<Banner> queryBannerByTitle(String banner_name);

    int saveBanner(Banner banner);

    int deleteBanner(Long bannerId);

    int bathDeleteBanner(List<Long> bannerIdList);

    int editorBanner(Banner banner);

    Banner queryBannerById(Long bannerId);

    int editorBannerLine(Banner banner);

    List<BCustomer> queryBanner(BQueryInfo bQueryInfo);

    List<Banner> queryOtherBanners(Long banner_id);

    Integer queryBannerCount(BQueryInfo bQueryInfo);

    List<BCustomer> queryBannerWithNoCondition(BQueryInfo bQueryInfo);

    @Select("select count(*) from banner where banner_id = #{id} and banner_name = #{name};")
    int countBannerById(@Param("id") long id, @Param("name") String name);
}
