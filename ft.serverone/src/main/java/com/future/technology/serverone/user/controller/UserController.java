package com.future.technology.serverone.user.controller;


import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.user.domain.User;
import com.future.technology.serverone.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Response addAccount(@RequestBody User user){
        return userService.addAccount(user);
    }
}
