package com.future.technology.serverone.user.controller;


import com.future.technology.serverone.user.domain.User;
import com.future.technology.serverone.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周乐乐
 * 创建时间：2016年10月17日
 * 创建说明：用户登录Controller
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;
    /**
     * 用户登陆
     * @return 用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User userLogin() {
        return userService.userLogin();
    }
}