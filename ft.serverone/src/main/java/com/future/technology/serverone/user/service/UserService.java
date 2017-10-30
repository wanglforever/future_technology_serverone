package com.future.technology.serverone.user.service;


import com.future.technology.serverone.user.dao.IUserDao;
import com.future.technology.serverone.user.dao.IUserInfoDao;
import com.future.technology.serverone.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 周乐乐
 * 创建时间：2016年9月13日10:37
 * 创建说明：用户Service
 */
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserInfoDao userInfoDao;
    @Autowired
    private IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user;
        if (StringUtils.isEmpty(userName)) {//用户名登陆
            user = userInfoDao.queryUserByUsername(userName);
        } else {
                throw new RuntimeException("用户不存在");
        }
        return new User();
    }
    public User userLogin() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String role = user.getAuthorities().size() == 0 ? "" : user.getAuthorities().get(0).toString();
            switch (role) {
                case "ROLE_SYS_ADMIN": //系统管理员
                case "ROLE_WARD_ADMIN": //病区管理员
            }
        }catch  (ClassCastException e) {
            throw new UsernameNotFoundException("用户未登录");
        }
        return user;
    }
}
