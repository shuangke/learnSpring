package com.shuangke.dao.impl;

import com.shuangke.dao.BankAccountDao;
import com.shuangke.pojo.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int setBalance(Integer accountId, double amount) {
        String sql = "UPDATE t_bank_account SET balance = ? WHERE id = ?";
        return jdbcTemplate.update(sql, amount, accountId);
    }


    @Override
    public Double getBalance(Integer accountId) {
        String sql = "SELECT balance FROM t_bank_account WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, accountId);
    }


    @Override
    public List<BankAccount> getAllAccounts() {
        String sql = "SELECT * FROM t_bank_account";
        return jdbcTemplate.query(sql,(rs, rc) -> {
            return BankAccount.builder().id(rs.getInt("id"))
                    .accountHolder(rs.getString("account_holder"))
                    .balance(rs.getDouble("balance"))
                    .build();
        });
    }
}
