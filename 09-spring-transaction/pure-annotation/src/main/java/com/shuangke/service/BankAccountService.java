package com.shuangke.service;

public interface BankAccountService {
    void transfer(Integer fromAccount, Integer toAccount, double amount);
    void showAllAccounts();
}
