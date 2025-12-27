package com.fatin_noor.planmytrip.auth.dto;

public record LoginResponse(
    String accessToken,
    String refreshToken,
    String tokenType,
    String role,
    long expiresIn
) {}
