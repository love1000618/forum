package com.tedu.forum.pojo.dto;

import lombok.Data;

@Data
public class UserLoginDto {
    private String username;
    private String password;
    private Boolean rem;
}
