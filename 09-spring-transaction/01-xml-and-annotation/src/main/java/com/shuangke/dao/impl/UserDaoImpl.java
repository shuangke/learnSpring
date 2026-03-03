package com.shuangke.dao.impl;

import com.shuangke.pojo.User;
import com.shuangke.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int updateUserScoreById(Integer userId, Double score) {
        String sql = "update t_users set score = ? where id = ?";
        int affectedCounts = jdbcTemplate.update(sql, score, userId);
        return affectedCounts;
    }

    @Override
    public int saveUser(User user) {
        int affectedCounts = jdbcTemplate.update("insert into t_users values(NULL, ?, ?, ?)", user.getUsername(), user.getEmail(), user.getScore());
        return affectedCounts;
    }

    @Override
    public User selectUserById(Integer userId) {
        String sql = "select * from t_users where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return User.builder().id(rs.getInt("id"))
                        .score(rs.getDouble("score"))
                        .email(rs.getString("email"))
                        .username(rs.getString("username"))
                        .build();
            }
        });
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        String sql = "select * from t_users";
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return User.builder().id(rs.getInt("id"))
                        .score(rs.getDouble("score"))
                        .email(rs.getString("email"))
                        .username(rs.getString("username"))
                        .build();
            }
        });
        return users;
    }
}
