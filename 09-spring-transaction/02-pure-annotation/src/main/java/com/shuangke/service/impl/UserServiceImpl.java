package com.shuangke.service.impl;

import com.shuangke.dao.UserDao;
import com.shuangke.pojo.User;
import com.shuangke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public int insertUserAndShowAllUsers(User user) {
        int count = userDao.save(user);
        int error = 1 / 0; // 模拟一个异常，看看事务是否生效
        userDao.selectAll().forEach(System.out::println);
        return count;
    }
}
