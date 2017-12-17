package com.future.technology.serverone.user.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

@Setter
@Getter
public class User implements UserDetails {
    /**
     * 主键Id
     */
    private int id;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户权限
     */
    private String accountRole;

    /**
     * 用户性别
     */
    private String accountSex;

    /**
     * 用户出生日期
     */
    private String accountBirthday;

    /**
     * 用户毕业院校
     */
    private String accountGraduatedSchool;

    /**
     * 用户专业
     */
    private String accountProfession;

    /**
     * 用户毕业时间
     */
    private String accountGraduatedTime;

    /**
     * 用户学历
     */
    private String accountEducation;

    /**
     * 用户地址
     */
    private String accountAddress;

    /**
     * 用户邮箱
     */
    private String accountEmail;

    /**
     * 用户QQ号
     */
    private String accountQQNum;

    /**
     * 用户手机号
     */
    private String accountPhone;

    /**
     * 是否可用
     */
    private boolean enabled;
    /**
     * 账号没有过期
     */
    private boolean accountNonExpired;
    /**
     * 账号没有锁定
     */
    private boolean accountNonLocked;
    /**
     * 凭证没有过期
     */
    private boolean credentialsNonExpired;

    /**
     * 权限
     */
    private ArrayList<SimpleGrantedAuthority> authorities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public ArrayList<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(ArrayList<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(String accountRole) {
        this.accountRole = accountRole;
    }
}
