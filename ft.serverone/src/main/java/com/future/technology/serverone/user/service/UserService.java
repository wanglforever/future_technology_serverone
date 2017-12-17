package com.future.technology.serverone.user.service;


import com.future.technology.serverone.common.Response;
import com.future.technology.serverone.common.ResponseStatus;
import com.future.technology.serverone.user.dao.IUserInfoDao;
import com.future.technology.serverone.user.domain.User;
import com.future.technology.serverone.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class UserService implements IUserService{
    @Autowired
    private IUserInfoDao userInfoDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user;
        if (!StringUtils.isEmpty(userName)) {//用户名登陆
            user = userInfoDao.queryUserByUsername(userName);
        } else {
                throw new RuntimeException("用户不存在");
        }
        return user;
    }
    public User userLogin() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String role = (user.getAuthorities() == null || user.getAuthorities().size() == 0) ? "" : user.getAuthorities().get(0).toString();
            switch (role) {
                case "ROLE_ADMIN": //系统管理员
                    log.info("系统管理员登陆");
            }
        }catch  (ClassCastException e) {
            log.error("error,{}",e);
            throw new UsernameNotFoundException("用户登录失败");
        }
        return user;
    }

    @Override
    public Response addAccount(User user) {
        if (user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            return new Response(ResponseStatus.FAIL,"400","用户注册参数异常");
        }
        if (userInfoDao.queryUserByUsername(user.getUsername()) != null){
            return new Response(ResponseStatus.FAIL,"400","该用户名已经被占用");
        }
        String password = MD5Util.encode(user.getPassword());
        user.setPassword(password);
        user.setAccountRole("ROLE_USER");
        userInfoDao.addAccount(user);
        return null;
    }
}
