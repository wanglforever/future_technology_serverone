package com.future.technology.serverone.user.service;


import com.future.technology.serverone.user.dao.IUserInfoDao;
import com.future.technology.serverone.user.domain.User;
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
            String role = user.getAuthorities().size() == 0 ? "" : user.getAuthorities().get(0).toString();
            switch (role) {
                case "ROLE_SYS_ADMIN": //系统管理员
                    log.info("系统管理员登陆");
            }
        }catch  (ClassCastException e) {
            throw new UsernameNotFoundException("用户未登录");
        }
        return user;
    }
}
