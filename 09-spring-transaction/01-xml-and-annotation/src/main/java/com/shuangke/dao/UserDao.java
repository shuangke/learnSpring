package com.shuangke.dao;

import com.shuangke.pojo.User;

import java.util.List;

public interface UserDao {
    int updateUserScoreById(Integer userId, Double score);
    int saveUser(User user);
    User selectUserById(Integer userId);
    List<User> selectAllUsers();
}
