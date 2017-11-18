package com.future.technology.serverone.user.dao;


import com.future.technology.serverone.user.domain.User;

public interface IUserInfoDao {
    /**
     * 通过用户名获取用户user信息
     * @param username 用户手机号
     * @return 用户安全验证信息
     */;
    User queryUserByUsername(String username);

}
