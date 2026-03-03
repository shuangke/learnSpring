package com.shuangke;

import com.shuangke.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
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
        // Test if there is an exception when the balance is insufficient
        System.out.println("Before transfer:---------------");
        bankAccountService.showAllAccounts();

        Exception exception = assertThrows(Exception.class, () -> {
            bankAccountService.transfer(1, 2, Double.MAX_VALUE);
        });

        // Verify the exception message
        assertEquals("Insufficient balance", exception.getMessage());
        System.out.println("Exception caught: " + exception.getMessage());

        System.out.println("After failed transfer:---------------");
        bankAccountService.showAllAccounts();
    }

    @Test
    public void testTransferFailedAccountNotFoundCase() {
        System.out.println("Before transfer:---------------");
        bankAccountService.showAllAccounts();

        assertThrows(Exception.class, () -> {
            bankAccountService.transfer(1, 999, 100);
        });

        System.out.println("After failed transfer:---------------");
        bankAccountService.showAllAccounts();
    }
}
