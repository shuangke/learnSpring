package com.shuangke.service.impl;

import com.shuangke.dao.BankAccountDao;
import com.shuangke.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountDao bankAccountDao;

@Transactional(rollbackFor = Exception.class, noRollbackFor = FindException.class)
    @Override
    public void transfer(Integer fromAccount, Integer toAccount, double amount) {
        // fromAccount 减少 amount
        // check if account is valid and check if balance is sufficient
        Double fromAccountBalance = bankAccountDao.getBalance(fromAccount);
        if (fromAccountBalance < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        bankAccountDao.setBalance(fromAccount, fromAccountBalance - amount);

        // toAccount 增加 amount
        Double toAccountBalance = bankAccountDao.getBalance(toAccount);
        bankAccountDao.setBalance(toAccount, toAccountBalance + amount);
    }

    // 只读事务，查询账户信息
    @Transactional(readOnly = true)
    @Override
    public void showAllAccounts() {
        bankAccountDao.getAllAccounts().forEach(System.out::println);
    }
}
