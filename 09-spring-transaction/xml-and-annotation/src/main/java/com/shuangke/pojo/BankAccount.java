package com.shuangke.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {
    private Integer id;
    private String accountHolder;
    private Double balance;
}
