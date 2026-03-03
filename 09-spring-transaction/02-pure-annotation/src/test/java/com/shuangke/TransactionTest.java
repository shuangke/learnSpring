package com.shuangke;

import com.shuangke.config.UserConfig;
import com.shuangke.pojo.User;
import com.shuangke.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(UserConfig.class)
public class TransactionTest {
    @Autowired
    private UserService userService;

    @Test
    public void testInsertUserAndShowAllUsers() {
        User zhangsan = User.builder().username("Tom")
                .email("Tom@gmail.com")
                .score(91.5)
                .build();
        int count = userService.insertUserAndShowAllUsers(zhangsan);
    }
}
