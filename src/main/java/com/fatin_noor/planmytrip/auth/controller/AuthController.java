package com.fatin_noor.planmytrip.auth.controller;

import com.fatin_noor.planmytrip.auth.dto.RefreshRequest;
import com.fatin_noor.planmytrip.auth.dto.SignupRequest;
import com.fatin_noor.planmytrip.auth.dto.LoginRequest;
import com.fatin_noor.planmytrip.auth.dto.LoginResponse;
import com.fatin_noor.planmytrip.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@ModelAttribute @Valid SignupRequest user) {
        authService.registerUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshRequest refreshRequest) {
        LoginResponse response = authService.refreshToken(refreshRequest);
        return ResponseEntity.ok(response);
    }
}
