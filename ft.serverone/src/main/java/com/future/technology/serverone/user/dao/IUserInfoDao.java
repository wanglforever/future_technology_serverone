package com.future.technology.serverone.user.dao;


import com.future.technology.serverone.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IUserInfoDao {
    /**
     * 通过用户名获取用户user信息
     */;
     @Select("SELECT\n" +
             "        userName,\n" +
             "        password,\n" +
             "        accountName,\n" +
             "        accountRole\n" +
             "        FROM account_user\n" +
             "        WHERE userName = #{userName}")
    User queryUserByUsername(@Param("userName") String username);


    void addAccount(@Param("user") User user);
}
