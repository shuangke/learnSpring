package com.shuangke.dao;

import com.shuangke.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(User user) {
        String sql = "INSERT INTO t_users VALUES (NULL, ?, ?, ?)";
        int count = jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getScore());
        return count;
    }

    public List<User> selectAll() {
        String sql = "SELECT * FROM t_users";
        List<User> userList = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            User user = User.builder().id(resultSet.getInt("id"))
                    .username(resultSet.getString("username"))
                    .email(resultSet.getString("email"))
                    .score(resultSet.getDouble("score"))
                    .build();
            return user;
        });
        return userList;
    }
}
