package com.future.technology.serverone.user.service;

import com.future.technology.serverone.user.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author 周乐乐
 * 创建时间：2016年9月13日10:37
 * 创建说明：用户接口
 */
public interface IUserService extends UserDetailsService {
    User userLogin();
}
