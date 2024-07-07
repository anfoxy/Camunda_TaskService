package com.example.dto;

import com.example.constant.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class UserDto {

    private Long id;

    private final String username;

    private String userLN;

    private String password;

    private String code;

    private String userFN;

    private Set<Role> roles;

    transient private String matchingPassword;

}