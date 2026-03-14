package com.shuangke;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService implements InitializingBean, DisposableBean {
    @Value("defaultUser")
    private String userName;
    @Value("default.@gmail.com")
    private String email;
    private String serviceName;

    public void UserService() {}

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("------UserService bean init() starts-------------");
        System.out.println("the user before init: " + this);
        userName = "shuangke";
        email = "shuangke.@gmail.com";
        System.out.println("------UserService bean init() ends-------------");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("------ UserService Bean destroy()-------------");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                "serviceName='" + serviceName + '\'' +
                '}';
    }
}
