package com.future.technology.serverone.user.dao;


import com.future.technology.serverone.user.domain.User;

/**
 * @author 周乐乐
 * 创建时间：2016/9/13
 * 创建原因：用户信息访问接口
 */
public interface IUserInfoDao {
    /**
     * 通过用户名获取用户user信息
     * @param username 用户手机号
     * @return 用户安全验证信息
     */;
    User queryUserByUsername(String username);

}
