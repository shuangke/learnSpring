package com.shuangke;

import com.shuangke.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void testUpdateAndSelectAllUsers() {
        userService.updateUserScoreAndSelectAllUsers(1, 120.0);
    }
}
