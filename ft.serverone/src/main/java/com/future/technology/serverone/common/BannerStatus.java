package com.future.technology.serverone.common;

import lombok.Data;

/**
 * Created by three on 2017/12/5.
 */
public interface BannerStatus {
    String BANNERCOD_SAVE = "s_010";
    String BANNERCOD_DELETE = "d_020";
    String BANNERCOD_EDITOR = "e_030";
    String BANNERCOD_QUERY = "q_040";
    String BANNERCOD_LINE = "q_050";

    String BANNERMSG_S011 = "保存成功";
    String BANNERMSG_S012 = "保存失败";
    String BANNERMSG_S017 = "名字为空";
    String BANNERMSG_S018 = "标题为空";
    String BANNERMSG_S013 = "内容为空";
    String BANNERMSG_S015 = "已经存在";
    String BANNERMSG_S014 = "保存出错";
    String BANNERMSG_S016 = "banner为空";

    String BANNERMSG_D021 = "删除成功";
    String BANNERMSG_D022 = "删除失败";
    String BANNERMSG_D023 = "主键为空";
    String BANNERMSG_D024 = "删除出错";

    String BANNERMSG_E031 = "修改成功";
    String BANNERMSG_E032 = "修改失败";
    String BANNERMSG_E033 = "主键为空";
    String BANNERMSG_E035 = "标题为空";
    String BANNERMSG_E034 = "修改出错";

    String BANNERMSG_Q041 = "查询成功";
    String BANNERMSG_Q042 = "查询失败";
    String BANNERMSG_Q043 = "查询为空";
    String BANNERMSG_Q044 = "查询出错";
    String BANNERMSG_Q045 = "banner为空";

    String BANNERMSG_L051 = "上下成功";
    String BANNERMSG_L052 = "上下失败";
    String BANNERMSG_L053 = "主键为空";
    String BANNERMSG_L054 = "上下出错";
}
