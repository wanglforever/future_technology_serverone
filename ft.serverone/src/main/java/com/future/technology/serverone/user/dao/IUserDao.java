package com.future.technology.serverone.user.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 周乐乐
 * 创建时间：2016/9/13 11:00
 * 创建原因：用户访问接口
 * 任务号：IOTBEDSIDE-368
 */
public interface IUserDao {
    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    List<Integer> queryUserIdByUserName(String username);
    /**
     * 获取单个用户的角色列表
     * @param userId 安全账户Id
     * @return 该用户角色列表
     */
    List<Integer> getRolesOfUser(@Param("userId") String userId);
}
