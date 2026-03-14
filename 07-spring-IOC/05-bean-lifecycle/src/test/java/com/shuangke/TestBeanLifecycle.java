package com.shuangke;

import com.shuangke.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = Config.class)
public class TestBeanLifecycle {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

     @Test
     public void testBeanLifecycle() {
         System.out.println(userService);
         System.out.println(accountService);
     }
}
