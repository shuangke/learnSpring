package com.shuangke;

import com.shuangke.config.BankAccountConfig;
import com.shuangke.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(BankAccountConfig.class)
public class BankAccountTest {
    @Autowired
    private BankAccountService bankAccountService;

    @Test
    public void testTransferSuccessCase() {
        // 转账成功案例
        System.out.println("Before transfer:---------------");
        bankAccountService.showAllAccounts();
        bankAccountService.transfer(1, 2, 100);
        System.out.println("After transfer:---------------");
        bankAccountService.showAllAccounts();
    }

    @Test
    public void testTransferFailedInsufficientBalanceCase() {
        try {
            System.out.println("Before transfer:---------------");
            bankAccountService.showAllAccounts();
            bankAccountService.transfer(1, 2, Double.MAX_VALUE);
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        } finally {
            bankAccountService.showAllAccounts();
        }
    }

    @Test
    public void testTransferFailedAccountNotFoundCase() {
        try {
            System.out.println("Before transfer:---------------");
            bankAccountService.showAllAccounts();
            bankAccountService.transfer(1, 999, 100);
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        } finally {
            bankAccountService.showAllAccounts();
        }
    }
}
