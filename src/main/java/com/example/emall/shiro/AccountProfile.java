package com.example.emall.shiro;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

}
