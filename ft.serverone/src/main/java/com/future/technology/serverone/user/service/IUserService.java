package com.future.technology.serverone.user.service;

import com.future.technology.serverone.user.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User userLogin();
}
