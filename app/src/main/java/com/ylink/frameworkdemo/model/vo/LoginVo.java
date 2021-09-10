package com.ylink.frameworkdemo.model.vo;


import java.io.Serializable;

/**
 * 登陆vo
 *
 * @author twilight
 * @Time 2020-01-14
 */

public class LoginVo implements Serializable {
    private String password;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
