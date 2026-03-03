package com.shuangke.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String email;
    private Double score;
}
