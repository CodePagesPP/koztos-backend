package com.example.koztos_backend.dto;

import lombok.Data;

@Data
public class UserCreateDTO {
    private String dni;
    private String username;
    private String name;
    private String lastName;
    private String sex;
    private String password;
    private String role;
}
