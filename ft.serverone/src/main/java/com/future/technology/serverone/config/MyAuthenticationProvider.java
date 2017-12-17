package com.future.technology.serverone.config;

import com.future.technology.serverone.user.domain.User;
import com.future.technology.serverone.user.service.IUserService;
import com.future.technology.serverone.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangl
 * Date: 2017/10/30
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private IUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = User.class.cast(userService.loadUserByUsername(username));
        if(user == null){
            throw new BadCredentialsException("Username not found.");
        }


        //加密过程在这里体现
        if (!MD5Util.encode(password).equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getAccountRole());
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList();
        authorities.add(authority);
        user.setAuthorities(authorities);
        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
