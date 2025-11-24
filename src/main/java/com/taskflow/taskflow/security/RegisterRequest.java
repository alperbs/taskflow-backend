package com.taskflow.taskflow.security;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
