package com.shuangke.dao;

import com.shuangke.pojo.BankAccount;

import java.util.List;

public interface BankAccountDao {
    int setBalance(Integer accountId, double amount);
    Double getBalance(Integer accountId);
    List<BankAccount> getAllAccounts();
}
