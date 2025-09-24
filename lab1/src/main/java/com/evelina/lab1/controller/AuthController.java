package com.evelina.lab1.controller;

import com.evelina.lab1.dto.LoginRequestDto;
import com.evelina.lab1.dto.LoginResponseDto;
import com.evelina.lab1.service.AuthService;
import com.evelina.lab1.service.HtmlSanitizerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest){
        LoginResponseDto response = authService.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }
}

