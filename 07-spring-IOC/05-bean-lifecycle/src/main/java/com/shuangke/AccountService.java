package com.shuangke;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements InitializingBean, DisposableBean {
    @Value("defaultAccountName")
    private String accountName;
    @Value("defaultAccountOwner")
    private String accountOwner;

    public void AccountService() {}

    @Override
    public String toString() {
        return "AccountService{" +
                "accountName='" + accountName + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("------ AccountService Bean destroy()-------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("------AccountService bean init() starts-------------");
        System.out.println("the account before init: " + this);
        accountName = "shuangkeAccount";
        accountOwner = "shuangke";
        System.out.println("------AccountService bean init() ends -------------");

    }
}
