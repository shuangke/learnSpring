package com.shuangke.service.impl;

import com.shuangke.dao.UserDao;
import com.shuangke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Transactional
    @Override
    public void updateUserScoreAndSelectAllUsers(Integer id, Double score) {
        int counts = userDao.updateUserScoreById(id, score);
        //stimulate an error to test transaction management
        int error = 1 / 0;
        if (counts > 0) {
            userDao.selectAllUsers().forEach(System.out::println);
        } else {
            System.out.println("更新失败");
        }
    }
}
