package com.evelina.lab1.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
